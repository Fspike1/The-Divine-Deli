package com.thedivinedeli.app;

import java.util.*;

public class ViewOrderFlow {
    public static void start(Scanner scanner, Order order) {

        List<Sandwich> cart = order.getSandwiches();//gets list of current sandwiches in cart added by customer.
        if (order.getSandwiches().isEmpty()) {
            System.out.println("Your cart is currently empty.");
            return;

        }
        for(int i = 0; i < cart.size(); i++){//tells the loop to keep going until it’s shown every sandwich
            Sandwich s = cart.get(i);//java starts i at 0, but we count from 1 so i + 1 makes menu readable
            System.out.println((i + 1)+ ")" + s.getSandwichName());
        }
        //%.2f displays price(in this case) with only 2 decimal places: shows like this(2.00)
        System.out.println("Total so far: $" + String.format("%.2f", order.getOrderTotal()));
        System.out.println("Press Enter to return to the Home Screen...");
        scanner.nextLine();

    }
}

