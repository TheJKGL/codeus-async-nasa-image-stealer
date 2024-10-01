package com.practice.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;

@Setter
@Getter
public class Image {
    int id;
    int sol;
    @JsonProperty("img_src")
    String imageSource;

    long contentLength;
    URI originUri;
}
