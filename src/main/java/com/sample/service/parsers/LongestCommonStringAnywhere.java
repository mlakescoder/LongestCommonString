package com.sample.service.parsers;

import com.sample.api.LongestCommonString;
import com.sample.controllers.exceptions.BadInputFormatException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Searches for the longestCommonString anywhere within the input strings.
 */
@Service
public class LongestCommonStringAnywhere implements LongestCommonString {

    public LongestCommonStringAnywhere() {
    }

    @Override
    public List<String> process(List<String> inputStrings) throws BadInputFormatException {
        if ( inputStrings == null ) {
            throw new BadInputFormatException("No data was provided");
        }

        List<String> results = new ArrayList<>();

        // If only one string, then the whole thing is in common
        if ( inputStrings.size() == 1 ) {
            results.add(inputStrings.get(0));
            return results;
        }

        int numberCharsMatched = 0;
        StringBuilder sb = new StringBuilder();

        // Loop through the characters of the first string, using it as the search string in others
        for ( int startIndex = 0; startIndex + sb.toString().length() < inputStrings.get(0).length();  ) {

            sb.append(inputStrings.get(0).toCharArray()[startIndex + sb.toString().length()]);

            // Loop through other strings
            int foundStringCount = 0;
            for ( int stringIndex = 1; stringIndex < inputStrings.size(); stringIndex ++ ) {

                // Loop from the front of each string
                Boolean found = false;
                for ( int innerStartIndex = 0; innerStartIndex < inputStrings.get(stringIndex).length() && !found ; innerStartIndex++ ) {

                    // Looping from the back as well
                    for ( int innerEndIndex = inputStrings.get(stringIndex).length();
                          innerEndIndex > 0 && innerEndIndex > innerStartIndex && !found;
                          --innerEndIndex )
                    {

                        String candidateString = inputStrings.get(stringIndex).substring(innerStartIndex, innerEndIndex);

                        if ( candidateString.equals(sb.toString()) ) {
                            // Found one
                            foundStringCount++;
                            found = true;
                        }
                    }
                }
            }

            if ( foundStringCount == inputStrings.size() - 1) {
                // Was found in all strings
                if ( sb.toString().length() > numberCharsMatched ) {
                    numberCharsMatched = sb.toString().length();
                }

                results.add(sb.toString());
            } else {
                if ( sb.toString().length() > 1 ) {
                    startIndex = startIndex + sb.length() - 1;
                } else {
                    startIndex += 1;
                }
                sb = new StringBuilder();
            }

        }


        // Only return the greatest matches
        final int desiredNumberCharsMatched = numberCharsMatched;

        // return the results, alphabetized
        return results.stream().filter( s -> s.length() == desiredNumberCharsMatched).sorted(new SortAlphabeticallyComparator()).collect(Collectors.toList());
    }
}
