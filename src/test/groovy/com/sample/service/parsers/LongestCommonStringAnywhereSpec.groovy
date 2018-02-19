package com.sample.service.parsers

import com.sample.api.LongestCommonString
import spock.lang.Specification;


class LongestCommonStringAnywhereSpec extends Specification {
    LongestCommonString longestCommonStringAnywhere

    def setup() {
        longestCommonStringAnywhere = LongestCommonStringEngineFactory
                                                .getLongestCommonStringImpl(LongestCommonStringEngineFactory.LCS_ENGINE_TYPE.ANYWHERE)
    }

    def "No result all unique"() {
        given:
        TestData testData = TestDataGenerator.getNoResult()

        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results.size() == testData.getResultStrings().size()
    }

    def "One result in beginning"() {
        given:
        TestData testData = TestDataGenerator.getOneResultInBeginning()

        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results == testData.getResultStrings()
    }

    def "One result in middle"() {
        given:
        TestData testData = TestDataGenerator.getOneResultInMiddle()


        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results == testData.getResultStrings()

    }

    def "One result at end"() {
        given:
        TestData testData = TestDataGenerator.getOneResultInEnd()

        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results == testData.getResultStrings()
    }

    def "Two results"() {
        given:
        TestData testData = TestDataGenerator.getTwoResult()

        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results == testData.getResultStrings()
    }

    def "Discard shorted matches"() {
        given:
        TestData testData = TestDataGenerator.getTwoResultOverlap()

        when:
        Set<String> results = longestCommonStringAnywhere.process(testData.getInputStrings())

        then:
        results == testData.getResultStrings()
    }

}