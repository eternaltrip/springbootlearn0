package com.bonc.migu.config.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//@Configuration
//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<Object> handleMyCustomException(MyCustomException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getHttpStatus(), ex.getMessage(), ex.getDetails());
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), ex.getHttpStatus(), request);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, "参数校验失败", ex.getBindingResult().getFieldErrors().toString());
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, "请求体解析失败", ex.getMessage());
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, "响应体序列化失败", ex.getMessage());
        return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }






}

