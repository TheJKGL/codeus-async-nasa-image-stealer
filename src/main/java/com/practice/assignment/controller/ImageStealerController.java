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
public class ImageStealerController {

    @Autowired
    private ImageStealerService imageStealerService;

    //todo: Provide right request mapping
    public String arrangeAsyncSearch(int sol) {
        throw new RuntimeException("Not Implemented");
    }

    //todo: Provide right response mapping and MediaType for byte[].
    private byte[] getSearchResult(String commandUuid) throws ExecutionException, InterruptedException {
        throw new RuntimeException("Not Implemented");
    }
}
