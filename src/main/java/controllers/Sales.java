package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static controllers.Customer.connection;
import static controllers.Item.ps;
import static controllers.Item.rs;

public class Sales {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);
    public static boolean createSalesTable() {
        try {
            ps = connection.prepareStatement(
                    "CREATE TABLE  sales(" +
                            " id serial PRIMARY KEY," +
                            " customer_id int," +
                            " date_purchased TIMESTAMP," +
                            " total float," +
                            " FOREIGN KEY (customer_id) REFERENCES customer)");

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }







    public static void handleItemTotal(){
        System.out.println("Enter how many items were bought: ");
        int numberOfItems = scanner.nextInt();

        Map<Integer, Integer> items = new HashMap<>();
        float itemTotal = 0;

        for ( int i =0; i < numberOfItems; i++) {
            //use the collection to get the item be the id after you pass in into the map
            System.out.print(" Enter the item id: ");
            int itemId= scanner.nextInt();

            System.out.print(" Enter the qty purchased: ");
            int qty = scanner.nextInt();

            float itemPrice = 0;


            try {
                ps = connection.prepareStatement("SELECT price FROM items WHERE id= " + itemId);
                rs = ps.execute();

                while (rs.next()) {
                    itemPrice = rs.getFloat("price");
                }
                itemTotal = itemPrice * qty;

                items.putIfAbsent(itemId, itemTotal);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        System.out.println(items);
    }
}
