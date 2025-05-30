package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ComboFlow {
    private static Map<String, ComboItem> chipsMap;

    public static Map<String, ComboItem> getDrinksMap() {
        return drinksMap;
    }

    public static Map<String, ComboItem> getChipsMap() {
        return chipsMap;
    }

    private static Map<String, ComboItem> drinksMap;


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
    public static void start(Scanner scanner, Order order) {

        DivineDeliMenu matcher = null;

        System.out.println("\nWelcome to the Divine Deli: Mood Combo Sanctuary");
        System.out.println("How are you feeling today?");
        String userMood = scanner.nextLine();
        System.out.println("Oh your mood is "+ userMood + "? I have the perfect combo for you! ");
        System.out.println("What size would you like? (6in, 8in, or 12in):");
        String size1 = scanner.nextLine();


        System.out.println("Select from the following Moods or create your own");
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

        Sandwich mySandwich1 = matcher.sandwichSuggestion(userMood, scanner);

        while (!size1.equals("6in") && !size1.equals("8in") && !size1.equals("12in")) {
            System.out.println("That is not a valid size. Please select 6in, 8in, or 12in.");
            size1 = scanner.nextLine();
        }
        mySandwich1.setSize(size1);

        System.out.println("Your suggested sandwich is: " + mySandwich1);
        System.out.println("PLEASE NOTE: This is the sandwich's standalone price. Your full combo is angelically locked in at $8.88 — no matter the size");


        System.out.println("Would you like to continue with this combo? (yes/no): ");
        String output = scanner.nextLine();
        if (output.equalsIgnoreCase("yes")) {
            System.out.println("Thanks for trusting us. We won't let you down. Let's get your chips and drink as well!");
        } else if (output.equalsIgnoreCase("no")) {
            System.out.println("No problem, returning to Home Screen");
            return;
        }

        System.out.println("What chips  would like to add?");
        for (String chips : chipsMap.keySet()) {
            System.out.println("-" + chips);
        }
        String chipsForCombo = scanner.nextLine();

        System.out.println("Was this an accident or do you just have great taste? (Accident/Great Taste)");
        String chipsForCombo1 = scanner.nextLine();
        if (chipsForCombo1.equalsIgnoreCase("Accident")) {
            System.out.println("We all make mistakes. Don't let this one ruin a good thing. Select the chips you want");
            String reselectedChips = scanner.nextLine();
            order.addChips(reselectedChips);
        } else if (chipsForCombo1.equalsIgnoreCase("Great Taste")) {
            System.out.println("I see you standing on business! Adding the perfect chips for your combo.");
            order.addChips(chipsForCombo);
        }

        System.out.println("What drink would you like to add?");
        for (String drink : drinksMap.keySet()) {
            System.out.println("-" + drink);
        }
        String drinkForCombo = scanner.nextLine();

        System.out.println("Was this an accident or do you just have great taste? (Accident/Great Taste)");
        String drinkForCombo1 = scanner.nextLine();
        if (drinkForCombo1.equalsIgnoreCase("Accident")) {
            System.out.println("We all make mistakes. Don't let this one ruin a good thing. Select the drink you want");
            String reselectedDrink = scanner.nextLine();
            order.addDrink(reselectedDrink);

        } else if (drinkForCombo1.equalsIgnoreCase("Great Taste")) {
            System.out.println("Oh, you don't miss! Adding the perfect drink for your combo.");
            order.addDrink(drinkForCombo);
        }

        System.out.println("Would you like to add this combo to the cart? (yes/no)");
        String comboDecision = scanner.nextLine();

        if (comboDecision.equalsIgnoreCase("yes")) {
            System.out.println("Adding your combo to the cart");
            order.addCombo(mySandwich1, chipsForCombo, drinkForCombo);
        } else if (comboDecision.equalsIgnoreCase("No")) {
            System.out.println("No Problem. Returning to Home Screen");
            return;
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


}
