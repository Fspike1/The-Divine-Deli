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
                System.out.println("1) Add a sandwich by mood");
                System.out.println("2) Build a custom sandwich");
                System.out.println("3) Pick from menu");
                System.out.println("4) View current order");
                System.out.println("5) Remove a sandwich");
                System.out.println("6) Add a Special Combo");
                System.out.println("7) Checkout");
                System.out.println("X) Return Home");

                String userChoice2 = scanner.nextLine();
                switch (userChoice2.toUpperCase()) {
                    case "1":
                        MoodSandwichFlow.start(scanner, order);
                        break;
                    case "2":
                        CustomSandwichFlow.start(scanner, order);
                        break;
                    case "3":
                        MenuSelectionFlow.start(scanner, order);
                        break;
                    case "4":
                        ViewOrderFlow.start(scanner, order);
                        break;
                    case "5":
                        RemoveSandwichFlow.start(scanner, order);
                        break;
                    case "6":
                        ComboFlow.start(scanner, order);
                        break;
                    case "7":
                        CheckoutFlow.start(scanner, order);
                        break;
                    case "X":
                        placingOrder = false;
                        System.out.println("Returning to Home...");
                        break;
                    default:
                        System.out.println("Invalid choice, try again!");
                }
                System.out.println("------------------------------------------------");
            }
        }
    }
}

