package com.sample.service.parsers;

import com.sample.api.LongestCommonString;
import edu.umd.cs.findbugs.util.NotImplementedYetException;

import java.util.List;

/**
 * Searches for LongestCommonString only from the beginning of each string
 *
 */
public class LongestCommonStringFromStart implements LongestCommonString {
    public LongestCommonStringFromStart() {
    }

    @Override
    public List<String> process(List<String> input) {
        throw new NotImplementedYetException("Future development");
    }
}
