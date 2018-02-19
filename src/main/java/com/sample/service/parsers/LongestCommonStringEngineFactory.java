package com.sample.service.parsers;

import com.sample.api.LongestCommonString;

/**
 * Provides implementations for the LongestCommonString
 */
public class LongestCommonStringEngineFactory {

    public enum LCS_ENGINE_TYPE {
        ANYWHERE, START, END
    }

    public static LongestCommonString getLongestCommonStringImpl(LCS_ENGINE_TYPE engineType) {
        if ( engineType == null ) {
            throw new IllegalArgumentException("Engine type not specified");
        }

        if ( engineType.equals(LCS_ENGINE_TYPE.ANYWHERE) ) {
            return new LongestCommonStringAnywhere();
        }
        else if ( engineType.equals(LCS_ENGINE_TYPE.START)) {
            return new LongestCommonStringFromStart();
        }

        throw new IllegalArgumentException("LCS Engine type " + engineType.toString() + " is unknown");
    }
}
