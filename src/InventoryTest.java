// M. Furkan UZUN
// 14.03.2026

import java.util.Scanner;

public class InventoryTest {
    public static Scanner myScanner;

    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        myScanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add a New Item");
            System.out.println("2. Display all Items");
            System.out.println("3. Display the Total Number of Items");
            System.out.println("4. Calculate the Total Worth of the Inventory");
            System.out.println("0. Exit");

            System.out.print("$ ");
            if (!myScanner.hasNextInt(10)){
                myScanner.nextLine();
                System.out.println("");
                System.out.println("Give me a number beetwen 0..4, pls!");
                continue;
            }

            int sel = myScanner.nextInt(10);
            System.out.println("");
            myScanner.nextLine();

            if (sel == 0) {
                // 0. Exit
                System.out.println("bye!");
                break;
            } else if (sel == 1) {
                // 1. Add a New Item
                String itemName;
                double itemPrice;
                int itemQuantity;
                
                System.out.print("Item Name: ");
                itemName = myScanner.nextLine();
                
                System.out.print("Item Price: ");
                while (!myScanner.hasNextDouble())
                    System.out.print("\nItem Price: ");
                itemPrice = myScanner.nextDouble();
                myScanner.nextLine();
                
                    System.out.print("Item Quantity: ");
                while (!myScanner.hasNextInt())
                    System.out.print("\nItem Quantity: ");
                itemQuantity = myScanner.nextInt();
                myScanner.nextLine();

                if (myInventory.addItem(itemName, itemPrice, itemQuantity) != 0) {
                    System.out.println("Item added successfully.");
                }
            } else if (sel == 2) {
                // 2. Display all Items
                myInventory.displayAllItems();
            } else if (sel == 3) {
                // 3. Display the Total Number of Items
                System.out.println("the Total Number of Items: " + myInventory.getTotalNumberOfItems());
            } else if (sel == 4) {
                // 4. Calculate the Total Worth of the Inventory
                System.out.println("the Total Worth of the Inventory: " + myInventory.calculateTotalWorth());
            } else {
                System.out.println("Give me a number beetwen 0..4, pls!");
                continue;
            }
        }
    }
}
