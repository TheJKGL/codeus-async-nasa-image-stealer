package com.practice.assignment.controller;

import com.practice.assignment.exception.CommandNotFoundException;
import com.practice.assignment.exception.CommandStillProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CommandNotFoundException.class)
    public ExceptionResponse handleException(CommandNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CommandStillProcessingException.class)
    public ExceptionResponse handleExceptions(CommandStillProcessingException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    public record ExceptionResponse(String message){ }
}
