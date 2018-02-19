package com.sample.api;

import com.sample.controllers.exceptions.BadInputFormatException;

import java.util.List;

/**
 * Interface for implementations of the LongestCommonString implementations
 */
public interface LongestCommonString {

    List<String> process(List<String> input) throws BadInputFormatException;


}
