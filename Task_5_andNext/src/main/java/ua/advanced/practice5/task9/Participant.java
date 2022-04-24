package ua.advanced.practice5.task9;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private int currentLotPrice;
    private int participantId;
    private int cash;
    private int numberOfBets;
    private int kickCounter = 0;
    private int mybet;
    private CyclicBarrier barrier = Auction.barrier;

    public Participant(int num, int cash) {
        participantId = num;
        this.cash = cash;
    }

    public void setCurrentLotPrice(int price) {
        currentLotPrice = price;
    }

    @Override
    public void run() {
        try {
            int numberOfBet = new Random().nextInt(3)+1;
            for (int i=0;  i<3; i++) {
                if(kickCounter>0){
                    System.out.println("Participant " + participantId
                            + " was kicked and will play after "+kickCounter+"lot");
                    this.barrier.await();
                    continue;
                }
                if(numberOfBet<=0){
                    System.out.println("Participant " + participantId
                            + " Don't make a bet");
                    this.barrier.await();
                    continue;
                }
                System.out.println("Participant " + participantId
                        + " specifies a price. (cash = " + cash + ")");
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2500));
                int delta = new Random().nextInt(20); /* determine the level of
 price increase */
                currentLotPrice += delta;
                mybet=currentLotPrice;
                System.out.println("Auction Participant " + participantId + " : " + mybet);
                this.barrier.await(); // stop at the barrier
                /*System.out.println("Participant " + participantId
                        + " Continue to work...(cash = " + cash + ")");*/
                numberOfBet--;
            }
            kickCounter--;
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public int getMybet() {
        return mybet;
    }

    public int getKickCounter() {
        return kickCounter;
    }

    public void setKickCounter(int kickCounter) {
        this.kickCounter = kickCounter;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public int getCurrentLotPrice() {
        return currentLotPrice;
    }
}
