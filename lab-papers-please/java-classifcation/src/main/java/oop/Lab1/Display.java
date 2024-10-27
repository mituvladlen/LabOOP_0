package oop.Lab1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    // Constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Method to compare size based on width and height
    public void compareSize(Display otherDisplay) {
        int thisArea = this.width * this.height;
        int otherArea = otherDisplay.width * otherDisplay.height;
        if (thisArea > otherArea) {
            System.out.println(this.model + " is bigger than " + otherDisplay.model);
        } else if (thisArea < otherArea) {
            System.out.println(otherDisplay.model + " is bigger than " + this.model);
        } else {
            System.out.println(this.model + " and " + otherDisplay.model + " are the same size.");
        }
    }

    // Method to compare sharpness based on pixels per inch (ppi)
    public void compareSharpness(Display otherDisplay) {
        if (this.ppi > otherDisplay.ppi) {
            System.out.println(this.model + " is sharper than " + otherDisplay.model);
        } else if (this.ppi < otherDisplay.ppi) {
            System.out.println(otherDisplay.model + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + otherDisplay.model + " have the same sharpness.");
        }
    }

    // Method to compare both size and sharpness
    public void compareWithMonitor(Display otherDisplay) {
        compareSize(otherDisplay);
        compareSharpness(otherDisplay);
    }
}
