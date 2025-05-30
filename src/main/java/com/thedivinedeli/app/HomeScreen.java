package com.thedivinedeli.app;

import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);

    boolean displayHomeMenu() {
        Order order = new Order();

        boolean displayingMenu = true;
        while (displayingMenu) {

            System.out.println("Please enter your choice:");
            System.out.println("1) Start a new Order");
            System.out.println("2) View Full Menu");
            System.out.println("X) Exit");
            String userChoice = scanner.nextLine();

            switch (userChoice.toUpperCase()) {
                case "1":
                        return true;
                case "2":
                    MenuSelectionFlow.start(scanner, order);
                    System.out.println("------------------------------------------------");
                    break;
                case "X":
                    displayingMenu = false;
                    System.out.println("Thank you for stopping by!");
                    System.out.println("Exiting The Divine Deli");
                    return false;
                default:
                    System.out.println("That was not a valid option please select:");
                    break;


            }

        }
        return false;
    }

}
