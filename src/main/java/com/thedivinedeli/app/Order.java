package com.thedivinedeli.app;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private String customerName;
    private String timeStamp;
    private Drinks selectedDrink;

    public Chips getSelectedChips() {
        return selectedChips;
    }

    public void setSelectedChips(Chips selectedChips) {
        this.selectedChips = selectedChips;
    }

    public Drinks getSelectedDrink() {
        return selectedDrink;
    }

    public void setSelectedDrink(Drinks selectedDrink) {
        this.selectedDrink = selectedDrink;
    }

    private Chips selectedChips;



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

    public double getOrderTotal() {
        double orderTotal = 0.0;
        for(Sandwich s : sandwiches){
            orderTotal += s.totalPrice();
        }

        return orderTotal;
    }

    public String printReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("Divine Deli Receipt\n");
        receipt.append("Customer: ").append(customerName).append("\n");
        receipt.append("com.thedivinedeli.app.Order Time: ").append(timeStamp).append("\n");
        receipt.append("Printed At: ").append(LocalDateTime.now()).append("\n");
        receipt.append("Moods may change, but this purchase is final. No refunds or exchanges allowed");

        for (Sandwich s : sandwiches){
            receipt.append(s).append("\n\n");
        }
        if (selectedChips != null){
            selectedChips.displayDetails();
        } else{
            System.out.println("Nothing to see here...");
        }
        if (selectedDrink != null){
            selectedDrink.displayDetails();
        }
        else {
            System.out.println("Nothing to see here...");
        }
        receipt.append("Total: $").append(String.format("%.2f", getOrderTotal()));
        return receipt.toString();
    }

}
