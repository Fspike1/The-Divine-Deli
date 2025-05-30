package com.thedivinedeli.app;

import java.util.Scanner;

import static com.thedivinedeli.app.Main.slowPrint;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);


    boolean displayHomeMenu(Order order) {
        System.out.println("\n\n🌈═══════════════════════════════════════════════🌈");
        System.out.println("           🍞 WELCOME TO THE DIVINE DELI 🥪");
        System.out.println("         Where your mood feeds the menu 😌💫");
        System.out.println("🌈═══════════════════════════════════════════════🌈");
        slowPrint("         💬 How are you feeling today?",50);
        slowPrint("    (Spill as much or as little as you'd like)",50);
        String userFeelings = scanner.nextLine();

        System.out.println("Thank you for sharing, I know you must be hungry! Let's get started");

        boolean displayingMenu = true;
        while (displayingMenu) {

            slowPrint("\n🌟═══════════ HOME SCREEN ═══════════🌟",50);
            slowPrint("What would you like to do today?",40);
            System.out.println("-------------------------------------");
            System.out.println("1️⃣  Start a brand new order");
            System.out.println("❌  X) Exit the deli and return to reality 😩");
            System.out.println("🌟══════════════════════════════════🌟");
            System.out.print("👉 Enter your choice (1 or X): ");
            String userChoice = scanner.nextLine();

            if (userChoice.isBlank()) {
                continue; // Skip this loop cycle and re-display the menu cleanly
            }

            switch (userChoice.toUpperCase()) {
                case "1":
                    return true;
                case "2":
                    MenuSelectionFlow.start(scanner, order);
                    System.out.println("Returning to main menu...");

                    break;
                case "X":
                    displayingMenu = false;
                    System.out.println("Thank you for stopping by!");
                    System.out.println("Exiting The Divine Deli");
                    System.out.println("----------------------------------------------------------------------");

                    return false;
                default:
                    System.out.println("That was not a valid option please select:");
                    System.out.println("----------------------------------------------------------------------");

                    break;


            }

        }
        return false;
    }
    public static void printMainMenuOptions() {
        System.out.println("\n🌟✨ MAIN MENU ✨🌟");
        System.out.println("Where every choice is a step toward emotional nourishment 🧠💖");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        slowPrint("What would you like to do today?", 40);
        System.out.println();

        System.out.println("1️) Build a mood-based sandwich or create your own 💭🥪");
        System.out.println("2) Pick a signature sandwich from the full menu 📜");
        System.out.println("3️) Remove a sandwich from your order ❌");
        System.out.println("4️) Add a Special Combo (chips + drink) 🍟🥤");
        System.out.println("5) View your current order or proceed to checkout 💳🧾");
        System.out.println("X) Return Home 🏠");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("👉 Enter your choice: ");
    }

}
