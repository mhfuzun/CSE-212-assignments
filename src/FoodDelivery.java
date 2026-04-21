public class FoodDelivery implements Service {
    private String foodName;
    private String restaurantName;
    private double mealPrice;
    private int count;
    private String type;

    private String destinationRegion;
    private String destinationCity;
    private String destinationPostCode;
    
    public FoodDelivery(String foodName, String restaurantName, double mealPrice, int count, String type) {
        this.foodName = foodName;
        this.restaurantName = restaurantName;
        this.mealPrice = mealPrice;
        this.count = count;
        this.type = type;
    }
    
    public String getDestinationRegion() { return destinationRegion; }
    public String getDestinationCity() { return destinationCity; }
    public String getDestinationPostCode() { return destinationPostCode; }

    public void setDestinationRegion(String destinationRegion) { this.destinationRegion = destinationRegion; }
    public void setDestinationCity(String destinationCity) { this.destinationCity = destinationCity; }
    public void setDestinationPostCode(String destinationPostCode) { this.destinationPostCode = destinationPostCode; }

    public String getServiceType() {
        return ServiceTypes.FOODDELIVERY.getText();
    }

    public void displayServiceInfo() {
        /*
            Food Name: Hamburger
            Restaurant Name: Arby's
            Meal Price: $9.99
            Food Count: 100
        */
       
        System.out.println("Food Name: " + foodName);
        System.out.println("Restaurant Name: " + restaurantName);
        System.out.println("Meal Price: $" + mealPrice);
        System.out.println("Food Count: " + count);
    }

    public double calculateService() {
        return (mealPrice * count) + calculateShippingFee();
    }

    public double calculateShippingFee() {
        return 5; // $5 shipping fee
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
