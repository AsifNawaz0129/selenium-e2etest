# ⚡  Selenium E2E Automation Framework

![Selenium](https://img.shields.io/badge/-selenium-%2343B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF7FAB?style=for-the-badge&logo=testing-library&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)

### 🎯 Overview
This repository contains a robust, classic End-to-End (E2E) UI automation framework built with **Java** and **Selenium WebDriver**, targeting the SauceDemo e-commerce platform. It demonstrates foundational enterprise automation patterns, strict object-oriented programming (OOP) concepts, and seamless Continuous Integration pipeline execution.

---

### 🚀 Core Features & Architecture

* **Framework Design:** Structured using the **Page Object Model (POM)** and robust Java automation principles to ensure scalability and maintainability.
* **Build Management:** Utilizes **Apache Maven** (`pom.xml`) for strict dependency management (Java 17, Selenium 4) and clean lifecycle execution.
* **Test Orchestration:** Powered by **TestNG** for advanced test grouping, assertions, and comprehensive reporting.
* **Continuous Integration (CI/CD):** Fully integrated with **GitHub Actions**. The pipeline (`selenium.yml`) automatically configures the environment and executes the test suite on every commit to ensure zero-regression delivery.
* **Logging & Reporting:** Integrated with **Log4j2** for detailed execution logs and **ExtentReports** for rich, interactive HTML reports with screenshots on failure.

---

### 📂 Framework Structure

```text
selenium-e2etest/
├── .github/workflows/
│   └── selenium.yml            # CI/CD pipeline configuration (GitHub Actions)
├── scripts/
│   └── InstallChrome.sh        # Environment setup script for headless CI execution
├── src/
│   ├── main/java/              # Core framework
│   │   ├── pageObjects/        # Page Object classes (e.g., CartPage, HomePage)
│   │   └── resources/          # Core utilities (base.java, ExtentReporter, Database config)
│   └── test/java/seleniumProject/ # Core TestNG test specifications
├── pom.xml                     # Maven build configuration and dependency tree
├── testng.xml                  # TestNG suite execution configuration
└── README.md                   # Framework documentation
```

---

### 📋 Prerequisites

To run this project locally, ensure you have the following installed:
- **Java Development Kit (JDK) 17** or higher
- **Apache Maven 3.x**
- **Google Chrome** (or Firefox/IE depending on configuration)

---

### ⚙️ Configuration

The framework uses a properties file for environment configurations. You can adjust the browser and base URL before running the tests.

**File Location:** `src/main/java/resources/data.properties`
```properties
browser=chrome
url=https://www.saucedemo.com/
```
*Note: Supported browsers configured in `base.java` include `chrome` (configured to run headless by default), `firefox`, and `IE`.*

---

### 🚀 Running the Tests

Tests are executed using Maven. This will clean the target directory, compile the code, and trigger the `testng.xml` test suite via the Maven Surefire plugin.

**Run all tests in the suite:**
```bash
mvn clean test
```

**Run a specific test class:**
```bash
mvn clean test -Dtest=CartTest
```

---

### 📊 Reporting and Logs

* **TestNG Reports:** Standard TestNG HTML and XML reports are generated under the `target/surefire-reports/` directory.
* **ExtentReports:** A rich HTML report with failure screenshots is automatically generated and saved at `reports/index.html`.
* **Logs:** Execution logs are generated based on the `log4j2.xml` configuration, typically located in the `logs/` directory.
