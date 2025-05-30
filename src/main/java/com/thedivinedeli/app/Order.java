package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private List<Sandwich> comboSandwiches = new ArrayList<>();
    private List<String> chipsList = new ArrayList<>();
    private List<String> drinksList = new ArrayList<>();
    private String customerName;
    private String timeStamp;
    private boolean hasCombo;
    private ComboItem chips;

    public ComboItem getDrink() {
        return drink;
    }

    public void setDrink(ComboItem drink) {
        this.drink = drink;
    }

    public ComboItem getChips() {
        return chips;
    }

    public void setChips(ComboItem chips) {
        this.chips = chips;
    }

    public Sandwich getComboSandwich() {
        return comboSandwiches.getLast();
    }

    public boolean isHasCombo() {
        return hasCombo;
    }

    public void setHasCombo(boolean hasCombo) {
        this.hasCombo = hasCombo;
    }

    public List<String> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<String> drinksList) {
        this.drinksList = drinksList;
    }

    public List<String> getChipsList() {
        return chipsList;
    }

    public void setChipsList(List<String> chipsList) {
        this.chipsList = chipsList;
    }

    public List<Sandwich> getComboSandwiches() {
        return comboSandwiches;
    }

    private ComboItem drink;


    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public int addSandwiches(Sandwich s) {
        sandwiches.add(s);


        return sandwiches.size();

    }

    public void addChips(String chipName) {
        chipsList.add(chipName);
    }

    public void addDrink(String drinkName) {
        drinksList.add(drinkName);
    }


    public double getOrderTotal() {
        double regularTotal = 0.0;
        for (Sandwich s : sandwiches) {
            regularTotal += s.sandwichPrice();
        }
        double comboTotal = getTotalComboPrice();

        return regularTotal + comboTotal;
    }

    public void addCombo(Sandwich comboSandwich, String chips, String drink) {
        hasCombo = true;
        comboSandwiches.add(comboSandwich);
        chipsList.add(chips);
        drinksList.add(drink);

    }

    public double getTotalComboPrice() {
        double total = 0.0;
        for (Sandwich s : comboSandwiches) {
            if (s.isMoodBased()) {
                total += 8.88;
            } else {
                total += s.sandwichPrice() + 1.11;
            }
        }
        return total;    }

    public String printReceipt() {

        StringBuilder receipt = new StringBuilder();
        receipt.append("Divine Deli Receipt\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("Order Time: ").append(timeStamp).append("\n");
        receipt.append("Printed At: ").append(LocalDateTime.now()).append("\n");
        receipt.append("Moods may change, but this purchase is final. No refunds or exchanges allowed");

        if (hasCombo && !comboSandwiches.isEmpty()) {
            receipt.append("\n--- Combo Meals ---\n");

            for (int i = 0; i < comboSandwiches.size(); i++) {
                Sandwich s = comboSandwiches.get(i);

                //Could use this: String comboType = s.isMoodBased() ? "Mood Combo" : "Custom Combo";
                String comboType;
                if (s.isMoodBased()){
                    comboType = "Mood Combo";
                }
                else{
                    comboType = "Custom Combo";
                }
                receipt.append(s).append("\n");
                if (i < chipsList.size()) {
                    receipt.append("Chips: ").append(chipsList.get(i)).append("\n");
                }
                if (i < drinksList.size()) {
                    receipt.append("Drink: ").append(drinksList.get(i)).append("\n");
                }
                double price = 0.0;
                if(s.isMoodBased()) {
                   price = 8.88;
                }
                else {
                  price = s.sandwichPrice() + 1.11;

                }
                receipt.append("Combo Price: $").append(String.format("%.2f",price)).append("\n");
                receipt.append("-----------------------------------\n");
            }
        }


        receipt.append("\n--- Regular Sandwiches ---\n");
        if (!sandwiches.isEmpty()) {
            receipt.append("\n--- Regular Sandwiches ---\n");
            for (Sandwich s : sandwiches) {
                receipt.append(s).append("\n");
                receipt.append("-----------------------------------\n");
            }
        }
        else {
            receipt.append("\n--- Regular Sandwiches ---\n");
            receipt.append("(No regular sandwiches in this order)\n");
            receipt.append("-----------------------------------\n");
        }
        receipt.append("\n🍞🧀🥓 Totals 🧾💰\n");

        receipt.append("═════════════════════════════════\n");

        receipt.append("\nTotal Order Price: $").append(String.format("%.2f", getOrderTotal())).append("\n");
        receipt.append("\nRegular Sandwiches Total: $")
                .append(String.format("%.2f", sandwiches.stream().mapToDouble(Sandwich::sandwichPrice).sum()))
                .append("\n");

        receipt.append("Combo Meals Total: $")
                .append(String.format("%.2f", getTotalComboPrice()))
                .append("\n");

        receipt.append("Grand Total: $")
                .append(String.format("%.2f", getOrderTotal()))
                .append("\n");
        receipt.append("═════════════════════════════════\n");



        return receipt.toString();

    }

    @Override
    public String toString() {
        // Start with customer and time info
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Order Time: ").append(timeStamp).append("\n");

        // If there are regular sandwiches
        if (!sandwiches.isEmpty()) {
            sb.append("\n--- Regular Sandwiches ---\n");
            for (Sandwich s : sandwiches) {
                sb.append(s.toString()).append("\n");
            }
        }



        return printReceipt();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
}

