// M. Furkan UZUN
// 14.03.2026

import java.util.Scanner;

public class InventoryTest {
    public static Scanner myScanner;

    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        myScanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add a new item");
            System.out.println("2. Display all items");
            System.out.println("3. Display total number of items");
            System.out.println("4. Calculate total worth");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            
            if (!myScanner.hasNextInt()){
                myScanner.nextLine();
                System.out.println("Please enter a number between 0 and 4.");
                continue;
            }

            int sel = myScanner.nextInt();
            myScanner.nextLine();

            if (sel == 0) {
                // 0. Exit
                System.out.println("Exiting... Goodbye!");
                break;
            } else if (sel == 1) {
                // 1. Add a New Item
                System.out.print("Enter item name: ");
                String itemName = myScanner.nextLine();
                
                System.out.print("Enter item price: $");
                while (!myScanner.hasNextDouble()) {
                    myScanner.nextLine();
                    System.out.print("Enter item price: $");
                }
                double itemPrice = myScanner.nextDouble();
                myScanner.nextLine();
                
                System.out.print("Enter item quantity: ");
                while (!myScanner.hasNextInt()) {
                    myScanner.nextLine();
                    System.out.print("Enter item quantity: ");
                }
                int itemQuantity = myScanner.nextInt();
                myScanner.nextLine();

                if (myInventory.addItem(itemName, itemPrice, itemQuantity)) {
                    System.out.println("Item added successfully.");
                }
            } else if (sel == 2) {
                // 2. Display all Items
                myInventory.displayAllItems();
            } else if (sel == 3) {
                // 3. Display the Total Number of Items
                System.out.println("Total number of items: " + myInventory.getTotalNumberOfItems());
            } else if (sel == 4) {
                // 4. Calculate the Total Worth of the Inventory
                System.out.println("Total Worth of Inventory: $" + myInventory.calculateTotalWorth());
            } else {
                System.out.println("Please enter a valid choice between 0 and 4.");
            }
        }
        
        myScanner.close();
    }
}
