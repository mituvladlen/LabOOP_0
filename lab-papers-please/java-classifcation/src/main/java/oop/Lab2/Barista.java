package oop.Lab2;
import java.util.List;

public class Barista {

    public void prepareCoffees(List<String> coffeeOrders) {
        for (String order : coffeeOrders) {
            Coffee coffee = createCoffee(order);
            if (coffee != null) {
                coffee.makeCoffee();
            } else {
                System.out.println("Unknown coffee type: " + order);
            }
        }
    }

    private Coffee createCoffee(String order) {
        return switch (order.toLowerCase()) {
            case "cappuccino" -> new Cappuccino(Intensity.MEDIUM, 50);
            case "pumpkinspicelatte" -> new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
            case "americano" -> new Americano(Intensity.STRONG, 200);
            case "syrupcappuccino" -> new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.VANILLA);
            default -> null;
        };
    }
}
