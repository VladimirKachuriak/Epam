package ua.advanced.practice5.task11;

public class Terminal implements Runnable{
    private Airport airport;

    public Terminal(Airport airport) {
        this.airport = airport;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Plane plane = airport.getPlane();

                if (plane != null) {
                    System.out.println("Aircraft with id: "+plane.getId()+" is service");
                    Thread.sleep(6*plane.getCountOfPeople() / plane.getNumberOfTrap());
                    System.out.println("Aircraft with id: "+plane.getId()+" is refuel");
                    Thread.sleep(plane.getRoute().getValue()*5);
                    System.out.println("Aircraft with id: "+plane.getId()+" flight away");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
