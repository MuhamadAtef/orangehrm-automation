# OrangeHRM Automation Framework  
FlairsTech Assessment Project

## Project Description
This project automates core functionalities of the [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/) using Selenium WebDriver, Cucumber (BDD), TestNG, and the Page Object Model (POM) design pattern.  
It also includes API automation examples using Rest Assured for candidate creation and deletion.

Important Note:  
The OrangeHRM public demo site does not fully support API authentication or protected API actions. Therefore, the API automation leverages session cookies obtained after UI login.

## Technology Stack

- Java 21
- Selenium WebDriver
- Cucumber (Gherkin BDD)
- TestNG
- Maven (Build Management)
- Rest Assured (API Automation)
- Page Object Model (Design Pattern)
- IntelliJ IDEA (IDE)

## Features Automated

- Login to OrangeHRM
- Navigate to the Admin section
- Retrieve the number of user records
- Add a new user
- Validate that the record count increased by one
- Search for the newly created user
- Delete the user
- Validate that the record count decreased by one
- Add a candidate using OrangeHRM API (session-based authentication)
- Delete a candidate using OrangeHRM API (bulk delete)



## ⚡ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/MuhamadAtef/orangehrm-automation.git
````

2.  Using Maven command to run code
 
```bash
mvn clean test
```

