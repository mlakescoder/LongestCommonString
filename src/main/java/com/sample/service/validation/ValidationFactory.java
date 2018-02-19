package com.sample.service.validation;

import com.sample.api.InputValidation;

public class ValidationFactory {
    public enum VALIDATION_TYPE {
        UNIQUE_NOT_EMPTY, START, END
    }

    public static InputValidation getValidationImpl(VALIDATION_TYPE validationType) {
        if ( validationType == null ) {
            throw new IllegalArgumentException("Validation type not specified");
        }

        if ( validationType.equals(VALIDATION_TYPE.UNIQUE_NOT_EMPTY) ) {
            return new NotEmptyAndUniqueInputValidation();
        }


        throw new IllegalArgumentException("Validation type " + validationType.toString() + " is unknown");
    }

}
