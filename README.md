# Beeline Kazakhstan - UI Project for QA.GURU <img align="center" src="src/test/resources/BeelinePeopleLogo.png" width="50" height="50"/>

Automated tests for the [Beeline Kazakhstan](https://beeline.kz) website, focusing on navigation, elements visibility, 
**Вакансии и карьера в Beeline**.

**Beeline Main Page**

<img align="center" src="src/test/resources/images/icons/BeelineKZPage.png" width="650" height="350"/>

**Beeline People Page**

<img align="center" src="src/test/resources/images/icons/Beeline People page.png" width="650" height="350"/>

## Features

- **Automation Framework**: [Selenide](https://selenide.org) with Java
- **Testing**: JUnit5 for structured testing
- **Reporting**: [Allure Reports](https://docs.qameta.io/allure/)
- **CI/CD**: Jenkins for automated test execution under the specific parameters
- **Notifications**: Telegram for real-time alerts on test results
- **Video Recordings**: Selenoid to capture test execution videos

<p align="left">
<img align="center" src="src/test/resources/images/icons/java-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/selenide-logo-big.png" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/intellij-original.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/gradle-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/junit-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/Allure Report icon.png" width="80" height="50"/>
<img align="center" src="src/test/resources/images/icons/jenkins.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/screens/Telegram_logo.svg.webp" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/github-original-wordmark.svg" width="40" height="40"/>
<img align="center" src="src/test/resources/images/icons/selenoid icon.svg" width="40" height="40"/>
</p>

---

## Table of Contents

1. [Test Cases](#test-cases)
2. [Allure Reports](#allure-reports)
3. [Telegram Notifications](#telegram-notifications)
4. [Test Execution Video from Selenoid](#test-execution-video-from-selenoid)

---

## Test Cases

| ID   | Test Case Description                                                                       | Expected Result                                                                                                                      |
|------|---------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| TC01 | **Verify that 'WhatsUp' and 'Telegram' displays on Main page"**                             | Support buttons visible for user on the [Beeline Main Page](https://beeline.kz).                                                     |
| TC02 | **Location verification on the Main Page**                                                  | Verify that user is able to change Location to Astana.                                                                               |                                                                   |                                                                                                                                      |
| TC03 | **'Вакансии и карьера в Beeline' displays on the main page**                                | Ensures the "Вакансии и карьера в Beeline" link exists in the specified footer section.<br/>The hyperlink is visible and accessible. |
| TC04 | **Beeline People Page accessible**                                                          | Check that user is able open [Beeline People Page](https://people.beeline.kz).                                                       |
| TC05 | **Search QA Automation Engineer Position in Beeline People Page**                           | Ensures that user from Beeline People can search for QA Automation engineer position and able to open details of the job.            |
| TC06 | **Verify job search via quick filters in IT and BIG Data section**                          | Check that user can open IT and BIG Data section and select filter 'IT' to see all relevant open positions                           |
| TC07 | **Verify job search all positions button and drop down filters (Remote format of work)**    | Check that user can open job list via 'All Positions' button and apply drop down filter 'Удаленный формат'                           |
|      | **Check that Internship page can be opened and user is able to see list of open positions** |                                                                                                                                      |
|      |                                                                                             |                                                                                                                                      |
|      |                                                                                             |                                                                                                                                      |

---

## Allure Reports

Allure Reports provide clear insights into test results, including success/failure rates, test durations, and individual test steps. The report is generated after each test run and is accessible via Jenkins or as a standalone HTML report.

To view Allure reports:
1. Execute tests to generate the report: `mvn clean beeline_test`
2. Generate the Allure report: `allure serve target/allure-results`

**Example of Allure Report:**

<img align="center" src="src/test/resources/images/icons/Allure_Summary.png" width="600" height="350"/>


**Example of Test Case Steps from Allure Report:**

<img align="center" src="src/test/resources/images/icons/Allure_steps.png" width="500" height="350"/>

---

## Telegram Notifications

Notifications are set up via a relevant Telegram bot specified on Beeline KZ, alerting the team on test completion and results:
- Pass/Fail status
- Summary of tests executed, including failed tests
- Quick links to detailed reports

**Telegram Notification for Beeline KZ**  

<img align="center" src="src/test/resources/images/screens/Telegram_Notifications.png" width="500" height="400"/>

---

## Test Execution Video from Selenoid

Selenoid is used for cross-browser testing and video recording, enabling real-time playback for test executions to aid in debugging and verification.

1. Each test execution is recorded.
2. Videos are stored and can be accessed in Jenkins or a specified server path.

**Example Test Execution Video:**

https://github.com/user-attachments/assets/f155d712-e7cf-406c-b461-cd61373c3628



---
