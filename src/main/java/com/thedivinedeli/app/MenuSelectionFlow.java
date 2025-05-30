package com.thedivinedeli.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuSelectionFlow {

    public static void start(Scanner scanner, Order order) {
        DivineDeliMenu menu = new DivineDeliMenu();
        Map<String, Sandwich> moodMap = menu.getMoodMenu();
        System.out.println("Here is the full menu");
        menu.printMoodMenu();
        System.out.println("Would you like to order one of these sandwiches?");
        System.out.println("Select a mood from the menu or enter X to return to Home Screen");
        String moodChoice = scanner.nextLine().toUpperCase();

        if(moodMap.containsKey(moodChoice)){
            Sandwich s = moodMap.get(moodChoice);
            System.out.println("You picked: " + s.getSandwichName());
            order.addSandwiches(s);
        }
        else if (moodChoice.equalsIgnoreCase("X")) {
            System.out.println("Returning you to the Home Screen");
        }
        else {
            System.out.println("Please input a valid mood or enter X to return to the Home Screen.");
        }



    }

    }
