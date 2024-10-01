package com.practice.assignment.controller;

import com.practice.assignment.exception.CommandNotFoundException;
import com.practice.assignment.exception.CommandProcessingException;
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
    @ExceptionHandler(CommandProcessingException.class)
    public ExceptionResponse handleExceptions(CommandProcessingException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    public record ExceptionResponse(String message){ }
}
