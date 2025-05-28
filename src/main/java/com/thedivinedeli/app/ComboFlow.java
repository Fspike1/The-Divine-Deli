package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ComboFlow {
    private static Map<String, ComboItem> chipsMap;
    private static Map<String, ComboItem> drinksMap;

    public static void start(Scanner scanner, Order order) {
        DivineDeliMenu matcher = null;

        System.out.println("\nWelcome to the Divine Deli: Mood Combo Sanctuary");
        System.out.println("How are you feeling today?");
        String userMood = scanner.nextLine();
        System.out.println("I have the perfect combo for you! ");
        System.out.println("Select from the following Moods");
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

        System.out.println("Would you like to continue with this combo? (yes/no): ");
        String output = scanner.nextLine();
        if (output.equalsIgnoreCase("yes")) {
            order.addSandwiches(mySandwich);
            System.out.println("Let's get your chips and drink as well!");
        } else if (output.equalsIgnoreCase("no")) {
            System.out.println("No problem, returning to Home Screen");
        }

        System.out.println("What chips  would like to add?");
        for (String chips : chipsMap.keySet()) {
            System.out.println("-" + chips);
            String chipsForCombo = scanner.nextLine();
        }
        System.out.println("What drink would you like to add?");
        for (String drink : drinksMap.keySet()) {
            System.out.println("-" + drink);
            String drinkForCombo = scanner.nextLine();
        }
        Order comboOrder = new Order();
        comboOrder.addSandwiches(mySandwich);
        comboOrder.printReceipt();


            boolean validDrinkChosen = false;
            while (!validDrinkChosen) {
                for (String drink : drinksMap.keySet()) {
                    System.out.println("->" + drink);

                System.out.println("Enter your drink name: ");
                String drinkChoice = scanner.nextLine().trim();
                ComboItem selectedDrink = drinksMap.get(drinkChoice);

                if (selectedDrink != null) {
                    validDrinkChosen = true;
                    System.out.println("You selected " + selectedDrink.getName());
                    //Call the selected drink from ComboItem class in displayDetails method
                    selectedDrink.displayDetails();
                    System.out.println("Oh you made the right choice!");

                    System.out.println("Would you like to order this drink?(yes/no): ");
                    String orderDrink = scanner.nextLine();
                    if (orderDrink.equalsIgnoreCase("yes")) {
                        System.out.println(orderDrink + " is being added to your cart.");
                    } else if (orderDrink.equalsIgnoreCase("no")) {
                        order.addCombo()
                        System.out.println("Returning to Home Screen");
                    }

                } else {
                    System.out.println("That item isn't on on our menu yet - try again");
                }

            }

            boolean validChipsChosen = false;
            while (!validChipsChosen) {
                for (String chipsCombo : chipsMap.keySet()) {
                    System.out.println("-" + chipsCombo);
                }
                System.out.println("Enter your chips name: ");
                String chipChoice = scanner.nextLine().trim();
                ComboItem selectedChips = chipsMap.get(chipChoice);

                if (selectedChips != null) {
                    validChipsChosen = true;
                    System.out.println("You selected " + selectedChips.getName());
                    //Call the selected chips from ComboItem class in displayDetails method
                    selectedChips.displayDetails();
                    System.out.println("Oh you made the right choice!");

                    System.out.println("Would you like to order these chips?(yes/no): ");
                    String orderChips = scanner.nextLine();
                    if (orderChips.equalsIgnoreCase("yes")) {
                        System.out.println(orderChips + " is being added to your cart.");
                        order.setSelectedChips(selectedChips);
                    } else if (orderChips.equalsIgnoreCase("no")) {
                        System.out.println("Returning to Home Screen");
                    }

                } else {
                    System.out.println("That item isn't on on our menu yet - try again");
                }
            }


        }
    }

    public void getChips() {
        System.out.println("----Divine Deli Menu----");
        //Map.Entry<k,v> represents one key-value pair in a map
        for (Map.Entry<String, ComboItem> chipsEntry : chipsMap.entrySet()) {//This is to access both the key and value in the hash map

            ComboItem chips = chipsEntry.getValue();
            System.out.println("Chips Name: " + chips.getName());
            System.out.println("Description: " + chips.getDescription());
            System.out.println("Nutrition Facts: " + chips.getNutritionFacts());

            System.out.println("-------------------------------------");
        }


    }

    public static void setChipsMap() {
        chipsMap = new HashMap<>();
        chipsMap.put("Truffle Oil", new ComboItem("Kettle Chips", "Potatoes, Truffle Oil, Sea salt, Citric Acid", """
                Mood Level: Elevated
                Crunch Rating: 10/10
                Infused with: Main character energy
                Pairs well with: Knowing your worth & soft jazz
                """, "Chips"));
        chipsMap.put("Chile Lime Chips", new ComboItem("Siete", "Potatoes, avocado oil, red chile powder, citric acid, sea salt, ground dates, paprika, lime powder", """
                Mood Level: Spicy & Spontaneous
                Crunch Rating: 9/10
                Infused with: Bold decisions and tiny dance breaks
                Pairs well with: Risky texts and late-night playlists
                """, "chips"));

        chipsMap.put("Sea Salt & Pepper", new ComboItem("Kettle Chips", "Potatoes, Avocado Oil,Sea Salt,Pepper", """
                Mood Level: Grounded & Grown
                Crunch Rating: 8.5/10
                Infused with: Quiet confidence and subtle shade
                Pairs well with: Deep convos and a Lavender Lemonade
                """, "Chips"));

        chipsMap.put("Sea Salt & Vinegar", new ComboItem("Kettle Chips", "Potatoes, Sea Salt, Vinegar Powder, Citric Acid", """
                Mood Level: Dramatic with a hint of mystery
                Crunch Rating: 11/10
                Infused with: Emotional clarity and zero sugar-coating
                Pairs well with: Journaling breakthroughs & unapologetic playlist loops
                """, "Chips"));





    }
    public static void setDrinksMap () {
        drinksMap = new HashMap<>();
        drinksMap.put("Lavender Lemonade", new ComboItem("Still Blooming", "Organic lemon juice, raw honey, and dried culinary lavender", "Soothing", "drink"));

        drinksMap.put("Mood Boost Berry Elixir", new ComboItem("Joy Juice", "Cold-pressed strawberries, blueberries, coconut water, and basil.", "Joyful, Lighthearted", "drink"));

        drinksMap.put("Green Juice", new ComboItem("Green Goddess Tonic", "Kale, cucumber, apple, lemon, and spirulina.", "Balanced, Nourished", "drink"));

        drinksMap.put("Hot Latte", new ComboItem("Golden Soul Latte", "Oat milk, turmeric, ginger, cinnamon, and black pepper, sweetened with dates.", "Comforting, Rooted", "drink"));

    }
}
