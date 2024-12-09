package oop.Lab2;

import java.util.ArrayList;
import java.util.List;

// Managing coffee orders and preparing each type of coffee.
public class Barista {
    // A list to store coffee orders
    private final List<Coffee> coffeeOrders = new ArrayList<>();

    // Adds a coffee order by name, converting it into a Coffee object if the type is recognized.
    public void addCoffeeOrder(String order) {
        Coffee coffee = createCoffee(order); // Create a Coffee object based on the order name
        if (coffee != null) {
            coffeeOrders.add(coffee); // Add to the list if it's a valid coffee type
        } else {
            System.out.println("Unknown coffee type: " + order);
        }
    }

    // Prepares all the coffee orders, invoking the specific preparation method for each coffee type.
    public void prepareCoffees() {
        for (Coffee coffee : coffeeOrders) {
            if (coffee instanceof Cappuccino) {
                ((Cappuccino) coffee).makeCoffee();
            } else if (coffee instanceof PumpkinSpiceLatte) {
                ((PumpkinSpiceLatte) coffee).makeCoffee();
            } else if (coffee instanceof Americano) {
                ((Americano) coffee).makeCoffee();
            } else if (coffee instanceof SyrupCappuccino) {
                ((SyrupCappuccino) coffee).makeCoffee();
            } else {
                coffee.makeCoffee();
            }
        }
    }

    // Creates and returns a Coffee object based on the provided order name.
    private Coffee createCoffee(String order) {
        return switch (order.toLowerCase()) {
            case "cappuccino" -> new Cappuccino(Intensity.MEDIUM, 50);
            case "pumpkinspicelatte" -> new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
            case "syrupcappuccino" -> new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.COCONUT);
            default -> null;
        };
    }
}
