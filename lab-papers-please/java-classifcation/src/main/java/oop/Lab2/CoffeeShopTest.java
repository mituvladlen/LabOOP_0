package oop.Lab2;

public class CoffeeShopTest {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        Americano americano = new Americano(Intensity.STRONG, 200);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.VANILLA);

        System.out.println("Cappuccino:");
        cappuccino.printDetails();
        System.out.println();

        System.out.println("Pumpkin Spice Latte:");
        pumpkinSpiceLatte.printDetails();
        System.out.println();

        System.out.println("Americano:");
        americano.printDetails();
        System.out.println();

        System.out.println("Syrup Cappuccino:");
        syrupCappuccino.printDetails();
    }
}
