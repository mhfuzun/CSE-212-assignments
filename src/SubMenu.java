public enum SubMenu {
    INVENTORY("Inventory"),
    CUSTOMER("Customer"),
    ;

    private final String text;

    SubMenu(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getMenuline() {
        return text + " MENU:";
    }
}
