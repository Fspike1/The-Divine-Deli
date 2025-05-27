package com.thedivinedeli.app;


// This is the parent class. It's the shared base for things like Drink and Chip.
public abstract class ComboItem {
    //Traits that all combo items share
    protected String name;
    protected String description;
    protected String nutritionFacts;

    //Constructor that sets up shared fields
    public ComboItem(String name, String description, String nutritionFacts){
        this.name = name;
        this.description = description;
        this.nutritionFacts = nutritionFacts;
    }

    //This is meant to be shared
    //This is the original method that should be shared between the child classes
    public void displayDetails(){//void just shows what is printed. It doesn't return anything
        System.out.println(name + "-" + description);
        System.out.println("Nutrition Facts: " + nutritionFacts);
    }
}
