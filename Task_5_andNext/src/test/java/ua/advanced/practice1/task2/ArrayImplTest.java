package ua.advanced.practice1.task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayImplTest {

    @Test
    void add() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        assertEquals(array.size(), 3);
        assertEquals("[A, B, C]", array.toString());
    }

    @Test
    void set() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.set(2, "D");
        assertEquals(array.size(), 3);
        assertEquals("[A, B, D]", array.toString());
    }

    @Test
    void get() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        assertEquals("A", array.get(0));
    }

    @Test
    void indexOf() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        assertEquals(1, array.indexOf("B"));
        assertEquals(-1, array.indexOf("D"));
    }

    @Test
    void remove() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.remove(0);
        assertEquals(2, array.size());
        assertEquals("[B, C]", array.toString());
    }

    @Test
    void clear() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");
        array.clear();
        assertEquals(0, array.size());
    }

    @Test
    void size() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");
        assertEquals(5, array.size());
    }

    @Test
    void iterator() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");

        String result = "";
        for (Object obj : array) {
            result += obj;
        }
        assertEquals("ABCDE", result);
    }

    @Test
    void testToString() {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");
        assertEquals("[A, B, C]", array.toString());
    }
}