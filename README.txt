Selenium Automation Framework – Swag Labs

Project Overview

This project is an automation framework built using Java, Selenium,
Cucumber (BDD), and Maven. It automates important user flows of the Swag
Labs website like login, product selection, cart, and checkout.

The main goal of this framework is to make test automation easy to
understand, easy to maintain, stable, and ready for CI/CD integration.

------------------------------------------------------------------------

Framework Structure Explanation

The project is divided into proper folders to keep everything organized:

pages
Contains all locators and page actions.

stepdefinitions
Connects feature file steps with Java code.

features
Contains scenarios written in simple English using Cucumber.

hooks
Used for setup and teardown before and after execution.

utilities
Contains driver setup, wait logic, and reusable helper methods.

This separation keeps the framework clean and scalable.

------------------------------------------------------------------------

1.  Why did you choose this framework structure?

I used Page Object Model with Cucumber because it keeps the project
clean and readable.

Page Object Model separates UI elements from test logic.
Cucumber allows writing test cases in business-readable format.
If UI changes, we only update locators in one place.
It improves reusability and maintainability.

This structure is scalable and suitable for real-time projects.

------------------------------------------------------------------------

2.  How does your wait strategy prevent flakiness?

Flaky tests usually happen when the script runs faster than the
application loads.

To avoid this:

I did not use Thread.sleep().
I used Explicit Wait (WebDriverWait).
I wait for specific conditions like:
- Element is visible
- Element is clickable
- Element is present

This ensures the test waits only when needed.
It reduces timing issues and improves test stability.

------------------------------------------------------------------------

3.  How does your locator strategy improve stability?

I followed these rules while writing locators:

Prefer ID and Name whenever available.
Use stable CSS selectors.
Avoid absolute XPath.
Avoid index-based XPath unless necessary.
Keep all locators inside Page classes.

Because of this: Tests break less often.
Maintenance becomes easier.
Code is cleaner and structured.

------------------------------------------------------------------------

4.  How would you scale this to 50+ scenarios?

If the number of scenarios increases:

Use tags like @smoke, @regression, @sanity.
Create reusable methods for common actions like login.
Create a Base Page for common functions like click and type.
Enable parallel execution using Maven or TestNG.
Use data-driven testing with Scenario Outline.

This keeps the framework manageable even with many test cases.

------------------------------------------------------------------------

5.  How would you execute this in CI/CD?

Steps:

Push code to GitHub.
Jenkins pipeline triggers automatically.
Run command: mvn clean test
Generate and publish reports.

Tools used: Git
Maven
Jenkins

This ensures tests run automatically on every code change.

------------------------------------------------------------------------

6.  Two improvements you would make with more time

7.  Add Better Reporting
    Integrate Extent Reports or Allure.
    Add screenshots on failure.
    Add proper logging.

8.  Add Retry Mechanism
    Implement retry logic for failed tests to reduce false failures.

------------------------------------------------------------------------

How to Run the Project

Run all tests: mvn clean test

run Testrunner file with specific annotation

------------------------------------------------------------------------

Final Summary

This framework is clean, structured, stable, scalable, and ready for
CI/CD integration. It follows best practices and can easily support
large automation projects.
