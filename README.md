# Selenium Maven Cucumber TestNG Project

A Selenium automation project using Cucumber and TestNG for testing best buy web applications.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Reporting](#reporting)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK)**, Maven, WebDriver, IDE.
```bash
  # Check your Java version
  java -version
  # Check your Maven version
    mvn -version
  ```
## Project Structure
 ```bash
project-root/
│
├── src/
│   ├── main/
│   │   └── java/
│   │   └── resources/
│   │    
│   └── test/
│       ├── java/
│       │   └── applicationPages/
│       │       ├── checkoutPage/
│       │       ├── HomePage/
│       │   └── env/
│       │       ├── DriverUtil/
│       │       ├── Hooks/
│       │       ├── RunCukeTest
│       │   └── stepDefinition/
│       │       ├── UserStepDefinitions/
│       └── resources/
│           ├── features/
│               └── bestBuyAutomation.feature
│
├── pom.xml
├── README.md
└── testng.xml
```

## Installation
```bash
Follow these steps to set up the project:

1. Clone the repository:
   git clone https://github.com/yourusername/selenium-cucumber-testng.git
2. Navigate to the project directory:
3. Install project dependencies:
    mvn clean install
```

## Usage
```bash
1. Feature files: create your feature file under src/test/resources/features
2. Step definitions: create your step defitions under src/test/java/stepDefinition
3. To run the tests `RunCukeTest` or mvn clean test
```

## Reporting
```bash
Reports are under: `target/cucumber-reports.html`
```