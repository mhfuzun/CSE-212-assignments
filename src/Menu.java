// M. Furkan UZUN
// 25.03.2026

public enum Menu {

    NewItem("Add a New Item", SubMenu.INVENTORY, 1),
    DispItems("Display all Items", SubMenu.INVENTORY, 2),
    NumOfItems("Display the Total Number of Items", SubMenu.INVENTORY, 3),
    WorthOfInv("Calculate the Total Worth of the Inventory", SubMenu.INVENTORY, 4),
    
    OrderNew("Add an order", SubMenu.CUSTOMER, 5),
    OrderCost("Calculate order cost", SubMenu.CUSTOMER, 6),
    
    Exit("Exit", SubMenu.CUSTOMER, 7),
    ;

    private final String text;
    private final SubMenu subMenu;
    private final int menuIndex;

    Menu(String text, SubMenu subMenu, int menuIndex) {
        this.text = text;
        this.subMenu = subMenu;
        this.menuIndex = menuIndex;
    }

    public String getText() {
        return text;
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public String getMenuline() {
        return menuIndex + ". " + text;
    }
}
