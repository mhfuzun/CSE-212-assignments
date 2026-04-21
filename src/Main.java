import java.util.*;

public class Main {
    public static Scanner myScanner;
    public static List<Service> services = new ArrayList<>();
    public static List<Service> itemsAboveFee = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    public static void ShowMenu() {
        System.out.println(SubMenu.INVENTORY.getMenuline());
        System.out.println(Menu.NewItem.getMenuline());
        System.out.println(Menu.DispItems.getMenuline());
        System.out.println(Menu.NumOfItems.getMenuline());
        System.out.println(Menu.WorthOfInv.getMenuline());
        System.out.println(Menu.PriceOfSpec.getMenuline());
        System.out.println(Menu.ListFreeShip.getMenuline());
        System.out.println(Menu.RemoveOrder.getMenuline());
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

    public static Service getServiceByName(String itemName) {
        for (Service service : services) {
            if (service instanceof Item) {
                Item item = (Item) service;
                if (item.getItemName().equals(itemName)) {
                    return item;
                }
            } else if (service instanceof Streaming) {
                Streaming item = (Streaming) service;
                if (item.getTitle().equals(itemName)) {
                    return item;
                }
            } else if (service instanceof FoodDelivery) {
                FoodDelivery item = (FoodDelivery) service;
                if (item.getFoodName().equals(itemName)) {
                    return item;
                }
            }
        }

        return null;
    }

    public static void displayAllServices() {
        for (Service service : services) {
            service.displayServiceInfo();
            System.out.println("");
        }
    }

    public static void printItemsAboveFee() {
        for (Service service : itemsAboveFee) {
            String itemName = Service.getServiceName(service);
            System.out.printf("Service: %s, Shipping Fee: %.2f\n",
                itemName,
                service.calculateShippingFee()
            );
            System.out.println(itemName);
        }
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

            System.out.println("");

            if (sel == Menu.Exit.getMenuIndex()) {
                // 8. Exit
                System.out.println("Exiting... Goodbye!");
                break;
            } else if (sel == Menu.NewItem.getMenuIndex()) {
                // 1. Add a New Item
                Service newItem;
                String itemType = null;
                int subMenuSel = 0;

                while (true) {
                    System.out.println("1. Item (Physical/Digital)");
                    System.out.println("2. Streaming");
                    System.out.println("3. Food Delivery");
                    subMenuSel = getIntFromUser("Enter your choice: ");
                    System.out.println("");
                    
                    if (subMenuSel == 1) {
                        itemType = "Physical/Digital";
                    } else if (subMenuSel == 2) {
                        itemType = "Streaming";
                    } else if (subMenuSel == 3) {
                        itemType = "Food Delivery";
                    } else {
                        continue;
                    }

                    break;
                }
                
                if (subMenuSel == 1) {
                    System.out.println("Item's Information:");
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
                    
                    while (true) {
                        System.out.print("Physical or Digital Item? ");
                        if (myScanner.hasNextLine()) {
                            itemType = myScanner.nextLine();
                            if (itemType.equals("Physical") || itemType.equals("Digital")) {
                                break;
                            }
                        }
                    }
                    
                    Provider newProvider = new Provider(providerName, countryCode, areaCode, phoneNumber);
                    
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
                    System.out.println(itemType + " item added successfully!");
                } else if (subMenuSel == 2) {
                    System.out.println("Streaming Information:");
                    String title = getStringFromUser("Enter title: ");
                    String category = getStringFromUser("Enter category: ");
                    double costPerDay = getDoubleFromUser("Enter cost per day: ");
                    int days = getIntFromUser("Enter days: ");

                    Streaming newStreamingItem = new Streaming(
                        title, 
                        category,
                        costPerDay, 
                        days, 
                        "Streaming"
                    );
                    newItem = newStreamingItem;
                    System.out.println("Streaming service" + " added successfully!");
                } else {
                    System.out.println("Food Delivery Information:");
                    String foodName = getStringFromUser("Enter food name: ");
                    String restaurantName = getStringFromUser("Enter restaurant name: ");
                    double mealPrice = getDoubleFromUser("Enter meal price: $");
                    int count = getIntFromUser("Enter food count: ");
                    
                    FoodDelivery newFoodDeliveryItem = new FoodDelivery(
                        foodName, 
                        restaurantName,
                        mealPrice, 
                        count, 
                        "Food Delivery"
                    );
                    newItem = newFoodDeliveryItem;
                    System.out.println("Food Delivery service" + " added successfully!");
                }
                
                services.add(newItem);
            } else if (sel == Menu.DispItems.getMenuIndex()) {
                // 2. Display All services
                displayAllServices();
            } else if (sel == Menu.NumOfItems.getMenuIndex()) {
                // 3. Display the Total Number of services
                System.out.println("Total number of services: " + services.size());
            } else if (sel == Menu.WorthOfInv.getMenuIndex()) {
                // 4. Calculate the Total Worth of the Inventory
                // double total=0;
                for (Service service : services) {
                    double cost = service.calculateService();
                    System.out.printf("Total Worth of Service %s: $%.2f\n", service.getServiceType(), cost);
                    // total += cost;
                }
                // System.out.println("Total Worth of Inventory: $" + total);
            } else if (sel == Menu.OrderNew.getMenuIndex()) {
                // 5. Add an order
                /*
                    Enter the item name you want to order: Baldur's Gate Game
                    Enter the quantity: 5
                    Enter destination region: Aegean
                    Enter destination city: Mugla
                    Enter destination post code: 48300
                    Order has been placed successfully.
                */
                System.out.print("Enter the service name you want to order: ");
                String serviceName = myScanner.nextLine();
                System.out.print("Enter the quantity: ");
                int quantity = myScanner.nextInt();
                myScanner.nextLine();
                String destinationRegion = getStringFromUser("Enter destination region: ");
                String destinationCity = getStringFromUser("Enter destination city: ");
                String destinationPostCode = getStringFromUser("Enter destination post code: ");

                Service myService = getServiceByName(serviceName);
                if (myService instanceof DigitalItem || myService instanceof PhysicalItem || myService instanceof FoodDelivery) {
                    int serviceQuentity = 0;
                    if (myService instanceof Item) {
                        Item item = (Item) myService;
                        serviceQuentity = item.getItemQuantity();

                        item.updateQuantity(quantity);
                    } else if (myService instanceof FoodDelivery) {
                        FoodDelivery item = (FoodDelivery) myService;
                        serviceQuentity = item.getCount();
                        item.setCount(item.getCount() - quantity);
                    }

                    if (myService == null || quantity > serviceQuentity || quantity <= 0) {
                        System.out.println("Item not found or less than or equal to zero quantity.");
                        continue;
                    }
                }

                Order newOrder = new Order(myService, quantity);
                
                newOrder.setDestinationRegion(destinationRegion);
                newOrder.setDestinationCity(destinationCity);
                newOrder.setDestinationPostCode(destinationPostCode);

                orders.add(newOrder);
                System.out.println("Order has been placed successfully.");
            } else if (sel == Menu.OrderCost.getMenuIndex()) {
                for (Order order : orders) {
                    order.displayOrderInfo();
                }
            } else if (sel == Menu.PriceOfSpec.getMenuIndex()) {
                String itemType = getStringFromUser("Which type of services will be raised in price?: ");
                int raiseRate = getIntFromUser("How much will the raise ratio(%) be?: ");

                if (itemType.equals("Physical") || itemType.equals("Digital")) {
                    System.out.println("Please enter a valid item type.");
                    continue;
                }
                
                ListIterator<Service> iterator = services.listIterator();
                while (iterator.hasNext()) {
                    Service service = iterator.next();
                    if (service.getServiceType().equals("DigitalItem") || service.getServiceType().equals("PhysicalItem")) {
                        Item item = (Item) service;
                        if (item.getType().equals(itemType)) {
                            item.raisePriceWithRate(raiseRate);
                        }
                    }
                }
                System.out.printf("The raise ratio was applied to %s services.\n", itemType);
                System.out.println("");
                displayAllServices();
            } else if (sel == Menu.ListFreeShip.getMenuIndex()) {
                int limit = getIntFromUser("Enter a limit: ");

                itemsAboveFee = new ArrayList<Service>();

                ListIterator<Order> iterator = orders.listIterator();
                while (iterator.hasNext()) {
                    Order order = iterator.next();
                    if (order.getService().calculateShippingFee() > limit) {
                        itemsAboveFee.add(order.getService());
                    }
                }

                if (itemsAboveFee.size() == 0)
                    System.out.println("There is no item with a shipping fee over this limit.");
                else {
                    System.out.printf("Services with shipping fees over %d: \n", limit);
                    printItemsAboveFee();
                }
            } else if (sel == Menu.RemoveOrder.getMenuIndex()) {
                /*
                    Type a name to remove orders destined to a specific city: Antalya
                    The order(s) for Antalya was deleted successfully
                */
                String city = getStringFromUser("Type a name to remove orders destined to a specific city: ");
                ListIterator<Order> iterator = orders.listIterator();
                
                int count = 0;
                while (iterator.hasNext()) {
                    Order order = iterator.next();
                    if (order.getDestinationCity().equals(city)) {
                        iterator.remove();
                        count++;
                    }
                }

                if (count == 0) {
                    System.out.println("The order(s) for " + city + " was not found.");
                } else {
                    System.out.println("The order(s) for " + city + " was deleted successfully.");
                }

            } else {
                System.out.println("Please enter a valid choice between 1 and 7.");
            }

            System.err.println("");
        }
        
        myScanner.close();
    }
}
