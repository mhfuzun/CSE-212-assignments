public interface Service {
    public abstract String getServiceType();
    public abstract double calculateService();
    public abstract void displayServiceInfo();
    public abstract double calculateShippingFee();
    public abstract String getDestinationRegion();
    public abstract String getDestinationCity();
    public abstract String getDestinationPostCode();
    public abstract void setDestinationRegion(String s);
    public abstract void setDestinationCity(String s);
    public abstract void setDestinationPostCode(String s);

    public static String getServiceName(Service s) {
        if (s instanceof Item) {
            return ((Item) s).getItemName();
        } else if (s instanceof Streaming) {
            return ((Streaming) s).getTitle();
        } else if (s instanceof FoodDelivery) {
            return ((FoodDelivery) s).getFoodName();
        }
        return "";
    }

    public static Item toItem(Service s) {
        if (s instanceof Item) {
            return (Item) s;
        }
        return null;
    }

    public static Streaming toStreaming(Service s) {
        if (s instanceof Streaming) {
            return (Streaming) s;
        }
        return null;
    }

    public static FoodDelivery toFoodDelivery(Service s) {
        if (s instanceof FoodDelivery) {
            return (FoodDelivery) s;
        }
        return null;
    }
}
