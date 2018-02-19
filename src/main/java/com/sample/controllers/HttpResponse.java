package com.sample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Generic response container for http responses
 */
public class HttpResponse {
    public static <T> ResponseEntity<T> ok(T model) {
        return new ResponseEntity(model, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> badRequest(T model ) {
        return new ResponseEntity<T>(model, HttpStatus.BAD_REQUEST);
    }

}
