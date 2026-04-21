// M. Furkan UZUN
// 25.03.2026

public enum Menu {

    NewItem("Add a New Item", SubMenu.INVENTORY, 1),
    DispItems("Display all Items", SubMenu.INVENTORY, 2),
    NumOfItems("Display the Total Number of Items", SubMenu.INVENTORY, 3),
    WorthOfInv("Calculate the Total Worth of the Inventory", SubMenu.INVENTORY, 4),
    PriceOfSpec("Increase Price of Specific Type", SubMenu.INVENTORY, 5),
    ListFreeShip("List Items with Shipping Fee Above a Limit", SubMenu.INVENTORY, 6),
    RemoveOrder("Remove Order for a Specific City", SubMenu.INVENTORY, 7),
    
    OrderNew("Add an order", SubMenu.CUSTOMER, 8),
    OrderCost("Calculate order cost", SubMenu.CUSTOMER, 9),
    
    Exit("Exit", SubMenu.CUSTOMER, 10),
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
