package com.bonc.migu.config.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String details;
    public ErrorDetails(HttpStatus status, String message, String details) {
        super();
        this.status = status;
        this.message = message;
        this.details = details;
    }
    // getters and setters
}