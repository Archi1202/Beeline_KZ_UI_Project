# Beeline Kazakhstan - QA Automation engineer <img align="center" src="src/test/resources/BeelinePeopleLogo.png" width="50" height="50"/>

Automated tests for the [Beeline Kazakhstan](https://beeline.kz) website, focusing on navigation, element visibility, and redirection to the **Вакансии и карьера в Beeline**, where QA positions are displayed.

**Beeline Main Page**

<img align="center" src="src/test/resources/BeelineKZPage.png" width="650" height="350"/>

**Beeline People Page**

<img align="center" src="src/test/resources/Beeline People page.png" width="650" height="350"/>

## Features

- **Automation Framework**: [Selenide](https://selenide.org) with Java
- **Testing**: JUnit5 for structured testing
- **Reporting**: [Allure Reports](https://docs.qameta.io/allure/)
- **CI/CD**: Jenkins for automated test execution under the specific parameters
- **Notifications**: Telegram for real-time alerts on test results
- **Video Recordings**: Selenoid to capture test execution videos

<p align="left">
<img align="center" src="src/test/resources/java-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/selenide-logo-big.png" width="40" height="40"/>
<img align="center" src="src/test/resources/intellij-original.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/gradle-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/junit-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/Allure Report icon.png" width="80" height="50"/>
<img align="center" src="src/test/resources/jenkins.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/Telegram_logo.svg.webp" width="40" height="40"/>
<img align="center" src="src/test/resources/github-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/selenoid icon.svg" width="40" height="40"/>
</p>

---

## Table of Contents

1. [Test Cases](#test-cases)
2. [Allure Reports](#allure-reports)
3. [Telegram Notifications](#telegram-notifications)
4. [Test Execution Video from Selenoid](#test-execution-video-from-selenoid)

---

## Test Cases

| ID   | Test Case Description                                             | Expected Result                                                                                                                      |
|------|-------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| TC01 | **Verify that 'WhatsUp' and 'Telegram' displays on Main page"**   | Support buttons visible for user on the [Beeline Main Page](https://beeline.kz).                                                     |
| TC02 | **Language and Location verification on the Main Page**           | Verify that user is able to change the Language to RU and Location to Astana.                                                      |                                                                   |                                                                                                                                      |
| TC03 | **'Вакансии и карьера в Beeline' displays on the main page**      | Ensures the "Вакансии и карьера в Beeline" link exists in the specified footer section.<br/>The hyperlink is visible and accessible. |
| TC04 | **Beeline People Page accessible from Main Page**                 | Check that user is able scroll down to the positions section and open [Beeline People Page](https://people.beeline.kz).              |
| TC05 | **Search QA Automation Engineer Position in Beeline People Page** | Ensures that Beeline People can be opened from Main Page, search for QA Automation engineer and able to open details of position.    |

---

## Allure Reports

Allure Reports provide clear insights into test results, including success/failure rates, test durations, and individual test steps. The report is generated after each test run and is accessible via Jenkins or as a standalone HTML report.

To view Allure reports:
1. Execute tests to generate the report: `mvn clean beeline_test`
2. Generate the Allure report: `allure serve target/allure-results`

**Example of Allure Report:**

<img align="center" src="src/test/resources/Allure Report view.png" width="600" height="250"/>


**Example of Test Case Steps from Allure Report (#5):**

<img align="center" src="src/test/resources/Steps of 5th test case.png" width="400" height="300"/>

---

## Telegram Notifications

Real-time notifications are set up via a Telegram bot, alerting the team on test completion and results:
- Pass/Fail status
- Summary of tests executed, including failed tests
- Quick links to detailed reports

**Telegram Notification for Beeline KZ**  

<img align="center" src="src/test/resources/Telegram Notification BeelineKZ.png" width="500" height="400"/>

---

## Test Execution Video from Selenoid

Selenoid is used for cross-browser testing and video recording, enabling real-time playback for test executions to aid in debugging and verification.

1. Each test execution is recorded.
2. Videos are stored and can be accessed in Jenkins or a specified server path.

**Example Test Execution Video:**

https://github.com/user-attachments/assets/01435b3b-6273-4222-bdfe-4ede61402566

---
