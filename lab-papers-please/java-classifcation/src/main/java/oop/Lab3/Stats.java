package oop.Lab3;

public class Stats {
    private final int totalElectricCars;
    private final int totalGasCars;
    private final int totalPeople;
    private final int totalRobots;
    private final int totalDining;
    private final int totalNotDining;
    private final int consumptionElectric;
    private final int consumptionGas;

    public Stats() {
        this.totalElectricCars = ElectricStation.getElectricCarsCount();
        this.totalGasCars = GasStation.getGasCarsCount();
        this.totalDining = PeopleDinner.getPeopleServedCount() + RobotDinner.getRobotsServedCount();
        this.totalNotDining = this.totalElectricCars + this.totalGasCars - this.totalDining;
        this.totalPeople = CarStation.getTotalPeople();
        this.totalRobots = CarStation.getTotalRobots();
        this.consumptionElectric = CarStation.getElectricConsumption();
        this.consumptionGas = CarStation.getGasConsumption();
    }

    public void printStats() {
        System.out.println(String.format(
                "{\"ELECTRIC\": %d, \"GAS\": %d, \"PEOPLE\": %d, \"ROBOTS\": %d, \"DINING\": %d, \"NOT_DINING\": %d, \"CONSUMPTION\": {\"ELECTRIC\": %d, \"GAS\": %d}}",
                totalElectricCars, totalGasCars, totalPeople, totalRobots, totalDining, totalNotDining, consumptionElectric, consumptionGas
        ));
    }

}