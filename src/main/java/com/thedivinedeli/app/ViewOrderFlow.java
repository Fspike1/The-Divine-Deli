package com.thedivinedeli.app;

import java.util.*;

public class ViewOrderFlow {
    public static void start(Scanner scanner, Order order) {
        List<Sandwich> sandwichInCart = order.getSandwiches();

        if (sandwichInCart.isEmpty() && !order.isHasCombo()) {
            System.out.println("Your cart is currently empty.");
            return;
        }

        System.out.println("\n--- Current Order Summary ---");

        // Show combo if it exists
        if (order.isHasCombo() && order.getComboSandwich() != null) {
            System.out.println("\n--- Combo Meal ---");
            Sandwich s = order.getComboSandwich();
            System.out.println(s);
            List<String> chipList = order.getChipsList();
            List<String> drinkList = order.getDrinksList();
            if (!chipList.isEmpty()) {
                System.out.println("Chips: " + chipList.getLast());
            }
            if (!drinkList.isEmpty()) {
                System.out.println("Drink: " + drinkList.getLast());
            }
            System.out.println("Combo Price: $8.88");
        }

        // Show regular sandwiches if any
        if (!sandwichInCart.isEmpty()) {
            System.out.println("\n--- Regular Sandwiches ---");
            for (int i = 0; i < sandwichInCart.size(); i++) {
                System.out.println((i + 1) + ") " + sandwichInCart.get(i));
            }
        }

        // Price breakdown
        double regularTotal = sandwichInCart.stream()
                .mapToDouble(Sandwich::sandwichPrice)
                .sum();
        double comboTotal = order.getTotalComboPrice();
        double grandTotal = order.getOrderTotal();

        System.out.println("\n--- Price Breakdown ---");
        System.out.println("Regular Sandwiches Total: $" + String.format("%.2f", regularTotal));
        if (comboTotal > 0) {
            System.out.println("Combo Meals Total: $" + String.format("%.2f", comboTotal));
        }
        System.out.println("Grand Total: $" + String.format("%.2f", grandTotal));
        System.out.println("--------------------------------------------");

        System.out.println("Press Enter to return to the Home Screen...");
        scanner.nextLine();
    }

}

