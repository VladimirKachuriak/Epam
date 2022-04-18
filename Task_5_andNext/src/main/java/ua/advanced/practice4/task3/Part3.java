package ua.advanced.practice4.task3;


public class Part3 {
    private int counter;
    private int counter2;

    public void compare() throws InterruptedException {
        if (counter > counter2) {
            System.out.println(counter + ">" + counter2);
        } else if (counter < counter2) {
            System.out.println(counter + "<" + counter2);
        } else {
            System.out.println(counter + "=" + counter2);
        }
        counter++;
        Thread.sleep(100);
        counter2++;
    }

    public synchronized void compareSync() throws InterruptedException {
        if (counter > counter2) {
            System.out.println(counter + ">" + counter2);
        } else if (counter > counter2) {
            System.out.println(counter + "<" + counter2);
        } else {
            System.out.println(counter + "=" + counter2);
        }
        counter++;
        Thread.sleep(100);
        counter2++;
    }

    public static void main(String[] args){
        Part3 part = new Part3();
        Runnable runnable = ()-> {
            try {
                while (true) {
                    part.compare();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnableSync = ()-> {
            try {
                while (true) {
                    part.compareSync();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //unsynchronized
        /*
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);*/
        //synchronized

        Thread thread = new Thread(runnableSync);
        Thread thread1 = new Thread(runnableSync);


        thread.start();
        thread1.start();


    }
}
