package oop.Lab1;

public class Main {
    public static void main(String[] args) {
        // Instantiate three Display objects
        Display display1 = new Display(1920, 1080, 401, "Display1");
        Display display2 = new Display(2560, 1440, 530, "Display2");
        Display display3 = new Display(3840, 2160, 807, "Display3");

        // Perform comparisons and print results
        System.out.println("Comparing Display1 and Display2:");
        display1.compareWithMonitor(display2);

        System.out.println("\nComparing Display2 and Display3:");
        display2.compareWithMonitor(display3);

        System.out.println("\nComparing Display3 and Display1:");
        display3.compareWithMonitor(display1);
    }
}

