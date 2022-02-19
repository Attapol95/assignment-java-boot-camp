package com.java.assignment1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> handleApiRequestException(BusinessException e) {
        var exception = ApiExceptionModel.builder()
                .message(e.getDetail())
                .httpStatus(e.getHttpStatus())
                .timeStamp(ZonedDateTime.now(ZoneId.of("Asia/Bangkok")))
                .build();

        return new ResponseEntity<>(exception, e.getHttpStatus());
    }
}