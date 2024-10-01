package com.practice.assignment.service;

import java.util.concurrent.ExecutionException;

public interface ImageStealerService {
    String findLargestMarsImageAsync(int sol);
    byte[] getSearchResult(String commandUuid) throws ExecutionException, InterruptedException;
}
