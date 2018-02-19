package com.sample;

import com.sample.api.InputValidation;
import com.sample.api.LongestCommonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private LongestCommonString longestCommonString;

    private InputValidation inputValidation;

    @Autowired
    public Application(LongestCommonString longestCommonString, InputValidation inputValidation ) {
        this.longestCommonString = longestCommonString;
        this.inputValidation = inputValidation;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}