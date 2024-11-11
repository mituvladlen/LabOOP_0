package oop.Lab2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();

        // Adding coffee orders
        List<String> orders = List.of("cappuccino", "pumpkinspicelatte", "americano", "syrupcappuccino");
        orders.forEach(barista::addCoffeeOrder);

        // Prepare all coffees
        barista.prepareCoffees();
    }
}

