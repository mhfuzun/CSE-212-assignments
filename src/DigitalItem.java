public class DigitalItem extends Item {

    private double diskSpace;

    public DigitalItem(
        String itemName, 
        double itemPrice, 
        int itemQuantity, 
        Provider provider, 
        String type, 
        double diskSpace
    ) {
        super(itemName, itemPrice, itemQuantity, provider, type);
        this.diskSpace = diskSpace;
    }
    
    public String getServiceType() {
        return ServiceTypes.DIGITALITEM.getText();
    }

    @Override
    public void displayServiceInfo() {
        /*
            Item : Baldur's Gate Game
            Price: $59.99
            Quantity: 30
            Provider: eBay
            Provider Contact: +1(408)5168811
            Disk Space: 6.0
        */

        System.out.println("Item: " + getItemName());
        System.out.println("Price: $" + getItemPrice());
        System.out.println("Quantity: " + getItemQuantity());
        System.out.println("Provider: " + getProvider().getName());
        System.out.println("Provider Contact: " + getProviderContactInfo());
        System.out.println("Disk Space: " + diskSpace);
    }

    @Override
    public double calculateService() {
        return calculateTotalWorth();
    }

    @Override
    public void updateQuantity (int purchasedQuantity) {
        setItemQuantity(getItemQuantity() - purchasedQuantity);
    }

    @Override
    public double calculateTotalWorth() {
        return getItemPrice() * getItemQuantity() + calculateShippingFee();
    }
    
    @Override
    public double calculateVolumetricWeight () {
        return 0;
    }

    public void displayAddedMessage(boolean succ) {
        if (succ) {
            System.out.println("Digital item added successfully!");
        }
    }

    public double getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(double diskSpace) {
        this.diskSpace = diskSpace;
    }

    
}
