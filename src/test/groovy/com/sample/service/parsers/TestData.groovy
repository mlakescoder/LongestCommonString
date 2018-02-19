package com.sample.service.parsers

public class TestData {
    private List<String> inputStrings
    private Set<String> resultStrings

    public TestData(List<String> input, Set<String> output ) {
        inputStrings = input
        resultStrings = output
    }

    List<String> getInputStrings() {
        return inputStrings
    }

    Set<String> getResultStrings() {
        return resultStrings
    }
}
