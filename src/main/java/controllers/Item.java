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
        String name = scanner.nextLine();

        System.out.print("Enter the item description: ");
        String desc = scanner.nextLine();

        System.out.print("Enter the item qty: ");
        int qty = scanner.nextInt();

        System.out.print("Enter the item price:");
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
    // 20 min.
    // Implement a method to update an item using its id, where its id
    // should be passed by the user, i. e use the scanner class to get the id.


    public static boolean updateItem() {
        // Prompt the user for info
        System.out.print("Enter the new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new description: ");
        String desc = scanner.nextLine();

        System.out.print("Enter the item's id: ");
        int id = scanner.nextInt();

        System.out.print("Enter the new quantity: ");
        int qty = scanner.nextInt();

        try {
            ps = connection.prepareStatement("UPDATE items SET " +
                    "name = '" + name + "', " +
                    "description = '" + desc + "', " +
                    "qty_in_stock = " + qty + " " +
                    "WHERE id = " + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean deleteItem() {

        System.out.print("Enter the item's id: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM items " +
                   "WHERE id = " + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getItemById() {

        System.out.print("Enter the items id you want to get info: ");
        int id = scanner.nextInt();

        try{
            ps = connection.prepareStatement("SELECT * FROM items WHERE id = "+id+"");
            rs = ps.executeQuery();

            //Loop through the result set
            while (rs.next()) {
                // String id = "id: " + rs.getInt("id");
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

}
