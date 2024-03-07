# ClockSystem

![Build badge](https://github.com/VionFrancois/ClockSystem/actions/workflows/gradle.yml/badge.svg)

![PMD Badge](https://github.com/VionFrancois/ClockSystem/actions/workflows/pmd.yml/badge.svg)

![CodeQL Badge](https://github.com/VionFrancois/ClockSystem/actions/workflows/codeql.yml/badge.svg)

This is a gradle-based Java project for a Clock with Swing GUI and JUnit5 unit tests. It has been created and used by Tom Mens for educational purposes at the University of Mons.

The application includes a watch, with timer, stopwatch and alarm functionality.
Its implementation is based on a statechart, using the state and singleton design patterns.


## Instructions

The application has been tested locally with Java 21 and Gradle 8.5 (on MacOS). To run it locally, download the latest release and run the following command-line instructions, assuming you have already gradle installed on your machine:

"gradle wrapper" (creates the necessary gradle wrapper files to be able to build the app with gradle).

"./gradlew build" (executes the generated wrapper to build and test the application; build should be successful, but will fail if some of the unit tests fail)

"./gradlew run" (executes the Java application by opening a graphical user interface you can interact with)
