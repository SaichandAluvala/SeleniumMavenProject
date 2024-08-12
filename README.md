# Selenium Maven Project

This repository contains a Selenium-based automated testing framework built with Maven. The project is designed to run web UI tests using Selenium WebDriver.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This project provides a starting point for writing and running automated web tests using Selenium and Maven. The framework is designed to be scalable and easy to maintain, providing examples of common testing scenarios.

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 8 or higher)
- [Apache Maven](https://maven.apache.org/install.html)
- [Google Chrome](https://www.google.com/chrome/) (or another web browser of your choice)
- [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) (or the appropriate WebDriver for your browser)
- Cucumber install

## Setup Instructions

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/selenium-maven-project.git
    ```

2. **Navigate to the project directory**:
    ```sh
    cd selenium-maven-project
    ```

3. **Install project dependencies**:
    ```sh
    mvn clean install
    ```

## Running Tests

1. **Run all tests**:
    ```sh
    mvn test
    ```

2. **Run tests with a specific profile** (e.g., using a different browser):
    ```sh
    mvn test -P firefox
    ```

## Project Structure

The project structure follows a standard Maven layout:

