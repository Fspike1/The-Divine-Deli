package com.thedivinedeli.app;

import java.util.List;
import java.util.Scanner;

public class RemoveSandwichFlow {
    public static void start(Scanner scanner, Order order){
        if (order.getSandwiches().isEmpty() && order.getComboSandwiches().isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        if (!order.getComboSandwiches().isEmpty() && (!order.getSandwiches().isEmpty())){
            System.out.println("Here is a preview of your order.");
            order.printReceipt();
        }
        List<Sandwich> cart = order.getSandwiches();//gets list of current sandwiches in cart added by customer.

        for(int i = 0; i < cart.size(); i ++){
            Sandwich s = cart.get(i);//java starts i at 0, but we count from 1 so i + 1 makes menu readable
            System.out.println((i + 1)+ ")" + s.getSandwichName());
        }
        System.out.println("Enter the number of the sandwich you wish to remove.");
        int removeSandwich = scanner.nextInt();
        scanner.nextLine();

        if (removeSandwich >= 1 && removeSandwich <= cart.size()){
            System.out.println("You are about to remove item " + removeSandwich + ")");
            cart.remove(removeSandwich -1);

        }
        else{
            System.out.println("That number is not valid. Please try again.");

        }

        System.out.println("Item number " + removeSandwich + ") was safely removed from your cart." );

    }
}
