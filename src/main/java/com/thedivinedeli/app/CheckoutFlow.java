package com.thedivinedeli.app;

import com.thedivinedeli.app.ReceiptGenerator.ReceiptGenerator;

import java.util.Scanner;

public class CheckoutFlow {
    public static void start(Scanner scanner, Order order){
        if (order.getSandwiches().isEmpty() && order.getComboSandwiches().isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        if (!order.getComboSandwiches().isEmpty() && (!order.getSandwiches().isEmpty())){
            System.out.println("Here is a preview of your order.");
            order.printReceipt();
        }


        System.out.println("Would you like to confirm your order? (yes/no): ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("yes")){
            System.out.println("Thank you for choosing The Divine Deli! I hope your mood was enhanced or got better eating this sandwich!");
            System.out.println("\n------------FINAL RECEIPT--------------");
            System.out.println(order.printReceipt());

        }
        else {
            System.out.println("Order not placed. Returning to Home Screen");
        }
        ReceiptGenerator.Generate(order);
    }
}
