package com.baloise.springfundamentals.handson.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class PizzaExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ProblemDto> handleIllegalStateException(IllegalStateException exception, WebRequest request) {
        return ResponseEntity.status(BAD_REQUEST)
                .body(new ProblemDto("IllegalState", exception.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDto> handleIllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
        return ResponseEntity.status(NOT_FOUND)
                .body(new ProblemDto("IllegalArgument", exception.getMessage()));
    }
}
