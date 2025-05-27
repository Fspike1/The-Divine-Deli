package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomSandwichFlow {
    public static void start(Scanner scanner, Order order){
        System.out.println("You chose to customize your own sandwich. Let's create the perfect sandwich for you!");

        System.out.println("What’s your name for the order?");
        order.setCustomerName(scanner.nextLine());
        order.setTimeStamp(LocalDateTime.now().toString());

        Sandwich custom = new Sandwich();
            custom.customize(scanner);

            System.out.println("Would you like to add this sandwich to your order? (yes/no)");
            String userChoice2 = scanner.nextLine();
            if (userChoice2.equalsIgnoreCase("yes")) {
                System.out.println("Your sandwich has been added to the cart.");
                order.addSandwiches(custom);
            }
            else {
                System.out.println("No problem! Returning to the main menu");
            }

        }


    }
