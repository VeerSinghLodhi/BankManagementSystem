# Bank Management System

## Overview
The **Bank Management System** is a desktop application designed to simulate core banking operations. This project utilizes:
- **Frontend**: Java Swing (for GUI design)
- **Backend**: Core Java
- **Database**: Oracle SQL

The application offers a user-friendly interface to perform basic banking operations such as deposits, withdrawals, balance inquiries, and more.

---

## Features
1. **Login System**:
   - Secure login for users.
   - Pin-based authentication.

2. **Banking Operations**:
   - **Deposit Cash**: Allows users to deposit money into their account.
   - **Withdraw Cash**: Enables users to withdraw money securely.
   - **Fast Cash**: Quick cash withdrawal options for fixed denominations.
   - **Balance Inquiry**: Check account balance instantly.
   - **Mini Statement**: View recent transactions.

3. **Account Management**:
   - **Sign-Up**: Users can create new accounts.
   - **Pin Change**: Users can update their PIN for security.

4. **Transaction History**:
   - View detailed transaction records.

---

## Project Structure
The project consists of the following files:

| **File**                | **Description**                              |
|-------------------------|----------------------------------------------|
| `Balance_Enquiry.java`  | Backend logic for balance inquiry.           |
| `Deposit_Cash.java`     | Backend logic for depositing cash.           |
| `Fast_Cash.java`        | Backend logic for fast cash withdrawal.      |
| `LoginPage.java`        | Handles user authentication and login.       |
| `Mini_Statement.java`   | Generates and displays recent transactions.  |
| `Pin_Change.java`       | Enables users to update their PIN securely.  |
| `SQL_Connection.java`   | Manages connection with the Oracle database. |
| `SignUpPage1.java`      | Logic for the first page of the sign-up form.|
| `SignUpPage2.java`      | Logic for the second page of the sign-up form.|
| `SignUpPage3.java`      | Final step of the sign-up process.           |
| `Transactions.java`     | Handles transactions and user activity.      |
| `Withdraw_Cash.java`    | Backend logic for withdrawing cash.          |

Each `.java` file corresponds to the core logic, and `.form` files define the Swing GUI.

---

## Database Setup
1. **Oracle SQL Database**:
   - Ensure Oracle SQL is installed and running.
   - Create a database schema to store user accounts and transaction details.
   - Tables:
     - `Users` (to store account details like account number, PIN, balance, etc.).
     - `Transactions` (to log deposits, withdrawals, and other operations).

2. **Database Connection**:
   - Update the `SQL_Connection.java` file with your database connection details:
     ```java
     String url = "jdbc:oracle:thin:@localhost:1521:XE";
     String username = "your_username";
     String password = "your_password";
     ```

---

## Prerequisites
1. **Java Development Kit (JDK)**:
   - Ensure JDK 8 or above is installed.
2. **Oracle SQL**:
   - Set up an Oracle SQL database.
3. **IDE**:
   - Use an IDE like NetBeans or IntelliJ IDEA for better GUI form integration.
4. **JDBC Driver**:
   - Include the Oracle JDBC driver (`ojdbc.jar`) in your project.

---

## How to Run
1. Clone the repository or download the project files.
2. Set up the Oracle SQL database and update `SQL_Connection.java` with your credentials.
3. Compile and run the project using your IDE:
   - Example: Run `LoginPage.java` to start the application.
4. Log in or sign up to explore the application.

---

## Future Enhancements
1. Implement **Admin Panel** for managing user accounts.
2. Add **Interest Calculation** for savings accounts.
3. Integrate email or SMS notifications for transactions.
4. Introduce multi-language support for accessibility.

---

## Screenshots

<p>
<img src="https://github.com/VeerSinghLodhi/BankManagementSystem/blob/main/GUI%20Screenshots/Screenshot%202025-03-23%20142438.png" width=500 height=300 align="left"/>
<img src="https://github.com/VeerSinghLodhi/BankManagementSystem/blob/main/GUI%20Screenshots/Screenshot%202025-03-23%20142523.png" width=450 height=500  />
</p>

---


## Author
Developed by **[Veer Singh Lodhi]**  
A project focused on demonstrating Java Swing, Core Java, and Oracle SQL integration.

<h3 align="left">Connect with me:</h3>
<p align="left">
<a href="https://x.com/veerSin22816021?t=o3hZnstGiN8U_nOjQWEqhw&s=09" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="veer singh lodhi" height="30" width="40" /></a>
<a href="https://www.linkedin.com/in/veer-singh-lodhi-6786aa325?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="veer singh lodhi" height="30" width="40" /></a>
  <a href="https://youtube.com//channel//UCFy1I_EXFiaI7gtsVV8ehog" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" alt="youtube.com/channel/UCFy1I_EXFiaI7gtsVV8ehog" height="30" width="40" /></a>
</p>
