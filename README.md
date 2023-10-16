# CRISP_QA

# [CRISP Assignment]

The following document is a description of the test structure and instructions to running the tests.

## Structure

*resources directory contains feature files with test cases written in Gherkin language;
*stepDefinitions package contains the automated test cases, positive and negative paths. 
     TestCase1
     TestCase2
     TestCase3
     TestCase3_1 - is a different way of solving the same third test case
     NegativePath1
     NegativePath1_1 -is a different way of solving the same first negative test case
     NegativePath2
*runner package has the Runner class from Cucumber, which pulls together the feature files and the tests themselves;
*I also created a testData package with a class where I stored all the patients in a Map data structure, I was going to reuse the data in a test class, but ended up going a different route and kept the testData class for demonstrative purposes.

## Framework

In this assignment I am using a Cucumber BDD framework. For some of the tests (Test Case 1, Test Case 3 and Negative Path 1) I am using JUnit plugin for annotations. 

The API test automation is written using the RestAssured library, Hamcrest Matchers for assertions and the Jackson library for JSON deserialization. Java is the programming language that ties it all together.

To avoid hardcoding I've used parameterisation and Scenario Outlines in the feature files

## Running the tests

For demonstrative purposes I have used two different approaches, therefore there are two different ways to run those tests.

### TEST CASE 1, TEST CASE 3 and NEGATIVE PATH 1

Those three tests can be run from the test classes themselves: TestCase1, TestCase3 and NegativePath1. 
The @Test annotation allows running the test directly from the class where the code is implemented.

### TEST CASE 2, TEST CASE 3_1, NEGATIVE PATH 1_1, and NEGATIVE PATH 2

Those four tests can be run all together from the Runner class.
You can also run them seperately using tags if you have the same tag in a feature file and in the Runner class.
I highly recommend using the Runner class, however Cucumber does offer the option of running each feature file. I have noticed that Cucumber is having a hard time connecting the tests this way and does not recognize step definitions.




