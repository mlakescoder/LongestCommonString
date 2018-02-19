package com.sample.api;

import com.sample.controllers.exceptions.BadInputFormatException;
import com.sample.controllers.exceptions.InputEmptyException;
import com.sample.controllers.exceptions.NotASetException;

import java.util.List;

/**
 * Interface for validation implemenations.
 *
 */
public interface InputValidation {
    void validate(List<String> inputStrings) throws BadInputFormatException, InputEmptyException, NotASetException;
}
