package com.practice.assignment.controller;

import com.practice.assignment.service.ImageStealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("mars/pictures/largest")
public class ImageStealerController {

    @Autowired
    private ImageStealerService imageStealerService;

    @PostMapping("/sol/{sol}")
    public String arrangeAsyncSearch(@PathVariable int sol) {
        return imageStealerService.findLargestMarsImageAsync(sol);
    }

    @GetMapping(value = "/command/{commandUuid}", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getSearchResult(@PathVariable String commandUuid) throws ExecutionException, InterruptedException {
        return imageStealerService.getSearchResult(commandUuid);
    }
}
