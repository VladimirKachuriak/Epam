package ua.advanced.practice5.task9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Auction {
    private List<Lot> lotList = new ArrayList<>();
    private List<Participant> participantList = new ArrayList<>();
    public static CyclicBarrier barrier;
    private int winnerIndex;
    public Auction(int numberParticipant) {
        this.barrier = new CyclicBarrier(numberParticipant, () ->winnerIndex = Auction.this.defineHigherValue().getParticipantId());
    }

    public void startAuction() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (Lot lot : lotList) {
            System.out.println("Now lot is:" + lot.toString());
            for (Participant participant : participantList) {
                participant.setCurrentLotPrice(lot.getBasePrice());
                Thread thread = new Thread(participant);
                thread.start();
                list.add(thread);
            }
            for (Thread thread:list) {
                thread.join();
            }
            defineWinner();
            //Thread.sleep(5000);
        }

    }
    public Participant defineWinner() {
        Participant winner = Collections.max(participantList,
                Comparator.comparingInt(Participant::getMybet));
        if(winner.getCash()-winner.getCurrentLotPrice()<0){
            winner.setKickCounter(2);
            System.out.println("Participant #" + winner.getParticipantId()+" was kicked for two auction cause have not enough money");
            return winner;
        }
        System.out.println("Participant #" + winnerIndex + ", price:"
                + winner.getCurrentLotPrice() + " win!");

        winner.setCash(winner.getCash() - winner.getCurrentLotPrice());
        return winner;
    }
    public Participant defineHigherValue() {
        Participant winner = Collections.max(participantList,
                Comparator.comparingInt(Participant::getMybet));
        System.out.println("Participant #" + winner.getParticipantId() + ", price:"
                + winner.getCurrentLotPrice() + " got highest bet!");
        for (Participant participant : participantList) {
            participant.setCurrentLotPrice(winner.getCurrentLotPrice());
        }
        return winner;
    }


    public void addLot(Lot lot) {
        lotList.add(lot);
    }

    public void addParticipant(Participant participant) {
        participantList.add(participant);
    }
}
