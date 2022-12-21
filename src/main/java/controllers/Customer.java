package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    //CRUD - CREATE READ UPDATE DELETE

    // Create a table for the class above if and only if it doesn't already exist.
    public static boolean createCustomerTable() {
        try {
            ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS customer(" +
                            " id serial," +
                            " first_name varchar(255)," +
                            " last_name varchar(255)," +
                            " email varchar(255)," +
                            " PRIMARY KEY(id))");

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getAllCustomers() {
        try {
            ps = connection.prepareStatement("SELECT * FROM customer");
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String firstName = "first_name: " + rs.getString("first_name");
                String lastName = "last_name: " + rs.getString("last_name");
                String email = "email: " + rs.getString("email");
                System.out.println(id + ", " + firstName + ", " + lastName + ", " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 30 mins
    // Complete the Customer class by adding the CREATE, UPDATE and DELETE functionalities
    // to handle those respective operations on a customer objects or record.

    public static boolean createNewCustomer() {
        // Add prompts to tell the user what data they need to enter next
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        try {
            ps = connection.prepareStatement("INSERT INTO customer(first_name, last_name, email) " +
                    "VALUES('" + firstName + "', '" + lastName + "', '" + email + "')");

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




    public static boolean updateCustomer() {
        // Prompt the user for info
        System.out.print("Enter the new first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the new last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the customer's id: ");
        int id = scanner.nextInt();

        System.out.print("Enter the new email: ");
        String email = scanner.nextLine();

        try {
            ps = connection.prepareStatement("UPDATE customer SET " +
                    "first_name = '" + firstName + "', " +
                    "last_name = '" + lastName + "', " +
                    "email = '" + email + "' " +
                    "WHERE id = " + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean deleteCustomer() {

        System.out.print("Enter the customer's id: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM customer " +
                    "WHERE id = " + id);
            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}
