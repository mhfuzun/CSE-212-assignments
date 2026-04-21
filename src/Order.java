// M. Furkan UZUN
// 25.03.2026

public class Order {
    private Service service;
    private int quantity;

    private String destinationRegion;
    private String destinationCity;
    private String destinationPostCode;

    public Order(Service service, int quantity) {
        this.service = service;
        this.quantity = quantity;
    }

    public void displayOrderInfo() {
        System.out.printf("The total cost of %s order is: %.2f\n", Service.getServiceName(service), calculateOrderCost());
    }

    public double calculateOrderCost() {
        double total_price = (service.calculateShippingFee() + service.calculateService() * quantity);
        return total_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(String destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationPostCode() {
        return destinationPostCode;
    }

    public void setDestinationPostCode(String destinationPostCode) {
        this.destinationPostCode = destinationPostCode;
    }

    
}
