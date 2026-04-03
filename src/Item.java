public class Item {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private Provider provider;
    private String type;

    public Item(String itemName, double itemPrice, int itemQuantity, Provider provider, String type) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.provider = provider;
        this.type = type;
    }

    public String getProviderContactInfo() {
        return provider.getContactInfo();
    }

    public void updateQuantity (int purchasedQuantity) {
        itemQuantity -= purchasedQuantity;
    }

    public double calculateVolumetricWeight () {
        return 0;
    }

    public double calculateShippingFee() {
        return 0;
    }

    public double calculateTotalWorth() {
        return itemPrice * itemQuantity + calculateShippingFee();
    }

    public void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + itemPrice);
        System.out.println("Quantity: " + itemQuantity);
        System.out.println("Provider: " + provider.getName());
        System.out.println("Provider Contact: " + provider.getContactInfo());
    }

    public void displayAddedMessage(boolean succ) {
        if (succ) {
            System.out.println("Item added successfully!");
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
