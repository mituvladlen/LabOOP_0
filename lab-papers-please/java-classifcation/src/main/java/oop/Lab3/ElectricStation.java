package oop.Lab3;

public class ElectricStation implements Refuelable{
    private static int electricCarsCount = 0;
    @Override
    public void refuel(int carId){
        System.out.println("Refueling electric car " + carId + ".");
        electricCarsCount++;
    }
    public static int getElectricCarsCount() {
        return electricCarsCount;
    }
}