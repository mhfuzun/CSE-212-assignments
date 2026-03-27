// M. Furkan UZUN
// 25.03.2026

public class Order {
    private int orderID;
    private Inventory inventory;
    private String itemName;
    private int quantity;

    public Order(int orderID, Inventory inventory, String itemName, int quantity) {
        this.orderID = orderID;
        this.inventory = inventory;
        this.itemName = itemName;
        this.quantity = quantity;
    }
    
    public void displayOrderInfo() {
        System.out.printf("Order ID: %d\n", orderID);
        System.out.printf("Item Name: %s\n", itemName);
        System.out.printf("Quantity: %d\n", quantity);
    }

    public boolean checkStorage(String itemName) {
        if (inventory.getItemCountWithItemName(itemName) >= quantity) {
            return true;
        } else {
            System.out.println("Item not found in inventory. Order cannot be placed.");
            return false;
        }
    }

    public double calculateOrderCost() {
        double total_price = (inventory.getItemPriceWithItemName(itemName) * quantity);
        return total_price;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }
}
