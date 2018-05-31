# SeleniumJava
Basic source code for learning web automation tests using Selenium. This repository is intended to be extensible, yet able to run tests quickly.

Requirements:
- Eclipse/IntelliJ
- Git
- Java JDK 8
- Maven

## First time run
1. Clone this repo
2. In project root directory, run this command `mvn clean test`. This command should download all necessary plugins and run unit tests

## How to run Selenium tests
1. Right-click on `src/test/resources/testcases/TestGoogleHomePage.xml` > `Run as TestNG` if in Eclipse or just `Run` in IntelliJ
2. Observe Chrome browser being launched and execute test steps 
3. Test results can be seen in `test-output` directory

## How to run API tests
1. Right-click on `src/test/resources/testcases/TestApiLogin.xml`
2. This will start a mock-server listening in port `1080`, expecting a sample `login` request

## Possible extensions
Some of extensions which many testers do:
- Better reporting and statistics using third-party library like ExtentReport
- Behavior Driven Development tests using Cucumber BDD framework
- Scaling tests using SeleniumGrid
- API testing/scaffolding using RestAssured
- Packaging source code into executable JAR for easy deploy-and-execute
- etc...