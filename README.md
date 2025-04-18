## SauceDemo Login Automation Test

This repository contains an automated login test for SauceDemo website (https://www.saucedemo.com/).

**NOTE:** This repository is created solely for demonstration and testing purposes. All credentials and user data used in this project are publicly available and are intended only for test purposes. No sensitive or proprietary information is included.  

## Features
- **Automated Login Process:** Tests for various user roles and scenarios as provided on the website.
- **Assertions:** Validates successful login and error messages.
- **BDD-Style Scenarios:** Defined using Cucumber (Gherkin syntax).
- **Test Execution:** Managed with TestNG, including parallel testing.
- **Page Object Model (POM):** Clean separation of test logic and page interactions.
- **Dynamic Browser Support:** Configurable for Chrome and Edge using Maven parameters.
- **Allure Reporting:** Generates detailed test reports
- **Configuration Management:** Using `config.properties` and Maven parameters.
- **Version Control:** Managed using Git.

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Cucumber (Gherkin)
- Allure Reports
- Maven

## Prerequisites
- **Java Development Kit (JDK)** (version 8 or later; JDK 22 is used in this project as per the `pom.xml` configuration)
- **Apache Maven** (for build and dependency management)
- **Google Chrome** and/or **Microsoft Edge** (depending on which browser(s) you wish to test)
- A compatible IDE (e.g., IntelliJ IDEA, Eclipse) is recommended for editing the code.

### Excel Test Report
- **File Name**: `Login Data test report.xlsx`
- **Location**: TestReport directory in the Root path
- **Description**: This Excel file contains detailed test results for the login functionality. It includes information such as:
    - Test name
    - Status (Pass/Fail)
    - Duration
    - Start and Stop times
    - And other relevant details

## Installation and Setup
1. **Clone this repository**:
   ```bash
   - git clone https://github.com/jofel06/SauceDemoAutomation
   - cd SauceDemoLoginAutomation

3. **Build the Project**:
   - This project uses Maven for build automation.  To build the project and download dependencies, run the following command:
     ```bash
     - mvn clean install
   - This will compile the code, download the necessary libraries (as defined in the pom.xml), and prepare the project for testing.

## How to Run the Tests

**You can run the tests using Maven commands. The project supports dynamic browser configuration.**
  - **To run tests in Chrome:**
    ```bash
    - mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/chrome-testng.xml" 
  - **To run tests in Edge**:
    ```bash
    - mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/edge-testng.xml" 
  - **To run test in Parallel, both Edge and Chrome**
     ```bash
     - mvn test
     ```
    or
     ```bash
     - mvn test "-Dsurefire.suiteXmlFiles=src/test/resources/testng_suites/testng.xml"


## Test Scenarios (Gherkin)

**Below are the Gherkin syntax used in the login.feature file to define the login test scenarios:**
```gherkin
Feature: Login

  As a user, I want to log in to the Saucedemo website

  @regression @standard
  Scenario: Login with standard_user
    Given User is on the Saucedemo login page
    When User logs in as "standard_user"
    Then User should be logged in normally

  @regression @locked
  Scenario: Login with locked_out_user
    Given User is on the Saucedemo login page
    When User logs in as "locked_out_user"
    Then User should see the error message "Epic sadface: Sorry, this user has been locked out."

  @regression @problem
  Scenario: Login with problem_user
    Given User is on the Saucedemo login page
    When User logs in as "problem_user"
    Then User should be logged in successfully

  @regression @performance
  Scenario: Login with performance_glitch_user
    Given User is on the Saucedemo login page
    When User logs in as "performance_glitch_user"
    Then User should be logged in successfully

  @regression @error
  Scenario: Login with error_user
    Given User is on the Saucedemo login page
    When User logs in as "error_user"
    Then User should be logged in successfully

  @regression @visual
  Scenario: Login with visual_user
    Given User is on the Saucedemo login page
    When User logs in as "visual_user"
    Then User should be logged in successfully
```

## Test Report
- **Allure is used for reporting. The Allure report provides a detailed overview of the test execution, including:**
    - Test results (passed, failed, etc.)
    - Test execution time
    - Steps involved in each test
     
### Generate and View the Report

**Option 1: Quick Temporary Report**

Use this for a quick preview after a test run:
```bash
allure serve target/allure-results
```
**Option 2: Permanent Report**

Use this to generate a static, shareable HTML report:
  ```bash
  - allure generate target/allure-results -o target/allure-report --clean
   ```
Then view the report using:
 ```bash
  - allure open target/allure-report
   ```

## Configuration
- The config.properties file in the src/test/resources/ directory allows you to configure the application URL.
- It contains:
    ```ini
    - base.url=https://www.saucedemo.com/
    - browser=chrome

## References
- All references used to create this automation test framework are stored at **references.md** in the root path. 
 

## Disclaimer

**This repository is for exam and demonstration purposes only. All user data and credentials are publicly available and are used solely for test purposes. No sensitive information is contained herein.**


