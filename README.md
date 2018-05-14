# Summary workshop from the Automated testing for Android app with Java

How to run ?
```
# Run Unit test
$./gradlew test

# Run UI test
$./gradlew cAT

# Run with coverage report
$./gradlew fullCoverageReport

# Run with Fastlane screengrab
$./gradlew clean assembleDebug assembleAndroidTest
$fastlane screengrab
```

### Day 1
0. Introduction Android testing in Android Studio
1. Unit testing with JUnit 4
    * Basic of JUnit
    * Create first unit test
    * TDD (Test-Driven Development)
    * Run Unit test from Android Studio
    * Run Unit test from command-line and see result in HTML fotmat
    * Try to run code coverage with Jacoco

2. UI testing with Espresso
    * Basic of Espresso for UI Testing
    * Create first tests
    * Run UI test from Android Studio
    * Run UI test from command-line and see result in HTML fotmat
    * Try to run code coverage
    * Combine the code coverage result from UI and Unit test

3. Capture screen with Fastlane screengrab


### Day 2
1. Run monkey testing
2. Add more tests for new features (Test-Driven Development)
3. Working with REST APIs (Retrofit and OkHTTP)
4. How to testing with REST APIs ? (MockWebServer vs Stubby4J vs Real API)
5. Testable application (Refactor with confidene)
6. Working with Continuous Integration (Jenkins)
