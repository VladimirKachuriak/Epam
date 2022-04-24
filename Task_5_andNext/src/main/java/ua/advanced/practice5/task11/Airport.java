package ua.advanced.practice5.task11;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Plane> planeList = new ArrayList<>();
    private final int maxCount = 5;

    public synchronized boolean addPlane(Plane plane) {
        try {
            if (planeList.size() < maxCount) {
                notifyAll();
                planeList.add(plane);
                System.out.println("Aicraft with id:"+plane.getId()+" landing to the airport");
                return true;
            } else {
                System.out.println( "Airport is full");
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized Plane getPlane() {
        try {
            if (planeList.size() > 0) {
                notifyAll();
                Plane plane = planeList.get(0);
                planeList.remove(plane);
                return plane;
            } else {
                System.out.println("No plane yet");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
