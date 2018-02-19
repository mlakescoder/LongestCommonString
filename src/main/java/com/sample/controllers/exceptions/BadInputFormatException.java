package com.sample.controllers.exceptions;

public class BadInputFormatException extends Exception {
    public BadInputFormatException(String message) {
        super(message);
    }
}
