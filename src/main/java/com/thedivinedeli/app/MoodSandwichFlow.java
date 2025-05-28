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

            System.out.println("Can I get a name for the order?");
            order.setCustomerName(scanner.nextLine());
            order.setTimeStamp(LocalDateTime.now().toString());



            matcher = new DivineDeliMenu();

            Sandwich mySandwich = matcher.sandwichSuggestion(userMood, scanner);

            System.out.println("What size would you like? (6in, 8in, or 12in):");
            String size = scanner.nextLine();
            while (!size.equals("6in") && !size.equals("8in") && !size.equals("12in")) {
                System.out.println("That is not a valid size. Please select 6in, 8in, or 12in.");
                size = scanner.nextLine();
            }
            mySandwich.setSize(size);

            System.out.println("Would you like extra cheese? (yes/no):");
            String cheeseResponse = scanner.nextLine();
            mySandwich.setExtraCheese(cheeseResponse.equalsIgnoreCase("yes") ? "Yes" : "No");//? "yes" : "No" is a Shortened if else statement

            System.out.println("Would you like extra meat? (yes/no):");
            String meatResponse = scanner.nextLine();
            mySandwich.setExtraMeat(meatResponse.equalsIgnoreCase("yes") ? "Yes" : "No");

            System.out.println("Your suggested sandwich is: " + mySandwich);

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
