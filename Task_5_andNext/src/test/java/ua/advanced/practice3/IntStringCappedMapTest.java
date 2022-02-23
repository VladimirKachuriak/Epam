package ua.advanced.practice3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IntStringCappedMapTest {

    @Test
    void size() {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");

        assertEquals(3, map.size());
    }

    @Test
    void put() {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");

        assertEquals(3, map.size());
    }

    @Test
    void get() {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");

        assertEquals("Six", map.get(6));
    }

    @Test
    void remove() {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");

        assertEquals(true, map.remove(6));
        assertEquals(false, map.remove(6));
    }

    @Test
    void iterator() {
        IntStringCappedMap map = new IntStringCappedMap(25);
        StringBuilder result = new StringBuilder();
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");

        Iterator iterator = map.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next()+" ");
        }

        assertEquals("Seven Eight Twelve Nine One ",result.toString());
    }
}