package ua.advanced.practice4.task2;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InputStream cache = System.in;
        while (true) {
            Thread t = new Thread() {
                public void run() {
                    Spam.main(null);
                }
            };
            System.setIn(new MyInputStream());
            t.start();
            t.join();
            System.out.println("///////////////////////RESTART///////////////////////////");
            System.setIn(cache);
        }
    }
}
