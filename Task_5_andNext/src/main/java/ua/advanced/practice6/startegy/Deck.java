package ua.advanced.practice6.startegy;

import java.util.List;

public interface Deck{
    Card dealCard();
    List<Card> restCards();
    int size();
}
