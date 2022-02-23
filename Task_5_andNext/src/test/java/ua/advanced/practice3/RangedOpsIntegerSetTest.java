package ua.advanced.practice3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class RangedOpsIntegerSetTest {

    @Test
    void add() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();

        assertEquals(true, set.add(5));
    }

    @Test
    void remove() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        set.add(5);
        assertEquals(true, set.remove(5));
        assertEquals(false, set.remove(2));
    }

    @Test
    void testAdd() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        int controlsum = 0;
        set.add(1, 5);
        //se = [1, 2, 3, 4]
        for (int el : set) {
            controlsum+=el;
        }
        assertEquals(10, controlsum);
    }

    @Test
    void testRemove() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        int controlsum = 0;
        set.add(1, 15);
        set.remove(3, 12);
        //set = [1, 2, 12 , 13, 14]
        for (int el : set) {
            controlsum+=el;
        }
        assertEquals(42, controlsum);
    }

    @Test
    void size() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        set.add(1, 15);
        set.remove(3, 12);
        //set = [1, 2, 12 , 13, 14]
        assertEquals(5, set.size());
    }

    @Test
    void iterator() {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        int controlsum = 0;
        set.add(1, 15);
        set.remove(3, 12);
        //set = [1, 2, 12 , 13, 14]
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            controlsum += iterator.next();
        }
        assertEquals(42, controlsum);
    }
}