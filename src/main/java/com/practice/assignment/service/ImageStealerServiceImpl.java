package com.practice.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.concurrent.ExecutionException;

@Service
public class ImageStealerServiceImpl implements ImageStealerService {

    @Autowired
    private RestClient restClient;

    @Value("${service.nasa.url}")
    private String url;

    @Value("${service.api.key}")
    private String apiKey;

    /**
     * Asynchronously initiates a search for the largest image from the specified Mars mission day (sol).
     * It triggers the search process and returns a unique commandUuid to track the operation.
     *
     * @param sol (Mars mission day) for which to find the largest image.
     * @return A unique identifier (commandUuid) for the search process, which can be used to retrieve the result later.
     */
    @Override
    public String findLargestMarsImageAsync(int sol) {
        throw new RuntimeException("Not Implemented");
    }

    /**
     * Retrieves the search result for the largest image from the asynchronous search initiated with the provided commandUuid.
     * Should gracefully handle situation when the task is not completed. Use custom exception in this case.
     * Also, please note that there is redirect when you request image by it`s imageSource, so you should think how to deal with it.
     *
     * @param commandUuid A unique identifier for the asynchronous image search.
     * @return byte[]: The binary data of the largest image found.
     */
    @Override
    public byte[] getSearchResult(String commandUuid) throws ExecutionException, InterruptedException {
        throw new RuntimeException("Not Implemented");
    }
}
