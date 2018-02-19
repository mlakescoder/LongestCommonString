package com.sample.service.validation;

import com.sample.api.InputValidation;
import com.sample.controllers.exceptions.BadInputFormatException;
import com.sample.controllers.exceptions.InputEmptyException;
import com.sample.controllers.exceptions.NotASetException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Checks that the input strings are not empty and are unique
 */
@Service
public class NotEmptyAndUniqueInputValidation implements InputValidation {



    public void validate(List<String> inputStrings) throws BadInputFormatException, InputEmptyException, NotASetException {

        Set<String> processedStrings = new HashSet<>();

        for ( String value : inputStrings ) {

            if ( processedStrings.contains(value) ) {
                throw new NotASetException("Input values must be unique!");
            }

            if ( StringUtils.isBlank(value) ) {
                throw new InputEmptyException("String input values cannot be empty or blank");
            }

            processedStrings.add(value);
        }
    }
}
