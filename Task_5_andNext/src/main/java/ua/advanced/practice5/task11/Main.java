package ua.advanced.practice5.task11;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();

        PlaneGenerator planeGenerator = new PlaneGenerator(airport, 10);
        new Thread(planeGenerator).start();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Terminal(airport));
            thread.start();
        }
    }
}
