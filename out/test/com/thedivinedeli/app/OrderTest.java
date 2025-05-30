package com.thedivinedeli.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {


    @Test
    public void testAddSandwichIncreasesCartSize() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich();
        sandwich.setSandwichName("Testwich");

        order.addSandwich(sandwich);

        assertEquals(1, order.getSandwiches().size());
        assertEquals("Testwich", order.getSandwiches().get(0).getSandwichName());
    }

}


