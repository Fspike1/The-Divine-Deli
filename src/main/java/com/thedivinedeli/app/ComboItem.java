package com.thedivinedeli.app;


// This is the parent class. It's the shared base for things like Drink and Chip.
public class ComboItem {
    //Traits that all combo items share
    private String name;
    private String description;
    private String type;//drinks



    public String getType() {
        return type;
    }

    private String nutritionFacts;// or chips

    public String getNutritionFacts() {
        return nutritionFacts;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    //Constructor that sets up shared fields
    public ComboItem( String name, String description, String nutritionFacts,String type){
        this.name = name;
        this.description = description;
        this.nutritionFacts = nutritionFacts;
        this.type = type;

    }

    //This is meant to be shared
    //This is the original method that should be shared between the child classes
    public void displayDetails() {
        System.out.println("Brand: " + name);
        System.out.println("Description: " + description);
        System.out.println("Nutrition Facts: " + nutritionFacts);
        System.out.println("Type: " + type);
    }

    @Override
    public String toString() {
        return "Brand: " + name +
                "Description: " + description + "\n" +
                "Nutrition Facts: " + nutritionFacts + "\n" +
                "Type: " + type + "\n";
    }
}
