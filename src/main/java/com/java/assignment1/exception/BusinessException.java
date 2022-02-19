package com.java.assignment1.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private HttpStatus httpStatus;
    private String detail;

    public BusinessException(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
