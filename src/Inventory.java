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

    public int addItem(String itemName, double itemPrice, int itemQuantity) {
        if (itemCount >= 5) {
            System.out.println("Inventory is full.");
            return 0;
        }

        this.itemName[itemCount] = itemName;
        this.itemPrice[itemCount] = itemPrice;
        this.itemQuantity[itemCount] = itemQuantity;
        
        ++itemCount;

        return itemCount;
    }

    public int displayAllItems() {
        System.out.println("+------+---------+------------+---------+");

        for (int i = 0; i < itemCount; i++) {
            System.out.printf("| %-4d | %-7s | %-8.5f $ | %-7d |\n",
                i,
                itemName[i], 
                itemPrice[i], 
                itemQuantity[i]
            );
            
            System.out.println("+------+---------+------------+---------+");
        }

        return itemCount;
    }

    public int getTotalNumberOfItems() {
        return itemCount;
    }

    public int calculateTotalWorth() {
        int sum=0;

        for (int i=0; i<itemCount; i++) {
            sum += itemQuantity[i] * itemPrice[i];
        }

        return sum;
    }
}
