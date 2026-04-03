import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner myScanner;
    public static ArrayList<Item> items = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();

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

    public static String getStringFromUser(String msg) {
        System.out.print(msg);
        return myScanner.nextLine();
    }

    public static int getIntFromUser(String msg) {
        System.out.print(msg);
        while (!myScanner.hasNextInt()) {
            myScanner.nextLine();
            System.out.print(msg);
        }
        int intValue = myScanner.nextInt();
        myScanner.nextLine();
        return intValue;
    }

    public static double getDoubleFromUser(String msg) {
        System.out.print(msg);
        while (!myScanner.hasNextDouble()) {
            myScanner.nextLine();
            System.out.print(msg);
        }
        double intValue = myScanner.nextDouble();
        myScanner.nextLine();
        return intValue;
    }

    public static Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        myScanner = new Scanner(System.in);

        while (true) {
            ShowMenu();

            System.out.print("Enter your choice: ");
            
            if (!myScanner.hasNextInt()){
                myScanner.nextLine();
                System.out.println("Please enter a number between 0 and 7.");
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
                System.out.println("");
                System.out.print("Enter item name: ");
                String itemName = myScanner.nextLine();
                double itemPrice = getDoubleFromUser("Enter item price: $");
                int itemQuantity = getIntFromUser("Enter item quantity: ");
                System.out.println("");
                System.out.print("Provider's Information:\n");
                String providerName = getStringFromUser("Enter provider name: ");
                int countryCode = getIntFromUser("Enter country code: ");  
                int areaCode = getIntFromUser("Enter area code: ");  
                int phoneNumber = getIntFromUser("Enter phone number: ");
                
                Provider newProvider = new Provider(providerName, countryCode, areaCode, phoneNumber);
                Item newItem;
                
                String itemType = null;
                System.out.println("");
                while (true) {
                    System.out.print("Physical or Digital Item? ");
                    if (myScanner.hasNextLine()) {
                        itemType = myScanner.nextLine();
                        if (itemType.equals("Physical") || itemType.equals("Digital")) {
                            break;
                        }
                    }
                }
                
                if (itemType.equals("Physical")) {
                    double itemWidth = getDoubleFromUser("Enter width: ");
                    double itemLength = getDoubleFromUser("Enter length: ");
                    double itemHeight = getDoubleFromUser("Enter height: ");
                    PhysicalItem newPhysicalItem = new PhysicalItem(
                        itemName, 
                        itemPrice, 
                        itemQuantity, 
                        newProvider, 
                        itemType,
                        itemWidth,
                        itemLength, 
                        itemHeight
                    );
                    newItem = newPhysicalItem;
                } else {
                    double diskSpace = getDoubleFromUser("Enter disk space: ");
                    DigitalItem newDigitalItem = new DigitalItem(
                        itemName, 
                        itemPrice, 
                        itemQuantity, 
                        newProvider, 
                        itemType,
                        diskSpace
                    );
                    newItem = newDigitalItem;
                }

                newItem.displayAddedMessage(true);
                items.add(newItem);
            } else if (sel == 2) {
                // 2. Display all Items
                for (Item item : items) {
                    item.displayItem();
                    System.out.println("");
                }
            } else if (sel == 3) {
                // 3. Display the Total Number of Items
                System.out.println("Total number of items: " + items.size());
            } else if (sel == 4) {
                // 4. Calculate the Total Worth of the Inventory
                double total=0;
                for (Item item : items) {
                    double cost = item.calculateTotalWorth();
                    System.out.printf("Total Worth of %s: $%.2f\n", item.getItemName(), cost);
                    total += cost;
                }
                // System.out.println("Total Worth of Inventory: $" + total);
            } else if (sel == 5) {
                // 5. Add an order
                System.out.print("Enter the item name you want to order: ");
                String itemName = myScanner.nextLine();
                System.out.print("Enter the quantity: ");
                int quantity = myScanner.nextInt();
                myScanner.nextLine();

                Item myItem = getItemByName(itemName);
                if (myItem == null || quantity > myItem.getItemQuantity() || quantity <= 0) {
                    System.out.println("Item not found or less than or equal to zero quantity.");
                    continue;
                }

                Order newOrder = new Order(myItem, quantity);
                orders.add(newOrder);
                System.out.println("Order has been placed successfully.");
                myItem.updateQuantity(quantity);
            } else if (sel == 6) {
                for (Order order : orders) {
                    order.displayOrderInfo();
                }
            } else {
                System.out.println("Please enter a valid choice between 1 and 7.");
            }

            System.err.println("");
        }
        
        myScanner.close();
    }
}
