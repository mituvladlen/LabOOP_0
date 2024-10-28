package oop.Lab1;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    // Constructor to initialize assistantName and assignedDisplays
    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // Adds a Display object to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    // Iterates through assignedDisplays and compares displays
    public void assist() {
        System.out.println("Assistant " + assistantName + " is comparing displays:");
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display current = assignedDisplays.get(i);
            Display next = assignedDisplays.get(i + 1);
            System.out.println("Comparing " + current.getModel() + " with " + next.getModel() + ":");
            current.compareWithMonitor(next);  // Assume this method is implemented in Display class
        }
    }

    // Removes a display from the list and returns it
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("Display " + d.getModel() + " bought.");
            return d;
        } else {
            System.out.println("Display " + d.getModel() + " not found in assigned list.");
            return null;
        }
    }
}
