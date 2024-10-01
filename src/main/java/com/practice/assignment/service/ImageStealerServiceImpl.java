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

    @Override
    public String findLargestMarsImageAsync(int sol) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public byte[] getSearchResult(String commandUuid) throws ExecutionException, InterruptedException {
        throw new RuntimeException("Not Implemented");
    }
}
