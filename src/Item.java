public abstract class Item implements Service {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private Provider provider;
    private String type;

    private String destinationRegion;
    private String destinationCity;
    private String destinationPostCode;

    public Item(String itemName, double itemPrice, int itemQuantity, Provider provider, String type) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.provider = provider;
        this.type = type;
    }

    public String getDestinationRegion() { return destinationRegion; }
    public String getDestinationCity() { return destinationCity; }
    public String getDestinationPostCode() { return destinationPostCode; }

    public void setDestinationRegion(String destinationRegion) { this.destinationRegion = destinationRegion; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public void setDestinationPostCode(String destinationPostCode) { this.destinationPostCode = destinationPostCode; }

    public void raisePriceWithRate(double raiseRate) {
        itemPrice += itemPrice * raiseRate;
    }
    
    public String getProviderContactInfo() {
        return provider.getContactInfo();
    }

    public abstract void updateQuantity (int purchasedQuantity);

    public abstract double calculateVolumetricWeight ();

    public abstract double calculateTotalWorth();

    public double calculateShippingFee() {
        return 0;
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
