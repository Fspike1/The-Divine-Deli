package com.thedivinedeli.app.ReceiptGenerator;

import com.thedivinedeli.app.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptGenerator {
    public static void Generate(Order order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = formatter.format(now);
        String receiptText = order.printReceipt();
        String fileName = "Receipt_" + timestamp + ".txt";

        try {

            FileWriter writer = new FileWriter("Receipts.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("----- Receipt: " + timestamp + " -----\n");

            bufferedWriter.write(receiptText);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("There was an error writing your file");
        }
        File file = new File("Receipts.txt");
        if (!file.exists()) {
            System.out.println("No such file");
            return;
        }
        System.out.println("Looking in: " + file.getAbsolutePath());


        try {
            FileReader reader = new FileReader("Receipts.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedReader.readLine();
                System.out.println(line);
                bufferedReader.close();
                reader.close();
            }

        } catch (IOException e) {
            System.out.println("There was an error reading your file");
        }


        System.out.println("Thank you for choosing The Divine Deli! I hope your mood was enhanced or got better eating this sandwich!");
        System.out.println("\n------------FINAL RECEIPT--------------");
        System.out.println(order.printReceipt());
        System.out.println("Receipt saved as: " + new File(fileName).getAbsolutePath());

    }

}
