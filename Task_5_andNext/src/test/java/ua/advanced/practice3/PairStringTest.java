package ua.advanced.practice3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairStringTest {

    @Test
    void add() {
        PairString pair = new PairString();
        pair.add("apple");
        pair.addByIndex("banana", 1);

        assertEquals(4, pair.getSize());
    }

    @Test
    void addByIndex() {
        PairString pair = new PairString();
        pair.add("apple");
        pair.addByIndex("banana", 1);

        assertEquals("[apple, apple, banana, banana]", pair.toString());
    }

    @Test
    void setByIndex() {
        PairString pair = new PairString();
        pair.add("apple");
        pair.setByIndex("banana", 0);

        assertEquals("[banana, banana]", pair.toString());
    }

    @Test
    void addCollectionByIndex() {
        PairString pair1 = new PairString();
        PairString pair2 = new PairString();
        pair1.add("apple");
        pair1.setByIndex("banana", 0);

        pair2.add("pineapple");
        pair1.addCollectionByIndex(pair2, 2);

        assertEquals("[banana, banana, pineapple, pineapple]", pair1.toString());
    }

    @Test
    void getSize() {
        PairString pair = new PairString();
        pair.add("apple");
        pair.addByIndex("banana", 1);

        assertEquals(4, pair.getSize());
    }

    @Test
    void getByIndex() {
        PairString pair = new PairString();
        pair.add("apple");
        pair.addByIndex("banana", 0);

        assertEquals("apple apple", pair.getByIndex(2));
    }
}