package com.sample.service.parsers

/**
 * Provides input strings and answers
 */
class TestDataGenerator {

    public static TestData getNoResult() {
        TestData testData = new TestData(["larry", "Moe", "curly"], [] as Set<String>)
        return  testData
    }

    public static TestData getOnlyOneEntry() {
        TestData testData = new TestData(["fly eagles fly"], ["fly eagles fly"] as Set<String>)
        return  testData
    }

    public static TestData getOneResultInBeginning() {
        TestData testData = new TestData(["comet", "communicate", "commutation"], ["com"] as Set<String>)
        return  testData
    }

    public static TestData getOneResultInMiddle() {
        TestData testData = new TestData(["caster", "crewandcast", "broadcaster"], ["cast"] as Set<String>)
        return  testData
    }

    public static TestData getOneResultInEnd() {
        TestData testData = new TestData(["relation", "reputation", "computation"], ["ation"] as Set<String>)
        return  testData
    }

    public static TestData getTwoResult() {
        TestData testData = new TestData(["dogmousecat", "dogacat", "moosedogcat","catdograccoon"], ["cat", "dog"] as Set<String>)
        return  testData
    }

    public static TestData getTwoResultOverlap() {
        TestData testData = new TestData(["dogcatmouse", "catamouse", "mousecatdogmoose"], ["mouse"] as Set<String>)
        return  testData
    }
}
