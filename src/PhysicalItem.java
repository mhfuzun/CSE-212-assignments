public class PhysicalItem extends Item {
    private double width;
    private double length;
    private double height;

    public PhysicalItem(
        String itemName, 
        double itemPrice, 
        int itemQuantity, 
        Provider provider, 
        String type, 
        double width, 
        double length, 
        double height
    ) {
        super(itemName, itemPrice, itemQuantity, provider, type);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public String getServiceType() {
        return ServiceTypes.PHYSICALITEM.getText();
    }

    public void displayServiceInfo() {
        /*
            Item : iPhone
            Price: $999.0
            Quantity: 500
            Provider: Amazon
            Provider Contact: +90(850)3902153
        */

        System.out.println("Item: " + getItemName());
        System.out.println("Price: $" + getItemPrice());
        System.out.println("Quantity: " + getItemQuantity());
        System.out.println("Provider: " + getProvider().getName());
        System.out.println("Provider Contact: " + getProviderContactInfo());
        System.out.printf("Width: %.2f, Length: %.2f, Height: %.2f\n", width, length, height);
    }

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
        // volumetricWeight = (length × width × height) / 5000
        return (length * width * height) / 5000;
    }
    
    public void displayAddedMessage(boolean succ) {
        if (succ) {
            System.out.println("Physical item added successfully!");
        }
    }

    public double calculateShippingFee() {
        /**
         *  | Volumetric Weight (vW)        | Coefficient   |
            | vW < 1                        |    0.10       |
            | vW >= 1 and vW < 2            |    0.25       |
            | vW >= 2 and vW < 5            |    0.35       |
            | vW >= 5                       |    0.50       |
         */
        double volumetricWeight = calculateVolumetricWeight();
        double rate = 0;
        if (volumetricWeight >= 5) {
            rate = 0.5;
        } else if (volumetricWeight >= 2) {
            rate = 0.35;
        } else if (volumetricWeight >= 1) {
            rate = 0.25;
        } else {
            rate = 0.1;
        }

        return getItemPrice() * volumetricWeight * rate;
    }
}
