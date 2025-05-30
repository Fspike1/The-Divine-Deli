package com.thedivinedeli.app;

import java.util.List;
import java.util.Scanner;

import static com.thedivinedeli.app.Main.slowPrint;

public class RemoveSandwichFlow {
    public static void start(Scanner scanner, Order order) {
        System.out.println("\n❌🥪 REMOVE A SANDWICH ❌🥪");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        if (order.getSandwiches().isEmpty() && order.getComboSandwiches().isEmpty()) {
            slowPrint("Your cart is already clean. Nothing to remove. 🧼✨", 40);
            return;
        }
        if (!order.getComboSandwiches().isEmpty() && (!order.getSandwiches().isEmpty())) {
            slowPrint("Here’s a quick preview of your delicious decisions 👀👇", 35);
            order.printReceipt();
        }
        List<Sandwich> regulars = order.getSandwiches();//gets list of current sandwiches in cart added by customer.
        List<Sandwich> combos = order.getComboSandwiches();


        int itemNumber = 1; // //hint: Shared display index for BOTH lists

        // //hint: First show all combos
        for (int i = 0; i < combos.size(); i++) {
            Sandwich s = combos.get(i);
            String type = s.isMoodBased() ? "Mood Combo" : "Custom Combo";
            System.out.println(itemNumber + ") " + type + ": " + s.getSandwichName());
            itemNumber++;
        }

        // //hint: Then show all regular sandwiches
        for (int i = 0; i < regulars.size(); i++) {
            Sandwich s = regulars.get(i);
            System.out.println(itemNumber + ") " + "Regular: " + s.getSandwichName());
            itemNumber++;
        }

        System.out.print("\n👉 Enter the number of the sandwich you wish to remove: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // clean buffer

        int totalItems = combos.size() + regulars.size();

        // //hint: Check bounds first
        if (choice < 1 || choice > totalItems) {
            System.out.println("That number is not valid. Please try again.");
            return;
        }

        // //hint: If the index falls in the combo list range
        if (choice <= combos.size()) {
            combos.remove(choice - 1);
            // //hint: Also remove matching drink/chips
            order.getDrinksList().remove(choice - 1);
            order.getChipsList().remove(choice - 1);
            System.out.println("\uD83E\uDDC3 Combo #" + choice + " was removed.");
        } else {
            // //hint: Offset index by number of combos
            int regularIndex = choice - combos.size() - 1;
            regulars.remove(regularIndex);
            System.out.println("Sandwich #" + choice + " was removed.");
        }
    }
}