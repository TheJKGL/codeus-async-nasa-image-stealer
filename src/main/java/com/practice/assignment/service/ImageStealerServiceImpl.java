package com.practice.assignment.service;

import com.practice.assignment.exception.CommandNotFoundException;
import com.practice.assignment.exception.CommandProcessingException;
import com.practice.assignment.model.Image;
import com.practice.assignment.model.ImageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class ImageStealerServiceImpl implements ImageStealerService {

    @Autowired
    private RestClient restClient;

    @Value("${service.nasa.url}")
    private String url;

    @Value("${service.api.key}")
    private String apiKey;

    private Map<String, CompletableFuture<byte[]>> commandStorage = new ConcurrentHashMap<>();

    @Override
    public String findLargestMarsImageAsync(int sol) {
        CompletableFuture<byte[]> completableFuture = CompletableFuture.supplyAsync(() -> {
            List<Image> imageList = Objects.requireNonNull(restClient.get()
                            .uri(buildUrl(sol))
                            .accept(APPLICATION_JSON)
                            .retrieve()
                            .body(ImageList.class))
                    .getPhotos();
            return findLargestImage(imageList);
        });
        String uuid = UUID.randomUUID().toString();
        commandStorage.put(uuid, completableFuture);
        return uuid;
    }

    @Override
    public byte[] getSearchResult(String commandUuid) throws ExecutionException, InterruptedException {
        if (!commandStorage.containsKey(commandUuid)) {
            throw new CommandNotFoundException("CommandUuid is not exists");
        }
        if (!commandStorage.get(commandUuid).isDone()) {
            throw new CommandProcessingException("Command is still running");
        }
        return commandStorage.get(commandUuid).get();
    }

    private byte[] findLargestImage(List<Image> imageList) {
        return imageList.parallelStream()
                .peek(image -> {
                    URI originUrl = restClient.get()
                            .uri(image.getImageSource())
                            .retrieve()
                            .toBodilessEntity()
                            .getHeaders()
                            .getLocation();
                    image.setOriginUri(originUrl);
                    long contentLength = restClient.head()
                            .uri(originUrl)
                            .retrieve()
                            .toBodilessEntity()
                            .getHeaders()
                            .getContentLength();
                    image.setContentLength(contentLength);
                })
                .max(Comparator.comparing(Image::getContentLength))
                .map(image -> restClient.get()
                        .uri(image.getOriginUri())
                        .retrieve()
                        .body(byte[].class))
                .orElseThrow();
    }

    private String buildUrl(int sol) {
        return String.format("%s?sol=%d&api_key=%s", url, sol, apiKey);
    }
}
