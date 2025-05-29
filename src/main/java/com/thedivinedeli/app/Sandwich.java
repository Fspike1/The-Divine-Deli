package com.thedivinedeli.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich implements BuildableSandwich {
    Scanner scanner = new Scanner(System.in);

    private String sandwichName;
    private String sandwichDescription;
    private String typeOfBread;
    private String typeOfMeat;
    private String typeOfVeggies;
    private String condiments;
    private String typeOfCheese;
    private String size;
    private String extraCheese;
    private boolean comboIncluded;

    public double getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(double comboPrice) {
        this.comboPrice = comboPrice;
    }

    public boolean isComboIncluded() {
        return comboIncluded;
    }

    public void setComboIncluded(boolean comboIncluded) {
        this.comboIncluded = comboIncluded;
    }

    private double comboPrice;


    public String getExtraMeat() {
        return extraMeat;
    }

    public String getExtraCheese() {
        return extraCheese;
    }

    private String extraMeat;

    public String getSandwichDescription() {
        return sandwichDescription;
    }

    public void setSandwichDescription(String sandwichDescription) {
        this.sandwichDescription = sandwichDescription;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(String typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public String getTypeOfMeat() {
        return typeOfMeat;
    }

    public void setTypeOfMeat(String typeOfMeat) {
        this.typeOfMeat = typeOfMeat;
    }

    public String getTypeOfVeggies() {
        return typeOfVeggies;
    }

    public void setTypeOfVeggies(String typeOfVeggies) {
        this.typeOfVeggies = typeOfVeggies;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(String typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String ExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(String extraCheese) {
        this.extraCheese = extraCheese;
    }

    public String ExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(String extraMeat) {
        this.extraMeat = extraMeat;
    }

    //For ordering a mood based sandwich or a sandwich off the menu
    public Sandwich(String sandwichName, String sandwichDescription, String typeOfBread, String typeOfMeat, String typeOfVeggies, String condiments, String typeOfCheese, String size, String extraCheese, String extraMeat) {

        this.sandwichName = sandwichName;
        this.sandwichDescription = sandwichDescription;
        this.typeOfBread = typeOfBread;
        this.typeOfCheese = typeOfCheese;
        this.typeOfMeat = typeOfMeat;
        this.typeOfVeggies = typeOfVeggies;
        this.size = size;
        this.condiments = condiments;
        this.extraCheese = "Yes".equalsIgnoreCase(extraCheese) ? "Yes" : "No";
        this.extraMeat = "Yes".equalsIgnoreCase(extraMeat) ? "Yes" : "No";


    }

    //For creating a custom sandwich
    public Sandwich() {

    }

    public double sandwichPrice() {
        double basePrice = 0.0;
        if (!(size.equals("6in") || size.equals("8in") || size.equals("12in"))) {
            System.out.println("That is not a valid size. Please select 6in, 8in, or 12in.");
            return basePrice;
        }
        basePrice = switch (size) {//the -> in switch just means return this value(easier to read than :)
            // NOT a lambda expression because it doesn't create a function
            case "6in" -> 5.55;
            case "8in" -> 7.77;
            case "12in" -> 9.99;
            default -> 0.0;
        };//closes the expression and acts like the end of return
        if ("Yes".equalsIgnoreCase(extraMeat)) {
            basePrice += .50;
        }
        if ("Yes".equalsIgnoreCase(extraCheese)) {
            basePrice += .30;
        }
        if (comboIncluded) {
            basePrice += comboPrice;
        }


        return basePrice;

    }

    @Override
    public String toString() {
        return "Sandwich" +
                "\n Sandwich Name: " + sandwichName +
                "\n Description: " + sandwichDescription +
                "\n Bread: " + typeOfBread +
                "\n Meat: " + typeOfMeat +
                "\n Veggies: " + typeOfVeggies +
                "\n Condiments: " + condiments +
                "\n Cheese: " + typeOfCheese +
                "\n Size: " + size +
                "\n Total Price: " + String.format("%.2f", sandwichPrice()) +
                "\n Extra Cheese: " + extraCheese +
                "\n Extra Meat: " + extraMeat;

    }


    @Override
    public void customize(Scanner scanner) {

        //List of valid bread options
        List<String> breadOptions = new ArrayList<>(List.of(
                "Honey Oat",
                "Butter Croissant",
                "Tomato Basil Tortilla",
                "Cinnamon Swirl Toast",
                "Sourdough",
                "Honey Glazed Sourdough",
                "Ciabatta",
                "Seeded Rye",
                "Garlic Butter Pretzel Bun",
                "Roasted Garlic Focaccia"));

        String breadChoice = getValidInput(scanner, breadOptions, "What kind of bread would you like?");
        this.setTypeOfBread(breadChoice);


        List<String> cheeseOptions = new ArrayList<>(List.of(
                "Sharp White Cheddar",
                "Smoked Provolone",
                "Fiery Jalapeno Cheddar",
                "Fontina",
                "Muenster",
                "Blue Cheese",
                "Goat Cheese",
                "Shredded Smoked Gouda",
                "Nacho Cheese Blend",
                "Whipped Goat Cheese",
                "None"));

        String cheeseChoice = getValidInput(scanner, cheeseOptions, "What kind of cheese would you like? ");
        this.setTypeOfCheese(cheeseChoice);


        List<String> meatOptions = new ArrayList<>(List.of(
                "Oven Roasted Lemon Herb Chicken",
                "Pulled Pork",
                "Spicy Grilled Chicken",
                "Roast Beef",
                "Lemon Dill Salmon",
                "Maple-Pepper Bacon",
                "Fried Chicken",
                "Crispy Bacon",
                "Brown Sugar Glazed Roast Beef",
                "None"));

        String meatChoice = getValidInput(scanner, meatOptions, "What type of meat would you like?");
        this.setTypeOfMeat(meatChoice);



        List<String> veggieOptions = new ArrayList<>(List.of("Lettuce",
                "Arugula",
                "Spinach",
                "Sprouts",
                "Apple Slices",
                "Avocado",
                "Tomato",
                "Cucumber",
                "Pickles",
                "Banana Peppers",
                "Jalapenos",
                "Caramelized Onion",
                "Red Onion",
                "Pickled Red Onion",
                "Crispy Shallots",
                "Roasted Red Peppers",
                "None"));

        while (true) {
            System.out.println("What kind of veggies would you like?");
            System.out.println("(You can list multiple, separated by commas)");

            // Show options to the user
            for (String option : veggieOptions) {
                System.out.println("- " + option);
            }

            // Read user input (e.g., "lettuce, tomato, pickles")
            String input = scanner.nextLine();
            String[] parts = input.split(",");


            //chosenVeggies → will store the user’s final valid choices.
            //allValid: a flag we’ll set to false if any input is bad.
            List<String> chosenVeggies = new ArrayList<>();
            boolean allValid = true;

            for (String part : parts) { //one chunk from the split array ("lettuce")
                String trimmed = part.trim();

                // Check if input matches a valid option (case-insensitive)
                boolean isValid = veggieOptions.stream()//This means look through every option in the veggie option list
                        //.anyMatch means is there any item that matches what's in the list?
                        //opt -> is a lambda: For each opt (option) in the list, check if it's equal to trimmed (user input), ignoring upper/lowercase.
                        .anyMatch(opt -> opt.equalsIgnoreCase(trimmed));

                if (isValid) {
                    // Keep the original casing from options list
                    for (String valid : veggieOptions) {
                        if (valid.equalsIgnoreCase(trimmed)) {
                            chosenVeggies.add(valid);
                            break;
                        }
                    }
                } else {
                    System.out.println("'" + trimmed + "' is not a valid veggie option.");
                    allValid = false;
                    break;
                }
            }

            if (allValid) {
                // Join the list into a single string: "Lettuce, Tomato, Pickles"
                String finalVeggieString = String.join(", ", chosenVeggies);
                this.setTypeOfVeggies(finalVeggieString);
                break; // exit loop
            } else {
                System.out.println("Please try entering the veggies again.");
            }
        }





        List<String> condimentOptions = new ArrayList<>(List.of("Ketchup",
                "Spicy Ketchup",
                "BBQ Sauce",
                "Honey Mustard",
                "Apple Butter",
                "Tzatziki",
                "Chipotle Mayo",
                "Sriracha",
                "Ranch Dressing",
                "Maple Dressing",
                "Horseradish Dressing",
                "Citrus-Maple Aioli",
                "Garlic and Herb Aioli",
                "Black Garlic Aioli",
                "None"));

        while (true) {
            System.out.println("What kind of condiments would you like?");
            System.out.println("(You can list multiple, separated by commas)");

            // Show options to the user
            for (String option : condimentOptions) {
                System.out.println("- " + option);
            }

            String input = scanner.nextLine();
            String[] parts = input.split(",");


            //chosenVeggies → will store the user’s final valid choices.
            //allValid: a flag we’ll set to false if any input is bad.
            List<String> chosenCondiments = new ArrayList<>();
            boolean allValid = true;

            for (String part : parts) { //one chunk from the split array ("ketchup")
                String trimmed = part.trim();

                // Check if input matches a valid option (case-insensitive)
                boolean isValid = condimentOptions.stream()//This means look through every option in the condiment option list
                        //.anyMatch means is there any item that matches what's in the list?
                        //opt -> is a lambda: For each opt (option) in the list, check if it's equal to trimmed (user input), ignoring upper/lowercase.
                        .anyMatch(opt -> opt.equalsIgnoreCase(trimmed));

                if (isValid) {
                    // Keep the original casing from options list
                    for (String valid : condimentOptions) {
                        if (valid.equalsIgnoreCase(trimmed)) {
                            chosenCondiments.add(valid);
                            break;
                        }
                    }
                } else {
                    System.out.println("'" + trimmed + "' is not a valid condiment.");
                    allValid = false;
                    break;
                }
            }

            if (allValid) {

                String finalCondimentString = String.join(", ", chosenCondiments);
                this.setCondiments(finalCondimentString);
                break; // exit loop
            } else {
                System.out.println("Please try entering the condiments again.");
            }
        }






        System.out.println("Would you like any extra meat or cheese? (yes/no) ");
        String extrasChoice = scanner.nextLine();
        if (extrasChoice.equalsIgnoreCase("yes")) {
            System.out.println("Select one extra meat");
            List<String> extraOptions = new ArrayList<>(List.of("Oven Roasted Lemon Herb Chicken",
                    "Pulled Pork",
                    "Spicy Grilled Chicken",
                    "Roast Beef",
                    "Lemon Dill Salmon",
                    "Maple Pepper Bacon",
                    "Fried Chicken",
                    "Crispy Bacon",
                    "Brown Sugar Glazed Roast Beef",
                    "None"));

            String extraMeatChoice = getValidInput(scanner, extraOptions, "Select one extra meat");
            this.setExtraMeat(extraMeatChoice);

            List<String> extraCheeseOptions = new ArrayList<>(List.of("Sharp White Cheddar",
                    "Smoked Provolone",
                    "Fiery Jalapeno Cheddar",
                    "Fontina",
                    "Muenster",
                    "Blue Cheese",
                    "Goat Cheese",
                    "Shredded Smoked Gouda",
                    "Nacho Cheese Blend",
                    "Whipped Goat Cheese",
                    "None"));

            String extraCheeseChoice = getValidInput(scanner, extraCheeseOptions, "Select one extra cheese");
            this.setExtraCheese(extraCheeseChoice);
        }

        List<String> sizeOptions = new ArrayList<>(List.of("6in",
                "8in",
                "12in"));

        String sizeChoice = getValidInput(scanner, sizeOptions, "Select your size (6in, 8in, or 12in): ");
        this.setSize(sizeChoice);
    }

    // This method asks the user for input and only accepts valid options
    private String getValidInput(Scanner scanner, List<String> validOptions, String prompt) {//I can write this once right here and use it everywhere else
        while (true) {
            //show user what they should input
            System.out.println(prompt);//String prompt created in constructor

            //print all valid options
            for (String option : validOptions) {
                System.out.println("- " + option);
            }
            //read user input
            String userInput = scanner.nextLine().trim();

              // Check if the input matches any of the valid options (case-insensitive)
            for (String option : validOptions) {
                if (option.equalsIgnoreCase(userInput)) {
                    return option;//returns valid input
                }
            }
            System.out.println("That's not a valid option please try again");


        }

    }

}
