package com.thedivinedeli.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivineDeliMenu {
    Scanner scanner = new Scanner(System.in);
    private Map<String, Sandwich> moodMenu = new HashMap<>();

    public Map<String, Sandwich> getMoodMenu() {
        return moodMenu;
    }

    public void printMoodMenu() {
        System.out.println("----Divine Deli Menu----");
        //Map.Entry<k,v> represents one key-value pair in a map
        for (Map.Entry<String, Sandwich> entry : moodMenu.entrySet()) {//This is to access both the key and value in the hash map

            Sandwich s = entry.getValue();
            System.out.println("Mood: " + entry.getKey());
            System.out.println("Sandwich Name: " + s.getSandwichName());
            System.out.println("Description: " + s.getSandwichDescription());
            System.out.println("Bread: " + s.getTypeOfBread());
            System.out.println("Meat: " + s.getTypeOfMeat());
            System.out.println("Cheese: " + s.getTypeOfCheese());
            System.out.println("Veggies: " + s.getTypeOfVeggies());
            System.out.println("Condiments: " + s.getCondiments());
            System.out.println("Size: 6in, 8in, or 12in");
            System.out.println("-------------------------------------");

        }
    }

    public DivineDeliMenu() {

        moodMenu.put("Happy".toUpperCase(), new Sandwich("The Sunshine Stack", "Bright, golden, and unapologetically feel-good", "Honey Oat", "Sharp White Cheddar", "Oven Roasted Lemon Herb Chicken", "Lettuce, tomato, cucumber, banana peppers", "user choice", "user choice", "user choice", "Honey Mustard"));
        moodMenu.put("Heartbroken".toUpperCase(), new Sandwich("The Blanket Bite", "Comfort that tastes like a hug", "Butter Croissant", "Smoked Provolone", "Pulled Pork", "Carmalized Onion", "user's choice", "user choice", " ", "Apple Butter, Chipotle Mayo"));
        moodMenu.put("Upset".toUpperCase(), new Sandwich(" The FireStarter Wrap", "Bold, spicy, and cathartic - For eating your feelings", "Tomato Basil Tortilla", "Fiery jalapeno Cheddar", "Spicy grilled chicken", "Jalapenos, Red Onion, pickles", "user's Choice", " ", " ", "Sriracha + Ranch"));
        moodMenu.put("Lonely".toUpperCase(), new Sandwich("The Cuddle Melt", "Sweet & savory with a cozy twist", "Cinnamon Swirl Toast", "Fontina", "Honey Glazed Ham", "Apple Slices", "User's Choice", " ", " ", "Maple dressing"));
        moodMenu.put("Overwhelmed".toUpperCase(), new Sandwich("The Calm Down Crunch", "Simple, grounding, warm and minimal- nothing extra", "Soft Sourdough", "Muenster", "Roast Chicken", "None", "User Choice", " ", " ", "Garlic and Herb Aioli"));
        moodMenu.put("Detached".toUpperCase(), new Sandwich("The IceBreaker", "Cold, sharp bold flavors to snap you back to reality", "Cold ciabatta", "Blue cheese", "Roast beef", "Pickled Red Onion + Arugala", "User Choice", " ", " ", "Horseradish dressing"));
        moodMenu.put("Hopeful".toUpperCase(), new Sandwich("The Bloom Bite", "Light, green, vibrant, fresh- like planting a seed", "Seeded Rye", "Goat Cheese", "Lemon dill Salmon", "Sprouts, Cucumber, Avocado", "User choice", " ", " ", "Tzatziki"));
        moodMenu.put("Exhausted".toUpperCase(), new Sandwich("The Power Nap Press", "Toasted, rich, sweet, savory - a shot of energy in a warm hug", "Toasted Honey Glazed Sourdough", "Smoked Gouda", "Maple-pepper Bacon", "Roasted Sweet potato, baby Spinach", "User Choice", " ", " ", "Citrus-Maple aioli"));
        moodMenu.put("Wasted".toUpperCase(), new Sandwich("The Gremlin Gobbler", "Greasy, crunchy, sweet and chaotic — everything you shouldn't crave but absolutely do", "Garlic butter Pretzel Bun", "Nacho cheese blend", "Fried Chicken, Crispy Bacon", "Pickles, Caramelized Onion", "User Choice", " ", " ", "Spicy ketchup, ranch drizzle"));


    }

    public Sandwich buildCustomSandwich(Sandwich scanner) {

        System.out.println("What would you like on your sandwich?");
        return new Sandwich("Divine Deli Signature", "For when the mood can't be named but your craving can", "Roasted Garlic Focaccia", "Whipped Goat Cheese & shredded smoked gouda", "Brown sugar glazed roast beef", "Roasted red peppers, baby arugula,crispy shallots", "user choice", " ", " ", "Black Garlic Aioli");

    }

    public Sandwich sandwichSuggestion(String userMood, Scanner scanner) {

        Sandwich result = moodMenu.get(userMood.toUpperCase());

        if (result != null) {
            return result;
        }
        System.out.println("We don't have a sandwich for your current mood.");
        System.out.println("""
                Would you like to:
                1. create a mood-based sandwich and put it on the menu
                2. Select a mood from the list of divine deli moods list""");
        System.out.println("Select 1 or 2: ");
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
                    - Happy
                    - Detached
                    - Heartbroken
                    - Exhausted
                    - Wasted
                    - Overwhelmed
                    - Hopeful
                    - Lonely
                    - Upset""");
            userChoice = scanner.nextLine();

            suggestedResult = moodMenu.get(userChoice.toUpperCase());

            if (suggestedResult.equals(moodMenu.get(userChoice.toUpperCase()))) {
                return suggestedResult;
            } else
                return new Sandwich("Divine Deli Signature", "For when the mood can't be named but your craving can", "Roasted Garlic Focaccia", "Whipped Goat Cheese & shredded smoked gouda", "Brown sugar glazed roast beef", "Roasted red peppers, baby arugula,crispy shallots", "user choice", " ", " ", "Black Garlic Aioli");
        }
        return suggestedResult;
    }
    }
