package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private List<Sandwich> comboSandwich = new ArrayList<>();
    private List<String> chipsList = new ArrayList<>();
    private List<String> drinksList = new ArrayList<>();
    private String customerName;
    private String timeStamp;


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


    public int addSandwiches(Sandwich s){
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
                regularTotal += s.totalPrice();
            }

            double comboTotal = getTotalComboPrice();

            return regularTotal + comboTotal;
    }
    public double addCombo(Sandwich sandwich, String chips, String drink) {
        sandwiches.add(sandwich);
        chipsList.add(chips);
        drinksList.add(drink);
        return 8.88;
    }
    public double getTotalComboPrice(){
        return comboSandwich.size()*8.88;
    }

    public String printReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("Divine Deli Receipt\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("com.thedivinedeli.app.Order Time: ").append(timeStamp).append("\n");
        receipt.append("Printed At: ").append(LocalDateTime.now()).append("\n");
        receipt.append("Moods may change, but this purchase is final. No refunds or exchanges allowed");

        receipt.append("\n--- Regular Sandwiches ---\n");
        for (Sandwich s : sandwiches) {
            receipt.append(s).append("\n");
            receipt.append("-----------------------------------\n");
        }

        receipt.append("\n--- Combo Meals ---\n");
        for (int i = 0; i < comboSandwich.size(); i++) {
            Sandwich s = comboSandwich.get(i);
            receipt.append(s).append("\n");
            if (i < chipsList.size()) {
                receipt.append("Chips: ").append(chipsList.get(i)).append("\n");
            }
            if (i < drinksList.size()) {
                receipt.append("Drink: ").append(drinksList.get(i)).append("\n");
            }
            receipt.append("Combo Price: $8.88\n");
            receipt.append("-----------------------------------\n");
        }
        return receipt.toString();
        }

    }
