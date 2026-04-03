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
