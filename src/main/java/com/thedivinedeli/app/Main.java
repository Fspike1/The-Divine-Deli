package com.thedivinedeli.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean startOrder = new HomeScreen().displayHomeMenu();

        if (startOrder) {
            Order order = new Order();
            ComboFlow.setChipsMap();
            ComboFlow.setDrinksMap();

            boolean placingOrder = true;
            while (placingOrder) {
                System.out.println("1) Add a sandwich based on your mood or create your own");
                System.out.println("2) Pick from menu");
                System.out.println("3) View current order");
                System.out.println("4) Remove a sandwich");
                System.out.println("5) Add a Special Combo");
                System.out.println("6) Checkout");
                System.out.println("X) Return Home");

                String userChoice2 = scanner.nextLine();
                switch (userChoice2.toUpperCase()) {
                    case "1":
                        MoodSandwichFlow.start(scanner, order);
                        break;

                    case "2":
                        MenuSelectionFlow.start(scanner, order);
                        break;
                    case "3":
                        ViewOrderFlow.start(scanner, order);
                        break;
                    case "4":
                        RemoveSandwichFlow.start(scanner, order);
                        break;
                    case "5":
                        ComboFlow.start(scanner, order);
                        break;
                    case "6":
                        CheckoutFlow.start(scanner, order);
                        break;
                    case "X":
                        placingOrder = false;
                        System.out.println("Returning to Home...");
                        break;
                    case "":
                        break;
                    default:
                        System.out.println(" Invalid choice. Taking you back to the main menu...");
                }
                System.out.println("------------------------------------------------");
            }
        }
    }
}

