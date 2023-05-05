package com.bonc.migu.config.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;



@Data
@NoArgsConstructor
public class MyCustomException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;
    private String details;
    public MyCustomException(HttpStatus httpStatus, String message, String details) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
        this.details = details;
    }
    // getters and setters
}