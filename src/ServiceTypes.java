public enum ServiceTypes {
    FOODDELIVERY("Food Delivery"),
    PHYSICALITEM("Physical"),
    DIGITALITEM("Digital"),
    STREAMING("Streaming"),
    ;

    private final String text;

    ServiceTypes(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
