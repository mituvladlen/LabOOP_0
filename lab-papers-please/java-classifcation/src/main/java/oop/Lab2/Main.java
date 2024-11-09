package oop.Lab2;

import oop.Lab2.Barista;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Barista barista = new Barista();
        List<String> coffeeOrders = List.of("Cappuccino", "PumpkinSpiceLatte", "Americano", "SyrupCappuccino");
        barista.prepareCoffees(coffeeOrders);
    }
}
