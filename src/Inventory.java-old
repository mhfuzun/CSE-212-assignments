// M. Furkan UZUN
// 14.03.2026

public class Inventory {
    public final int maxItemCount = 5; 

    private String[] itemName;
    private double[] itemPrice;
    private int[] itemQuantity;
    private int itemCount;

    public Inventory() {
        itemName = new String[maxItemCount];
        itemPrice = new double[maxItemCount];
        itemQuantity = new int[maxItemCount];
        itemCount = 0;
    }

    public boolean addItem(String itemName, double itemPrice, int itemQuantity) {
        if (itemCount >= maxItemCount) {
            System.out.println("Inventory is full.");
            return false;
        }

        this.itemName[itemCount] = itemName;
        this.itemPrice[itemCount] = itemPrice;
        this.itemQuantity[itemCount] = itemQuantity;
        
        itemCount++;

        return true;
    }

    public void displayAllItems() {
        System.out.println("Inventory Items:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println("Item " + (i + 1) + ": " + itemName[i] + ", Price: $" + itemPrice[i] + ", Quantity: " + itemQuantity[i]);
        }
    }

    public int getTotalNumberOfItems() {
        return itemCount;
    }

    public double calculateTotalWorth() {
        double sum = 0.0;

        for (int i = 0; i < itemCount; i++) {
            sum += itemQuantity[i] * itemPrice[i];
        }

        return sum;
    }

    private int findItemIDXWithItemName(String itemName) {
        for (int i=0; i<itemCount; i++) {
            if (this.itemName[i].equals(itemName)) {
                return i;
            }
        }

        return -1;
    }

    public int getItemCountWithItemName(String itemName) {
        int itemIDX = findItemIDXWithItemName(itemName);
        if (itemIDX != -1) {
            return itemQuantity[itemIDX];
        }

        return -1;
    }

    public double getItemPriceWithItemName(String itemName) {
        int itemIDX = findItemIDXWithItemName(itemName);
        if (itemIDX != -1) {
            return itemPrice[itemIDX];
        }

        return 0;
    }
}
