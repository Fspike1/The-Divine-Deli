package com.thedivinedeli.app;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);

    void displayHomeMenu() {
        Order order = new Order();

        boolean displayingMenu = true;
        while (displayingMenu) {

            System.out.println("Please enter your choice:");
            System.out.println("1) Start a new Order");
            System.out.println("2) View Full Menu");
            System.out.println("X) Exit");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    boolean startOrder = true;
                    while (startOrder) {

                        System.out.println("1) Add a sandwich by mood");
                        System.out.println("2) Build a custom sandwich");
                        System.out.println("3) Pick from menu");
                        System.out.println("4) View current order");
                        System.out.println("5) Remove a sandwich");
                        System.out.println("6) Checkout");
                        System.out.println("X) Return Home");

                        String userChoice2 = scanner.nextLine();
                        switch (userChoice2) {
                            case "1":
                                MoodSandwichFlow.start(scanner,order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "2":
                                CustomSandwichFlow.start(scanner, order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "3":
                                MenuSelectionFlow.start(scanner, order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "4":
                                 ViewOrderFlow.start(scanner, order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "5":
                                RemoveSandwichFlow.start(scanner, order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "6":
                                CheckoutFlow.start(scanner, order);
                                System.out.println("------------------------------------------------");
                                break;
                            case "X":
                                startOrder = false;
                                System.out.println("Return Home");
                                break;
                            default:
                                System.out.println("That was an invalid option please select a number 0-6");
                        }

                    }
                    break;
                case "2":
                    MenuSelectionFlow.start(scanner, order);
                    System.out.println("------------------------------------------------");
                    break;
                case "X":
                    displayingMenu = false;
                    System.out.println("Thank you for stopping by!");
                    System.out.println("Exiting The Divine Deli");
                    break;
                default:
                    System.out.println("That was not a valid option please select:");
                    System.out.println("1) Start a new Order");
                    System.out.println("2) View Full Menu");
                    System.out.println("X) Exit");


            }

        }
    }

}
