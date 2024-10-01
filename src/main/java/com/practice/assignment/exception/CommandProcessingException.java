package com.practice.assignment.exception;

public class CommandProcessingException extends RuntimeException {
    public CommandProcessingException(String message) {
        super(message);
    }
}
