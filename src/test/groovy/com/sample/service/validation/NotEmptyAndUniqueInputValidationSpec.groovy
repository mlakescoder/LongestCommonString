package com.sample.service.validation

import com.sample.controllers.exceptions.InputEmptyException
import com.sample.controllers.exceptions.NotASetException;
import spock.lang.Specification;


class NotEmptyAndUniqueInputValidationSpec extends Specification {
    NotEmptyAndUniqueInputValidation notEmptyAndUniqueInputValidation

    def setup() {
        notEmptyAndUniqueInputValidation = ValidationFactory.getValidationImpl(ValidationFactory.VALIDATION_TYPE.UNIQUE_NOT_EMPTY)
    }

    def "Empty String"() {
        given:
        def inputStrings = ["    ",
                            "comcast",
                            "comcastic"]


        when:
        notEmptyAndUniqueInputValidation.validate(inputStrings)

        then:
        InputEmptyException ex = thrown()
        ex.message == 'String input values cannot be empty or blank'

    }

    def "Not Unique Input"() {
        given:
        def inputStrings = ["comcast",
                            "comcastic",
                            "communicate",
                            "comcast"]

        when:
        notEmptyAndUniqueInputValidation.validate(inputStrings)

        then:
        NotASetException ex = thrown()
        ex.message == 'Input values must be unique!'

    }

    def "Good set"() {
        given:
        def inputStrings = ["comcast",
                            "comcastic",
                            "broadcaster"]
        when:
        notEmptyAndUniqueInputValidation.validate(inputStrings)

        then:
        notThrown Exception

    }





}