public class Streaming implements Service {
    private String title;
    private String category;
    private double costPerDay;
    private int days;
    private String type;

    private String destinationRegion;
    private String destinationCity;
    private String destinationPostCode;
    
    public Streaming(String title, String category, double costPerDay, int days, String type) {
        this.title = title;
        this.category = category;
        this.costPerDay = costPerDay;
        this.days = days;
        this.type = type;
    }
    
    public String getDestinationRegion() { return destinationRegion; }
    public String getDestinationCity() { return destinationCity; }
    public String getDestinationPostCode() { return destinationPostCode; }

    public void setDestinationRegion(String destinationRegion) { this.destinationRegion = destinationRegion; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public void setDestinationPostCode(String destinationPostCode) { this.destinationPostCode = destinationPostCode; }
    
    public String getServiceType() {
        return ServiceTypes.STREAMING.getText();
    }

    public void displayServiceInfo() {
        /*
            Title : CseFlix
            Category: Action
            Cost Per Day: $3.0
            Rental Days: 30
        */
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost Per Day: $" + costPerDay);
        System.out.println("Rental Days: " + days);
    }

    public double calculateService() {
        return (costPerDay * days) + calculateShippingFee();
    }

    public double calculateShippingFee() {
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
