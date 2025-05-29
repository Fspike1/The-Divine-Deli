package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MoodSandwichFlow {

    public static void start(Scanner scanner, Order order) {
        System.out.println("How are you feeling today?");
        String userMood = scanner.nextLine();


        System.out.println("""
                Would you like:
                1) A sandwich suggestion based on your mood/create your own sandwich\
                \n2) View our full menu?""");
        System.out.println("Select 1 or 2");

        String userChoice = scanner.nextLine().trim();

        DivineDeliMenu matcher = null;
        if (userChoice.equalsIgnoreCase("1")) {
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
        } else if (userChoice.equalsIgnoreCase("2")) {
            matcher = new DivineDeliMenu(); //initialize menu
            matcher.printMoodMenu(); //show the full menu

            System.out.println("Press enter to return to main menu..");
            scanner.nextLine();
            return;
        } else {
            System.out.println("That was an invalid option. Please try again.");
        }

        System.out.println("Can I get a name for the order?");
        order.setCustomerName(scanner.nextLine());
        order.setTimeStamp(LocalDateTime.now().toString());


        matcher = new DivineDeliMenu();

        Sandwich mySandwich = matcher.sandwichSuggestion(userMood, scanner);
        String size = mySandwich.getSize();

        if (size == null || size.isBlank()) {
            System.out.println("What size would you like? (6in, 8in, or 12in):");
            String sandwichSize = scanner.nextLine();
            while (!sandwichSize.equals("6in") && !sandwichSize.equals("8in") && !sandwichSize.equals("12in")) {
                System.out.println("That is not a valid size. Please select 6in, 8in, or 12in.");
                sandwichSize = scanner.nextLine();
            }


        mySandwich.setSize(size);
            size = sandwichSize;
    }

        mySandwich.setSize(size); // Just to be sure it's set
        Sandwich finalSandwich = mySandwich;

        System.out.println("Your suggested sandwich is " + finalSandwich);


            System.out.println("Would you like to add this sandwich to the cart? (yes/no): ");
            String output = scanner.nextLine();
            if (output.equalsIgnoreCase("yes")) {

                System.out.println("Adding your sandwich to the cart ");
                System.out.println("Would you like to make it a combo? It includes chips and a drink for just $1.11 (yes/no)");
                String comboChoice = scanner.nextLine().trim();

                if (comboChoice.equalsIgnoreCase("yes")) {
                    mySandwich.setComboIncluded(true);
                    mySandwich.setComboPrice(1.11);

                    System.out.println("Please choose your chips:");
                    ComboFlow.getChipsMap().forEach((key, item) ->
                            System.out.println(key + ": " + item.getName())
                    );
                    String chipChoice = scanner.nextLine();

                    System.out.println("Please choose your drink:");
                    ComboFlow.getDrinksMap().forEach((key, item) ->
                            System.out.println(key + ": " + item.getName())
                    );
                    String drinkChoice = scanner.nextLine();

                    order.addCombo(mySandwich, chipChoice, drinkChoice);
                    System.out.println("Combo added! Chips and drink included.");

                } else {
                    mySandwich.setComboIncluded(false);
                    order.addSandwiches(mySandwich);
                    System.out.println("Sandwich added to your order!");
                }




            } else if (output.equalsIgnoreCase("no")) {
                System.out.println("No problem, returning to Home Screen");
            }


    }
}

