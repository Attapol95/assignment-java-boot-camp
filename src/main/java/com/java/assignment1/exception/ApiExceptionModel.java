package com.java.assignment1.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionModel {

    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timeStamp;
}