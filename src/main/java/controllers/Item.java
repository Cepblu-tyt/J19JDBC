package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Item {
    static Connection connection = Database.DBConn();
    static String sql;
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void getAllItems() {


        try {
            ps = connection.prepareStatement("SELECT * FROM items");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                String id = "id: " +  rs.getInt("id");
                String name = "name: " + rs.getString("name");
                String desc = "desc: " + rs.getString("description");
                String qty = "qty: " + rs.getInt("qty_in_stock");
                String price = "price: " + rs.getFloat("price");
                System.out.println(id + " " + name + " " + desc + " " + qty + " " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean createNewItem() {
        // add promts to tell user what data they need to enter next
        System.out.print("Enter the item name: ");
        String name = scanner.next();

        System.out.print("");
        String desc = scanner.next();

        System.out.print("");
        int qty = scanner.nextInt();

        System.out.print("");
        float price = scanner.nextFloat();

        try {
            ps = connection.prepareStatement("INSERT INTO items(name, description, qty_in_stock, price)" + "VALUES(' " + name + "', '" + desc + "', " + qty + ", " + price + ")");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
