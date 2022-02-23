package ua.advanced.practice3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class IntSortSetTest {

    @Test
    void addCollection() {
        IntSortSet set1 = new IntSortSet();
        IntSortSet set2 = new IntSortSet();
        int controlsum = 0;
        set1.add(4);
        set1.add(2);
        set1.add(1);

        set2.add(1);
        set2.add(2);
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            controlsum += iterator.next();
        }

        iterator = set2.iterator();
        while (iterator.hasNext()) {
            controlsum += iterator.next();
        }
        assertEquals(10, controlsum);
    }

    @Test
    void add() {
        IntSortSet set = new IntSortSet();
        set.add(4);
        set.add(2);
        set.add(1);
        assertEquals(3, set.size());
    }

    @Test
    void remove() {
        IntSortSet set = new IntSortSet();
        set.add(4);
        set.add(2);
        set.add(1);
        assertEquals(true, set.remove(2));
        assertEquals(false, set.remove(8));
    }

    @Test
    void search() {
        IntSortSet set = new IntSortSet();
        set.add(4);
        set.add(2);
        set.add(1);
        assertEquals(2, set.search(2));
        assertEquals(null, set.search(8));
    }

    @Test
    void size() {
        IntSortSet set = new IntSortSet();
        set.add(4);
        set.add(2);
        set.add(1);
        assertEquals(3, set.size());
    }

    @Test
    void iterator() {
        IntSortSet set = new IntSortSet();
        int controlsum = 0;
        set.add(4);
        set.add(2);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            controlsum += iterator.next();
        }
        assertEquals(7, controlsum);
    }
}