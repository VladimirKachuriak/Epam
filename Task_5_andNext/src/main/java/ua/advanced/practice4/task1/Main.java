package ua.advanced.practice4.task1;
class MyThread extends Thread{
    public void run() {
        for (float i = 0; i < 2; i+=1/3f) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (float i = 0; i < 2; i+=1/3f) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("fsad");

        MyThread thread = new MyThread();
        thread.start();
        thread.join();

        Thread runnable = new Thread(new MyRunnable());
        runnable.start();

    }
}
