LongestCommonString Coding Exercise
Pete T

QUICK START:
=======================================
- TO BUILD:
     maven clean package

- TO RUN UNIT TESTS
     maven verify

- TO RUN THE APPLICATION:
     java -jar target/LongestCommonString-1.0-SNAPSHOT.jar



PROJECT TOUR:
=========================================
<repository>/src/main/java/com/toich
   |
   + api - contains interfaces and dtos for the project
   |
   + controllers - contains the rest controller and error/response handlers
   |
   + service - contains the services that are injected into the controller
   |    |
   |    + parsers - contains the factory and implementations for LongestCommonString implementations
   |    |
   |    + validation - contains the factory and implementations of the validation used by the controller
   |
   + Application - the main class


<repository>/src/test/groovy/com
   |
   + parsers - unit tests for the LongestCommonString implementations
   |
   + validation - unit tests for the input validation implementations


<repository>/postman - postman collection to test the REST controller


NOTES:
==================================================
Here are some things I hope to add soon
1. Add swagger interface for the rest controller
2. Allow the user to specify on the command line on the application:
   a. the type of validation to use
   b. the LongestStringImplementation to use (instead of it being injected)
3. Add newman to the pom and have it run the integration tests automatically
4. Add implementation for validation that doesn't allow capitalization
5. Add implementation for parser which ignores capitalization when it searches

