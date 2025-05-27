package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MoodSandwichFlow {

    public static void start(Scanner scanner, Order order) {
        System.out.println("How are you feeling today?");
        String userMood = scanner.nextLine();
        System.out.println("Would you like a sandwich suggestion based on your mood, create your own, or would you like to see our full menu? ");
        System.out.println("select Mood, Custom, or Menu");

        String userChoice = scanner.nextLine();
        DivineDeliMenu matcher = null;
        if (userChoice.equalsIgnoreCase("Mood")) {
            System.out.println("Select from the following Moods or input your own");
            System.out.println("""
                    - Happy
                    - Detached
                    - Heartbroken
                    - Exhausted
                    - Wasted
                    - Overwhelmed
                    - Hopeful
                    - Lonely
                    - Upset""");
            userMood = scanner.nextLine();

            matcher = new DivineDeliMenu();
            Sandwich mySandwich = matcher.sandwichSuggestion(userMood, scanner);

            System.out.println("Can I get a name for the order?");
            order.setCustomerName(scanner.nextLine());
            order.setTimeStamp(LocalDateTime.now().toString());

            System.out.println("Would you like to order this sandwich? (yes/no): ");
            String output = scanner.nextLine();
            if (output.equalsIgnoreCase("yes")){
                order.addSandwiches(mySandwich);
                System.out.println("Here is your sandwich: " + mySandwich);

            }
            else if (output.equalsIgnoreCase("no")){
                System.out.println("No problem, returning to Home Screen");
            }

        }
    }
}
