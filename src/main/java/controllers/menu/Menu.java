package controllers.menu;

import controllers.Customer;
import controllers.Item;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Items");
        System.out.println("2. Customer");

        System.out.println();
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                itemsMenu();
                break;
            case 2:
                customerMenu();
                break;
            default:
                System.out.println("Invalid option.");
                mainMenu();
                break;
        }
    }

    public static void itemsMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get All Items");
        System.out.println("2. Create New Item");

        System.out.println();
        System.out.print("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Item.getAllItems();
                itemsMenu();
                break;
            case 2:
                Item.createNewItem();
                itemsMenu();
                break;
            default:
                System.out.println("Invalid option.");
                itemsMenu();
                break;
        }
    }

    public static void customerMenu() {
        System.out.println("Pick a submenu number to continue: ");
        System.out.println("1. Get All Customers");
//        System.out.println("2. Create New Item");

        System.out.println();
        System.out.print("Select an option or enter 0 to go back to the main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Customer.getAllCustomers();
                customerMenu();
                break;
//            case 2:
//                Item.createNewItem();
//                itemsMenu();
//                break;
            default:
                System.out.println("Invalid option.");
                customerMenu();
                break;
        }
    }
}