package com.practice.assignment.exception;

public class CommandStillProcessingException extends RuntimeException {
    public CommandStillProcessingException(String message) {
        super(message);
    }
}
