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

    public void displayAddedMessage(boolean succ) {
        if (succ) {
            System.out.println("Physical item added successfully!");
        }
    }

    public double calculateVolumetricWeight () {
        // volumetricWeight = (length × width × height) / 5000
        return (length * width * height) / 5000;
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
