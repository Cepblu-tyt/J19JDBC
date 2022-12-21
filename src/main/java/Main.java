import controllers.Customer;
import controllers.Item;
import controllers.Sales;
import controllers.menu.Menu;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();
        Item.createItemsTable();
        Sales.handleItemTotal();
        // subsequent objects will have their create table
        // methods here

        Menu.mainMenu();
    }

    // Create a method on the Sales class that takes in following input from the user
    // item_id
    // qty_purchased


}
