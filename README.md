# Selenium Automation with JUnit

## 📌 Project Overview

This project demonstrates **UI Automation** and **Web Scraping** using **Selenium WebDriver**, **JUnit**, and **Gradle**.
It contains two main automation tasks:
* ✅ Web Form Automation
* ✅ Stock Market Data Scraping

---

## 🛠️ Tech Stack

* 🔹 Java
* 🔹 Selenium WebDriver
* 🔹 JUnit 5
* 🔹 Gradle

---

## 📂 Project Structure

```
├── src/test/java
│   ├── TutorialsPoint.java
│   ├── DhakaStockExchange.java
├── build.gradle
├── README.md
```

---

# 🧪 Task 1: Web Form Automation

🔗 URL: https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php

### ✅ Steps Performed:

1. Fill up all input fields
2. Submit the form
3. Validate successful registration

### 🎯 Key Features:

* Input handling (text, radio, checkbox, dropdown)
* Form submission automation
* Assertion using JUnit

## 📸 Screenshots of the output:
![Web Form Output](screenshots/tutorialspoint_ui_output.png)
![Web Form Output 2](screenshots/tutorialspoint_output_2.png)

---

# 📊 Task 2: DSE Data Scraping

🔗 URL: https://dsebd.org/latest_share_price_scroll_by_value.php

### ✅ Steps Performed:

1. Extract all table cell values
2. Print data in console
3. Store data into a text file

### 🎯 Key Features:

* Dynamic table scraping
* Handling popups/windows
* Iterating rows and cells
* File handling (write to `.txt`)

## 📸 Screenshots of the output:
![Console Output](screenshots/stock_output_console.png)
![Text File Output](screenshots/stock_output_text_file.png)

---

## ▶️ How to Run

### 1️⃣ Clone Repository

```
git clone https://github.com/Imtiaz16041997/assignment-on-Junit.git
```

### 2️⃣ Open in IDE

* IntelliJ IDEA / Eclipse

### 3️⃣ Run Tests

```
./gradlew test
```

---

## 📸 Sample Output

```
ACMEPL 19.2 19.4 18 19.2 18.4 0.8 3542 189.6880 10120575
AAMRANET 17.0 17.5 16.8 17.0 16.5 0.5 2000 50.1234 3000000
```

📁 Output file: `dse_data.txt`

---

## 💡 Learning Outcomes

* Selenium WebDriver basics
* Handling dynamic web elements
* Table scraping techniques
* File operations in Java
* Writing automation tests with JUnit

---

## 🙋‍♂️ Author

**Ibnul Imtiaz**

---

## ⭐ Give a Star

If you found this project helpful, consider giving it a ⭐ on GitHub!
