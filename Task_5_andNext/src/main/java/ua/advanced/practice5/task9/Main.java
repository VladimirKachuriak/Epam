package ua.advanced.practice5.task9;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numbersParticipant = 5;
        Auction auction = new Auction(numbersParticipant);
        auction.addLot(new Lot("pen",20));
        auction.addLot(new Lot("stick",7));
        auction.addLot(new Lot("toy",14));
        for (int num = 0; num < numbersParticipant; num++) {
            int cash = 100 + new Random().nextInt(10);
            Participant participant = new Participant(num,  cash);
            auction.addParticipant(participant);
        }
        auction.startAuction();
    }
}
