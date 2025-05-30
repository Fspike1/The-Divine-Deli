package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.Scanner;

import static com.thedivinedeli.app.Main.slowPrint;

public class MoodSandwichFlow {

    public static void start(Scanner scanner, Order order) {

        System.out.println("\n🌈✨ WELCOME TO THE MOOD COMBO SANCTUARY ✨🌈");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        slowPrint("Would you like to:", 40);
        System.out.println("1️⃣  Get a sandwich based on your mood or create your own");
        System.out.println("2️⃣  Return to the Main Menu");
        System.out.print("👉 Select 1 or 2: ");
        String userChoice = scanner.nextLine().trim();
        System.out.println();

        DivineDeliMenu matcher = null;
        matcher = new DivineDeliMenu();
        String userMood = "";


        if (userChoice.equalsIgnoreCase("2")) {
            //matcher.printMoodMenu(); //show the full menu

            System.out.println("Press enter to return to main menu..");
            scanner.nextLine();
            System.out.println("Returning to the Main Menu");
            return;

        } else if (userChoice.equalsIgnoreCase("1")) {
            System.out.println("\n📝Can I get a name for the order?");
            System.out.print("👉 Enter your name: ");
            order.setCustomerName(scanner.nextLine());
            order.setTimeStamp(LocalDateTime.now().toString());
            System.out.println("Here are some moods to inspire you, or feel free to type your own:");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("""
        🌞 Happy         🧊 Detached
        💔 Heartbroken   💤 Exhausted
        🍷 Wasted        😵 Overwhelmed
        🌱 Hopeful       😔 Lonely
        😡 Upset""");
            System.out.print("👉 Your mood: ");
            userMood = scanner.nextLine().trim();
        } else {
            System.out.println("That was an invalid option. Please try again.");
        }


        Sandwich mySandwich = matcher.sandwichSuggestion(userMood, scanner);
        String size = mySandwich.getSize();
        if (mySandwich == null) {
            System.out.println("Returning to the menu...");
            return;
        }
        mySandwich.setSize(size); //Just to be sure it's set

        Sandwich finalSandwich = mySandwich;

        System.out.println("Your suggested sandwich is " + finalSandwich);


        System.out.println("Would you like to add this sandwich to the cart? (yes/no): ");
        String output = scanner.nextLine();
        if (output.equalsIgnoreCase("yes")) {

            System.out.println("Adding your sandwich to the cart ");
            System.out.println("\n🥤✨ Would you like to make it a combo?");
            System.out.println("Includes chips and a drink for just $1.11 😌🍟🥤");
            System.out.print("👉 Your choice (yes/no): ");
            String comboChoice = scanner.nextLine().trim();

            if (comboChoice.equalsIgnoreCase("yes")) {
                mySandwich.setComboIncluded(true);
                mySandwich.setComboPrice(1.11);

                System.out.println("Please choose your chips:");
                ComboFlow.getChipsMap().forEach((key, item) ->
                        System.out.println(key + ": " + item.getName()));
                String chipChoice = scanner.nextLine();

                System.out.println("Please choose your drink:");
                ComboFlow.getDrinksMap().forEach((key, item) ->
                        System.out.println(key + ": " + item.getName()));
                String drinkChoice = scanner.nextLine();

                order.addCombo(mySandwich, chipChoice, drinkChoice);
                System.out.println("Combo added! Chips and drink included.\n");

                System.out.println("You've created a custom masterpiece!\n" +
                        "\n" +
                        "\uD83D\uDED2 Your sandwich has been added to your order.\n" +
                        "\n" +
                        "\uD83D\uDCE2 Psst... Sharing your sandwich with the world is coming soon!\n" +
                        "Soon, you'll be able to officially add it to The Divine Deli menu. Stay tuned!\n");

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

