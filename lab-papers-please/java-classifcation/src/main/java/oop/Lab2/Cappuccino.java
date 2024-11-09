package oop.Lab2;

public class Cappuccino extends Coffee {
    private int mlOfMilk;
    private final String coffee = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Cappuccino milk: " + mlOfMilk + "ml");
    }
}