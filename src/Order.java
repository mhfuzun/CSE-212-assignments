// M. Furkan UZUN
// 25.03.2026

public class Order {
    private Item item;
    private int quantity;

    public Order(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void displayOrderInfo() {
        System.out.printf("The total cost of %s order is: %.2f\n", item.getItemName(), calculateOrderCost());
    }

    public double calculateOrderCost() {
        double total_price = (item.calculateShippingFee() + item.getItemPrice() * quantity);
        return total_price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
