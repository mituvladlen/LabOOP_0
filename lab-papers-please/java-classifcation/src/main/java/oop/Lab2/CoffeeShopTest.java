package oop.Lab2;

public class CoffeeShopTest {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
        cappuccino.makeCoffee();
        System.out.println();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        pumpkinSpiceLatte.makeCoffee();
        System.out.println();

        Americano americano = new Americano(Intensity.STRONG, 200);
        americano.makeCoffee();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.VANILLA);
        syrupCappuccino.makeCoffee();
    }
}
