package oop.Lab3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Comparator;

public class ScheduledTasks {

    private final ObjectMapper mapper = new ObjectMapper();
    private final FolderRead folderRead = new FolderRead();
    private final Semaphore semaphore = initSemaphore();
    private final List<String> processed = new ArrayList<>();

    private long lastProcessedTime = System.currentTimeMillis();
    private static final long INACTIVITY_THRESHOLD = 5000;  // 5 seconds of inactivity

    public void startScheduledTasks() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.scheduleWithFixedDelay(() -> {
            try {
                readCars();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 3000, TimeUnit.MILLISECONDS);

        executor.scheduleWithFixedDelay(() -> serveCars(), 0, 5000, TimeUnit.MILLISECONDS);


        executor.scheduleWithFixedDelay(() -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastProcessedTime > INACTIVITY_THRESHOLD) {
                System.out.println("No new files processed in the last 5 seconds. Stopping the program.");
                Stats stats = new Stats();
                stats.printStats();
                executor.shutdown();
                Runtime.getRuntime().exit(0);  // exit program
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    public void readCars() throws IOException {
        File[] list = folderRead.readDirectory("src/main/queue");

        if (list == null || list.length == 0) {
            return;
        }

        Arrays.sort(list, Comparator.comparingLong(File::lastModified));

        boolean filesProcessed = false;

        for (File file : list) {
            if (processed.contains(file.getName())) {
                continue;
            }

            try {
                Car car = mapper.readValue(file, Car.class);
                semaphore.sortCars(car);
                processed.add(file.getName());
                file.delete();
                filesProcessed = true;
            } catch (IOException e) {
                System.out.println("Error parsing file " + file.getName() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        if (filesProcessed) {
            lastProcessedTime = System.currentTimeMillis();
        }
    }


    public void serveCars() {
        System.out.println("-------Serving-------");
        System.out.println("##########");
        System.out.println("Serving Cars at Gas and Robots Station");
        semaphore.getRobotsGas().serveCars();
        System.out.println("##########");
        System.out.println("Serving Cars at Electric and Robots Station");
        semaphore.getRobotsElectric().serveCars();
        System.out.println("##########");
        System.out.println("Serving Cars at Electric and People Station");
        semaphore.getPeopleElectric().serveCars();
        System.out.println("##########");
        System.out.println("Serving Cars at Gas and People Station");
        semaphore.getPeopleGas().serveCars();
    }

    public Semaphore initSemaphore() {
        //4 refuel services
        Refuelable peopleGasRefuelService = new GasStation();
        Refuelable robotsGasRefuelService = new GasStation();
        Refuelable robotsElectricRefuelService = new ElectricStation();
        Refuelable peopleElectricRefuelService = new ElectricStation();

        //4 dinner services
        Dineable peopleGasDinnerService = new PeopleDinner();
        Dineable robotsGasDinnerService = new RobotDinner();
        Dineable peopleElectricDinnerService = new PeopleDinner();
        Dineable robotsElectricDinnerService = new RobotDinner();

        //4 queues for each car station type
        Queue<Car> queue1 = new ArrayImplementation<>();
        Queue<Car> queue2= new DoubleStackImplementation<>();
        Queue<Car> queue3 = new LinkedListImplementation<>();
        Queue<Car> queue4 = new LinkedListImplementation<>();

        CarStation peopleGasStation = new CarStation(peopleGasDinnerService, peopleGasRefuelService, queue1);
        CarStation robotsGasStation = new CarStation(robotsGasDinnerService, robotsGasRefuelService, queue2);
        CarStation peopleElectricStation = new CarStation(peopleElectricDinnerService, peopleElectricRefuelService, queue3);
        CarStation robotsElectricStation = new CarStation(robotsElectricDinnerService, robotsElectricRefuelService, queue4);

        return new Semaphore(peopleGasStation,peopleElectricStation, robotsGasStation, robotsElectricStation);
    }

}