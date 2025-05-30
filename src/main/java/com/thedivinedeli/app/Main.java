package com.thedivinedeli.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Order order = new Order();
        ComboFlow.setChipsMap();
        ComboFlow.setDrinksMap();


        while (true) {
            boolean startOrder = new HomeScreen().displayHomeMenu(order);

            if (!startOrder) {
                break;
            }
            boolean placingOrder = true;
            while (placingOrder) {
                new HomeScreen().printMainMenuOptions();

                String userChoice2 = scanner.nextLine().trim().toUpperCase();
                if (userChoice2.isBlank()) {
                    continue; // Skip this loop cycle and re-display the menu cleanly
                }
                switch (userChoice2) {
                    case "1":
                        MoodSandwichFlow.start(scanner, order);
                        break;
                    case "2":
                        MenuSelectionFlow.start(scanner, order);
                        break;
                    case "3":
                        RemoveSandwichFlow.start(scanner, order);
                        break;
                    case "4":
                        ComboFlow.start(scanner, order);
                        break;
                    case "5":
                        ViewOrderFlow.start(scanner, order);
                        System.out.println("Press Enter to return to the Main Menu...");
                        scanner.nextLine();

                        //case "6":
                        // CheckoutFlow.start(scanner, order);
                        //break;
                    case "X":
                        break;
                    default:
                        System.out.println(" Invalid choice. Please select an option from the main menu...");
                }
            }

        }

    }
    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay); // Delay in milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // move to next line after printing
    }
}


