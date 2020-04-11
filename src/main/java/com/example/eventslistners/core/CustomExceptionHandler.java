package com.example.eventslistners.core;

import com.example.eventslistners.exceptions.EmailAlreadyExistsException;
import com.example.eventslistners.util.Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String messageUser      = "Invalid request. Please, check the information sent";
        String messageDeveloper = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
        return handleExceptionInternal(ex, create(HttpStatus.BAD_REQUEST.value(), ErrorDetail.of(messageUser, messageDeveloper)), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, createErrorList(ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
        String messageUser      = "Resource not found";
        String messageDeveloper = "The resource '" + Util.getResourcePath(request) + "' you are trying to access doesn't exist";
        return handleException(ex, create(HttpStatus.NOT_FOUND.value(), ErrorDetail.of(messageUser, messageDeveloper)), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({EmailAlreadyExistsException.class})
    public ResponseEntity<Object> handleEmailAlreadyExists(EmailAlreadyExistsException ex, WebRequest request){
        String messageUser      = "This email is being used. Please, choose another one.";
        String messageDeveloper = ex.getMessage();
        ResponseEntity<Object> objectResponseEntity = handleException(ex, create(HttpStatus.BAD_REQUEST.value(), ErrorDetail.of(messageUser, messageDeveloper)), HttpStatus.NOT_FOUND, request);
        return objectResponseEntity;
    }

    private ResponseEntity<Object> handleException(Exception exception, Object body, HttpStatus httpStatus, WebRequest webRequest) {
        return handleExceptionInternal(exception, body, new HttpHeaders(), httpStatus, webRequest);
    }

    private Error createErrorList(MethodArgumentNotValidException ex){
        List<ErrorDetail> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach( fieldError -> {
            String messageUser      = "The provided value on field '"+fieldError.getField()+"' is not allowed. Rejected value: "+fieldError.getRejectedValue();
            String messageDeveloper = fieldError.toString();
            errors.add(ErrorDetail.of(messageUser, messageDeveloper));
        });
        return create(HttpStatus.BAD_REQUEST.value(), errors);
    }

    private Error create(int value, List<ErrorDetail> details){
        return Error.of(value, details);
    }

    private Error create(int value, ErrorDetail detail){
        return create(value, Collections.singletonList(detail));
    }

}
