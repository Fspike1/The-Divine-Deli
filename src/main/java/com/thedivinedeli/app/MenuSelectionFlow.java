package com.thedivinedeli.app;

import java.util.Map;
import java.util.Scanner;

public class MenuSelectionFlow {

    public static void start(Scanner scanner, Order order) {
        ComboFlow.setChipsMap();
        ComboFlow.setDrinksMap();

        DivineDeliMenu menu = new DivineDeliMenu();
        Map<String, Sandwich> moodMap = menu.getMoodMenu();
        System.out.println("Here is the full menu");
        menu.printMoodMenu();
        System.out.println("Would you like to order one of these sandwiches?");
        System.out.println("Select a mood from the menu or enter X to return to Home Screen");
        String moodChoice = scanner.nextLine().toUpperCase();

        if (moodMap.containsKey(moodChoice)) {
            //USE prepareMenuSandwich for full customization
            Sandwich customizedSandwich = menu.prepareMenuSandwich(moodChoice, scanner);
            customizedSandwich.setMoodBased(true);

            System.out.println("Select your size (6in, 8in, or 12in): ");
            String size = scanner.nextLine();
            while (!size.equals("6in") && !size.equals("8in") && !size.equals("12in")) {
                System.out.println("Invalid size. Please choose 6in, 8in, or 12in:");
                size = scanner.nextLine();
            }
            customizedSandwich.setSize(size);

            System.out.println("Would you like extra cheese? (yes/no)");
            String extraCheese = scanner.nextLine();
            customizedSandwich.setExtraCheese(extraCheese.equalsIgnoreCase("yes") ? "yes" : "no");

            System.out.println("Would you like extra meat? (yes/no)");
            String extraMeat = scanner.nextLine();
            customizedSandwich.setExtraMeat(extraMeat.equalsIgnoreCase("yes") ? "yes" : "no");


            if (customizedSandwich != null) {
                System.out.println("You picked: " + customizedSandwich.getSandwichName());

                System.out.println("Would you like to make it a combo? It includes chips and a drink for just $1.11 (yes/no)");
                String makeCombo = scanner.nextLine();

                if (makeCombo.equalsIgnoreCase("yes")) {

                    customizedSandwich.setComboIncluded(true);
                    customizedSandwich.setComboPrice(1.11);

                    System.out.println("Please choose your chips:");
                    ComboFlow.getChipsMap().forEach((key, item) ->
                            System.out.println(key + ": " + item.getName()));
                    String chipChoice = scanner.nextLine();

                    System.out.println("Please choose your drink:");
                    ComboFlow.getDrinksMap().forEach((key, item) ->
                            System.out.println(key + ": " + item.getName())
                    );
                    String drinkChoice = scanner.nextLine();

                    order.addCombo(customizedSandwich, chipChoice, drinkChoice);

                    System.out.println("Combo added! Chips and drink included.");


                }
                else {
                    customizedSandwich.setComboIncluded(false);
                    order.addSandwiches(customizedSandwich);
                    System.out.println("Sandwich added to your order!");
                }
            }

        } else if (moodChoice.equalsIgnoreCase("X")) {
            System.out.println("Returning you to the Home Screen");
        } else {
            System.out.println("Please input a valid mood or enter X to return to the Home Screen.");
        }
    }
}

