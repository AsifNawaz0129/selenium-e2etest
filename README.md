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

* **Framework Design:** Structured using robust Java automation principles to ensure scalability and maintainability across complex web applications.
* **Build Management:** Utilizes **Apache Maven** (`pom.xml`) for strict dependency management and clean lifecycle execution.
* **Test Orchestration:** Powered by **TestNG** for advanced test grouping, assertions, and comprehensive HTML reporting.
* **Continuous Integration (CI/CD):** Fully integrated with **GitHub Actions**. The pipeline (`maven.yml`) automatically configures the environment, installs Chrome binaries via custom shell scripts, and executes the test suite on every commit to ensure zero-regression delivery.

---

### 📂 Framework Structure

```text
selenium-e2etest/
├── .github/workflows/
│   └── maven.yml               # CI/CD pipeline configuration (GitHub Actions)
├── scripts/
│   └── InstallChrome.sh        # Environment setup script for headless CI execution
├── src/
│   ├── main/java/              # Core framework utilities and page abstractions
│   └── test/java/seleniumProject/ # Core TestNG test specifications
├── pom.xml                     # Maven build configuration and dependency tree
└── README.md                   # Framework documentation
