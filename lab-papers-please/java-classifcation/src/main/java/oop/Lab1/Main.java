package oop.Lab1;

public class Main {
    public static void main(String[] args) {
        // Create Assistant
        Assistant assistant = new Assistant("TechAdvisor");

        // Instantiate Display objects
        Display display1 = new Display(1920, 1080, 401, "Display1");
        Display display2 = new Display(2560, 1440, 530, "Display2");
        Display display3 = new Display(3840, 2160, 807, "Display3");

        // Assign displays to Assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        // Use the assist method to compare displays
        assistant.assist();

        // Choose a display to buy
        assistant.buyDisplay(display2);
    }
}

