package com.thedivinedeli.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.thedivinedeli.app.Main.slowPrint;

public class DivineDeliMenu {
    Scanner scanner = new Scanner(System.in);
    private Map<String, Sandwich> moodMenu = new HashMap<>();

    public Map<String, Sandwich> getMoodMenu() {
        return moodMenu;
    }

    public void printMoodMenu() {
            System.out.println("\n📜✨ THE DIVINE DELI MENU ✨📜");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            slowPrint("Each sandwich was crafted for a specific vibe.", 40);
            slowPrint("Explore the flavors your emotions deserve... 😌🥪", 40);
            System.out.println();

            for (Map.Entry<String, Sandwich> entry : moodMenu.entrySet()) {
                Sandwich s = entry.getValue();

                System.out.println("🌈 Mood: " + entry.getKey());
                System.out.println("🥪 Name: " + s.getSandwichName());
                System.out.println("📝 Description: " + s.getSandwichDescription());
                System.out.println("🍞 Bread: " + s.getTypeOfBread());
                System.out.println("🍖 Meat: " + s.getTypeOfMeat());
                System.out.println("🧀 Cheese: " + s.getTypeOfCheese());
                System.out.println("🥬 Veggies: " + s.getTypeOfVeggies());
                System.out.println("🧴 Condiments: " + s.getCondiments());
                System.out.println("📏 Size Options: 6in, 8in, or 12in");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
            }

            System.out.println("✨ Don't forget to make it a special combo for angelic pricing at $8.88 ✨");
            System.out.println("Press Enter to return to the main menu...");
            scanner.nextLine();
        }
        //Map.Entry<k,v> represents one key-value pair in a map

    public DivineDeliMenu() {

        moodMenu.put("Happy".toUpperCase(), new Sandwich("The Sunshine Stack", "Bright, golden, and unapologetically feel-good", "Honey Oat", "Oven Roasted Lemon Herb Chicken", "Lettuce, tomato, cucumber, banana peppers", "Honey Mustard","Sharp White Cheddar", null, null));
        moodMenu.put("Heartbroken".toUpperCase(), new Sandwich("The Blanket Bite", "Comfort that tastes like a hug", "Butter Croissant", "Pulled Pork", "Carmalized Onion", "Apple Butter, Chipotle Mayo","Smoked Provolone" , null, null));
        moodMenu.put("Upset".toUpperCase(), new Sandwich(" The FireStarter Wrap", "Bold, spicy, and cathartic - For eating your feelings", "Tomato Basil Tortilla", "Spicy grilled chicken", "Jalapenos, Red Onion, pickles", "Sriracha + Ranch","Fiery Jalapeno Cheddar" ,null,null));
        moodMenu.put("Lonely".toUpperCase(), new Sandwich("The Cuddle Melt", "Sweet & savory with a cozy twist", "Cinnamon Swirl Toast", "Honey Glazed Ham", "Apple Slices", "Maple dressing","Fontina" , null, null));
        moodMenu.put("Overwhelmed".toUpperCase(), new Sandwich("The Calm Down Crunch", "Simple, grounding, warm and minimal- nothing extra", "Soft Sourdough", "Roast Chicken", "None", "Garlic and Herb Aioli","Muenster" , null, null));
        moodMenu.put("Detached".toUpperCase(), new Sandwich("The IceBreaker", "Cold, sharp bold flavors to snap you back to reality", "Cold ciabatta", "Roast beef", "Pickled Red Onion + Arugala", "Horseradish dressing", "Blue Cheese", null, null));
        moodMenu.put("Hopeful".toUpperCase(), new Sandwich("The Bloom Bite", "Light, green, vibrant, fresh- like planting a seed", "Seeded Rye", "Lemon dill Salmon", "Sprouts, Cucumber, Avocado", "Tzatziki", "Goat Cheese", null, null));
        moodMenu.put("Exhausted".toUpperCase(), new Sandwich("The Power Nap Press", "Toasted, rich, sweet, savory - a shot of energy in a warm hug", "Toasted Honey Glazed Sourdough", "Maple pepper Bacon", "Roasted Sweet potato, baby Spinach", "Citrus-Maple aioli","Smoked Gouda" , null, null));
        moodMenu.put("Wasted".toUpperCase(), new Sandwich("The Gremlin Gobbler", "Greasy, crunchy, sweet and chaotic — everything you shouldn't crave but absolutely do", "Garlic butter Pretzel Bun", "Fried Chicken, Crispy Bacon", "Pickles, Caramelized Onion", "Spicy ketchup, ranch drizzle","Nacho Cheese Blend" , null, null));


    }

