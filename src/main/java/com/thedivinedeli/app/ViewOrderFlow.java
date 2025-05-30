package com.thedivinedeli.app;

import java.util.*;

import static com.thedivinedeli.app.Main.slowPrint;

public class ViewOrderFlow {
    public static void start(Scanner scanner, Order order) {

        List<Sandwich> sandwichInCart = order.getSandwiches();

        System.out.println("\n🧾✨ YOUR DIVINE ORDER ✨🧾");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        if (sandwichInCart.isEmpty() && !order.isHasCombo()) {
            slowPrint("Your cart is feeling a little... empty 😢", 40);
            System.out.println("Maybe it's waiting for the perfect sandwich to match your vibe.");            return;
        }

        System.out.println("\n--- Current Order Summary ---");

        // Show combo if it exists
        List<Sandwich> comboList = order.getComboSandwiches();
        List<String> chipList = order.getChipsList();
        List<String> drinkList = order.getDrinksList();

        if (order.isHasCombo() && !comboList.isEmpty()) {
            System.out.println("\n🥤✨ COMBO MEALS ✨🥤");
            for (int i = 0; i < comboList.size(); i++) {
                Sandwich s = comboList.get(i);
                System.out.println((i + 1) + ") " + s);

                if (i < chipList.size()) {
                    System.out.println("Chips: " + chipList.get(i));
                }
                if (i < drinkList.size()) {
                    System.out.println("   🥤 Drink: " + drinkList.get(i));
                }

                double price = s.isMoodBased() ? 8.88 : s.sandwichPrice() + 1.11;
                System.out.println("   💵 Combo Price: $" + String.format("%.2f", price));
                System.out.println("-----------------------------------");
            }
        }


        System.out.println("--- Regular Sandwiches ---");
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

        System.out.println("\n💸 PRICE BREAKDOWN 💸");
        System.out.println("📦 Regular Sandwiches Total: $" + String.format("%.2f", regularTotal));
        if (comboTotal > 0) {
            System.out.println("🍟 Combo Meals Total: $" + String.format("%.2f", comboTotal));
        }
        System.out.println("\uD83E\uDDFE Grand Total: $" + String.format("%.2f", grandTotal));


        System.out.println("\nWould you like to confirm and place your order? (yes/no)");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("\n🌟 Order Confirmed! Your food is being prepared with love. 🌟");
            System.out.println("Thank you for ordering from The Divine Deli!");
            System.out.println("\n📜✨ FULL RECEIPT ✨📜\n");
            System.out.println(order.printReceipt());
            order.getSandwiches().clear();
            order.getComboSandwiches().clear();
            order.getChipsList().clear();
            order.getDrinksList().clear();

            // Optional: reset customer name and timestamp if needed
        } else {
            System.out.println("No problem! You can make changes or continue browsing.");
        }
        System.out.println("Returning to the Main Menu...");
        scanner.nextLine();
    }

}

