package com.sample.controllers;

import com.sample.controllers.exceptions.BadInputFormatException;
import com.sample.controllers.exceptions.InputEmptyException;
import com.sample.controllers.exceptions.NotASetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ErrorHandler for the REST controller
 *
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({BadInputFormatException.class, NotASetException.class, InputEmptyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<String> handleBadInputException(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> resolveException() {

        return new ResponseEntity<String>("POST data was a bad format. Get sample at ap1/v1/sampleInput", HttpStatus.BAD_REQUEST);
    }
}
