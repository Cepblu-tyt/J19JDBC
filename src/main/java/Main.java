import controllers.Customer;
import controllers.Item;
import controllers.menu.Menu;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();
        Item.createItemsTable();
        // subsequent objects will have their create table
        // methods here

        Menu.mainMenu();
    }

    // Write


}
