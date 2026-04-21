# Online Shop Inventory Management System 🛒

### package
```bash
make clean STUDENT_NUMBER=0
make all STUDENT_NUMBER=0
```

**Course:** CSE212: Software Development Methodologies  
**University:** Yeditepe University  
**Term:** Spring 2026  
**Assignment:** #1  

## 📝 About the Project

This repository contains the first assignment for the **CSE212: Software Development Methodologies** course. The project involves developing the foundational steps of an **Online Shop Inventory Management System**. 

The main objective of this console-based Java application is to manage shop inventory by storing item details, displaying current stock, and calculating inventory metrics using core object-oriented programming concepts and C-style arrays.

## ✨ Features

The system provides a user-friendly console menu that allows users to:
* **Add new items** to the inventory (up to a maximum capacity of 5 items).
* **Display all stored items** with their specific details (name, price, and quantity).
* **Show the total number** of unique items currently in the inventory.
* **Calculate the total worth** of the inventory (Item Price × Item Quantity).

## 🛠️ Technical Details & Architecture

The project is structured around two main Java classes:

### 1. `Inventory` Class
This class is responsible for storing and managing the core inventory data. 
* **Data Storage:** Due to warehouse limitations, the inventory capacity is strictly limited to **5 items**.
* **Data Structure:** Information is kept synchronized across three separate C-style arrays:
  * `itemName` (String array)
  * `itemPrice` (double array)
  * `itemQuantity` (int array)
* **Methods:**
  * `addItem()`: Adds a new item to the arrays.
  * `displayAllItems()`: Prints out the current inventory.
  * `getTotalNumberOfItems()`: Returns the count of unique items.
  * `calculateTotalWorth()`: Computes the monetary value of the entire stock.

### 2. `InventoryTest` Class
This serves as the entry point (Main class) of the application. It features a continuous `while` loop that presents an interactive menu to the user, takes inputs via `Scanner`, and calls the appropriate methods from the `Inventory` class.

## 🚀 How to Run

1. Clone this repository to your local machine:
    ```bash
    git clone <your-repository-url>
    ```

2. Navigate to the project directory.

3. Compile the Java files:

    ```bash
    javac Inventory.java InventoryTest.java
    ````
4. Run the main class:
    ```bash
    java InventoryTest
    ````
