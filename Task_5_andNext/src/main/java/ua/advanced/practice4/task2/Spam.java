package ua.advanced.practice4.task2;



import javax.swing.*;
import java.util.Scanner;


public class Spam{
    private Thread[] threads;
    public Spam(String[] str, int[] number) {
        if(Math.min(str.length,number.length)<2)return;
        threads = new Thread[Math.min(str.length,number.length)];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker(str[i],number[i]);
        }
    }
    public void start() {
        for (Thread thread:threads) {
            thread.start();
        }
    }
    public void stop() {
        for (Thread thread:threads) {
            thread.stop();
        }
    }
    private static class Worker extends Thread {
        private String message;
        private int timeout;
        public Worker(String message, int timeout) {
            this.message = message;
            this.timeout = timeout;
        }
        @Override
        public void run() {
            while (true){
                System.out.println(message);
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] messages = new String[] { "@@@", "bbbbbbb" };
        int[] times = new int[] { 333, 222 };
        Spam spam = new Spam(messages, times);
        spam.start();
        /*JFrame win  = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500,300);
        JPanel panel = new JPanel();
        JButton enter = new JButton("Enter");
        enter.addActionListener(e -> spam.stop());
        panel.add(enter);
        win.setContentPane(panel);
        win.setVisible(true);*/
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        spam.stop();



    }
}
