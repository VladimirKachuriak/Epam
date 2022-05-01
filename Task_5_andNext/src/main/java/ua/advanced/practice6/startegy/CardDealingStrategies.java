package ua.advanced.practice6.startegy;

import ua.advanced.practice6.MyLogger;

import java.util.*;
import java.util.logging.Level;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new CardDealingStrategy() {
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                MyLogger.logger.log(Level.INFO, "Start TexasHoldemCarDealingStrategy");
                Map<String, List<Card>> map = new TreeMap<>();
                List<Card>[] arr = new List[players];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < players; j++) {
                        if (i == 0) arr[j] = new ArrayList<>();
                        arr[j].add(deck.dealCard());
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    map.put("Player " + (i + 1), arr[i]);
                }
                List<Card> community = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    community.add(deck.dealCard());
                }
                map.put("Community", community);

                map.put("Remaining", deck.restCards());
                return map;
            }
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new CardDealingStrategy() {
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                MyLogger.logger.log(Level.INFO, "Start classicPokerCardDealingStrategy");
                Map<String, List<Card>> map = new TreeMap<>();
                List<Card>[] arr = new List[players];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < players; j++) {
                        if (i == 0) arr[j] = new ArrayList<>();
                        arr[j].add(deck.dealCard());
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    map.put("Player " + (i + 1), arr[i]);
                }
                map.put("Remaining", deck.restCards());
                return map;
            }
        };
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return new CardDealingStrategy() {
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                MyLogger.logger.log(Level.INFO, "bridgeCardDealingStrategy");
                Map<String, List<Card>> map = new TreeMap<>();
                int max = deck.size() / players;
                List<Card>[] arr = new List[players];
                for (int i = 0; i < max; i++) {
                    for (int j = 0; j < players; j++) {
                        if (i == 0) arr[j] = new ArrayList<>();
                        arr[j].add(deck.dealCard());
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    map.put("Player " + (i + 1), arr[i]);
                }
                return map;
            }
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return new CardDealingStrategy() {
            @Override
            public Map<String, List<Card>> dealStacks(Deck deck, int players) {
                MyLogger.logger.log(Level.INFO, "foolCardDealingStrategy");
                Map<String, List<Card>> map = new TreeMap<>();
                List<Card>[] arr = new List[players];
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < players; j++) {
                        if (i == 0) arr[j] = new ArrayList<>();
                        arr[j].add(deck.dealCard());
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    map.put("Player " + (i + 1), arr[i]);
                }
                map.put("Trump card", new ArrayList<Card>(List.of(deck.dealCard())));
                map.put("Remaining", deck.restCards());
                return map;
            }
        };
    }

}
