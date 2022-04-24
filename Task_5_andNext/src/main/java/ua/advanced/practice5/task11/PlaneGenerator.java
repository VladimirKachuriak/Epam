package ua.advanced.practice5.task11;

import java.util.Random;

public class PlaneGenerator implements Runnable{
    private Airport airport;
    private int planeCounter;

    public PlaneGenerator(Airport airport, int planeCounter) {
        this.airport = airport;
        this.planeCounter = planeCounter;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < planeCounter) {
            count++;
            Plane plane= new Plane(new Random().nextInt(100)+100,new Random().nextInt(3)+1,
                    RouteDistance.values()[new Random().nextInt(RouteDistance.values().length)]);
            System.out.println("Aircraft with id:"+plane.getId()+" requesting landing");
            boolean flag = false;
            try {
                while (!flag) {
                    flag = airport.addPlane(plane);
                    Thread.sleep(100);
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