    public Sandwich buildCustomSandwich(Sandwich scanner) {

        System.out.println("What would you like on your sandwich?");
        return new Sandwich("Divine Deli Signature", "For when the mood can't be named but your craving can", "Roasted Garlic Focaccia", "Brown sugar glazed roast beef", "Roasted red peppers, baby arugula,crispy shallots", "Black Garlic Aioli", "Muenster",  "no", "no");

    }

    public Sandwich sandwichSuggestion(String userMood, Scanner scanner) {

        Sandwich result = prepareMenuSandwich(userMood, scanner);

        if (result != null) {
            System.out.println("What size would you like? (6in, 8in, or 12in):");
            String size = scanner.nextLine();
            while (!size.equals("6in") && !size.equals("8in") && !size.equals("12in")) {
                System.out.println("That is not a valid size. Please select 6in, 8in, or 12in.");
                size = scanner.nextLine();
            }
            result.setSize(size);

            System.out.println("Would you like extra cheese? (yes/no)");
            String extraCheese = scanner.nextLine();
            result.setExtraCheese(extraCheese);

            System.out.println("Would you like extra meat? (yes/no)");
            String extraMeat = scanner.nextLine();
            result.setExtraMeat(extraMeat);

            return result;
        }

        System.out.println("\n🤔 Hmm… I’ve never felt that mood before.");
        slowPrint("That mood isn't on the menu... *yet*. But guess what?", 40);
        slowPrint("✨ You just opened a secret portal to create something brand new. ✨", 40);

        System.out.println("\n🌈 What would you like to do?");
        System.out.println("1️)  Create a brand-new sandwich for your unique mood 💭🛠️");
        System.out.println("2️)  Select a mood from the Divine Deli’s sacred list 📜");
        System.out.print("👉 Select 1 or 2: ");
        String userChoice = scanner.nextLine();

        Sandwich customSandwich;
        String newMood = null;
        Sandwich suggestedResult = moodMenu.get(userMood.toUpperCase());
        if (userChoice.trim().equals("1")) {

            System.out.println("What mood would you like to add?");
            newMood = scanner.nextLine();

            System.out.println("What would you like to name your sandwich?");
            String newName = scanner.nextLine();
            System.out.println("Give a short description of your sandwich");
            String newDescription = scanner.nextLine();

            customSandwich = new Sandwich();
            customSandwich.setSandwichName(newName);
            customSandwich.setSandwichDescription(newDescription);
            customSandwich.customize(scanner);



            moodMenu.put(newMood.toUpperCase(), customSandwich);
            System.out.println("Your new sandwich for mood '" + newMood + "' has been added to the menu!");
            return customSandwich;

        } else if (userChoice.trim().equals("2")) {
            System.out.println("Select from the following Moods");
            System.out.println("""
        🌞 Happy         🧊 Detached
        💔 Heartbroken   💤 Exhausted
        🍷 Wasted        😵 Overwhelmed
        🌱 Hopeful       😔 Lonely
        😡 Upset""");
            userChoice = scanner.nextLine();

            suggestedResult = moodMenu.get(userChoice.toUpperCase());

            if (suggestedResult.equals(moodMenu.get(userChoice.toUpperCase()))) {
                return suggestedResult;
            } else
                return new Sandwich("Divine Deli Signature", "For when the mood can't be named but your craving can", "Roasted Garlic Focaccia", "Brown sugar glazed roast beef", "Roasted red peppers, baby arugula,crispy shallots", "Black Garlic Aioli","Muenster" , "no", "no");
        }
        return suggestedResult;
    }
    public Sandwich prepareMenuSandwich(String moodKey, Scanner scanner) {
        Sandwich base = moodMenu.get(moodKey.toUpperCase());

        if (base == null) {
            System.out.println("That mood isn't on the menu.");
            return null;
        }

        // Clone it (so we don't mess with the original)
        Sandwich customized = new Sandwich();
        customized.setSandwichName(base.getSandwichName());
        customized.setSandwichDescription(base.getSandwichDescription());
        customized.setTypeOfBread(base.getTypeOfBread());
        customized.setTypeOfMeat(base.getTypeOfMeat());
        customized.setTypeOfVeggies(base.getTypeOfVeggies());
        customized.setCondiments(base.getCondiments());
        customized.setTypeOfCheese(base.getTypeOfCheese());

        // Calculate the price after customization
        customized.sandwichPrice();

        return customized;
    }

}
