// M. Furkan UZUN
// 14.03.2026

import java.util.Scanner;

public class Test {
    public static Scanner myScanner;
    public static int orderID = 0;

    public static void ShowMenu() {
        System.out.println(SubMenu.INVENTORY.getMenuline());
        System.out.println(Menu.NewItem.getMenuline());
        System.out.println(Menu.DispItems.getMenuline());
        System.out.println(Menu.NumOfItems.getMenuline());
        System.out.println(Menu.WorthOfInv.getMenuline());
        System.out.println(SubMenu.CUSTOMER.getMenuline());
        System.out.println(Menu.OrderNew.getMenuline());
        System.out.println(Menu.OrderCost.getMenuline());
        System.out.println(Menu.Exit.getMenuline());
    }

    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        myScanner = new Scanner(System.in);
        Order myOrder = new Order(0, myInventory, "", 0);
        
        while (true) {
            ShowMenu();

            System.out.print("Enter your choice: ");
            
            if (!myScanner.hasNextInt()){
                myScanner.nextLine();
                System.out.println("Please enter a number between 0 and 4.");
                continue;
            }

            int sel = myScanner.nextInt();
            myScanner.nextLine();

            if (sel == 7) {
                // 7. Exit
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
            } else if (sel == 5) {
                // 5. Add an order
                System.out.print("Enter the item name you want to order: ");
                String itemName = myScanner.nextLine();
                System.out.print("Enter the quantity: ");
                int quantity = myScanner.nextInt();
                myScanner.nextLine();

                Order newOrder = new Order(orderID, myInventory, itemName, quantity);
                if (newOrder.checkStorage(itemName)) {
                    newOrder.displayOrderInfo();
                    myOrder = newOrder;
                    orderID++;
                }
            } else if (sel == 6) {
                // 6. Calculate order cost
                if (orderID != 0) {
                    System.out.printf("Order cost for %d %s is: %f\n", 
                        myOrder.getQuantity(), 
                        myOrder.getItemName(), 
                        myOrder.calculateOrderCost()
                    );
                } else {
                    System.out.println("No order placed yet.");
                }
            } else {
                System.out.println("Please enter a valid choice between 1 and 7.");
            }

            System.err.println("");
        }
        
        myScanner.close();
    }
}
