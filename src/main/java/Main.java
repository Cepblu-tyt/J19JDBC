import controllers.Item;

import static controllers.Item.getAllItems;

public class Main {
    public static void main(String[] args) {
        Item.getAllItems();
        Item.deleteItem();
        Item.getAllItems();
    }

}
