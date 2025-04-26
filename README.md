# OrangeHRM Automation Framework
flairsTech-assessment

## 📋 Project Description

This project automates core functionalities of the [OrangeHRM demo site](https://opensource-demo.orangehrmlive.com/) using **Selenium**, **Cucumber (BDD)**, **TestNG**, and the **Page Object Model (POM)** design pattern.  
It covers UI-based creation and deletion of user records, and includes basic REST Assured structure for API automation (commented due to demo site limitations).
NOTE: OrangeHRM public demo site does not allow API testing. Only UI automation is possible.

---

## 🛠 Tech Stack

- **Java** 21
- **Selenium WebDriver**
- **Cucumber** (Gherkin BDD)
- **TestNG**
- **Maven** (Build Management)
- **Rest Assured** (API Testing - placeholder)
- **Page Object Model** (Design Pattern)
- **IntelliJ IDEA** (IDE)

---

## 🚀 Features Automated

- Login to OrangeHRM
- Navigate to Admin section
- Get number of user records
- Add a new user
- Validate that record count increased by 1
- Search for the newly created user
- Delete the user
- Validate that record count decreased by 1

---

## ⚡ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/MuhamadAtef/orangehrm-automation.git
````

2.  Using Maven command to run code
 
 ```bash
mvn clean test
```

