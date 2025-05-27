package com.thedivinedeli.app;

public class Drinks extends ComboItem {
    private String mood;
    public Drinks(String name, String description, String mood, String nutritionFacts){
        super(name, description, nutritionFacts);
        this.mood = mood;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Mood Boost: " + mood);
    }
}
