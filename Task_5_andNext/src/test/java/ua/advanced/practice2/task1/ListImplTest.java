package ua.advanced.practice2.task1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ListImplTest {

    @Test
    void clear() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        assertEquals(3, list.size(), "Size must be 0");
    }

    @Test
    void size() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        assertEquals(3, list.size(), "not correct size");
    }

    @Test
    void iterator() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        String result = "";
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            result += iter.next();
        }
        assertEquals("CAB", result, "Iteration work incorrect");
    }

    @Test
    void addFirst() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        assertEquals("[C, B, A]", list.toString(), "Add first elements is incorrect");
    }

    @Test
    void addLast() {
        ListImpl list = new ListImpl();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        assertEquals("[A, B, C]", list.toString(), "Add last elements is incorrect");
    }

    @Test
    void removeFirst() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.removeFirst();
        assertEquals("[B, A]", list.toString(), "Remove first elements is incorrect");
    }

    @Test
    void removeLast() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.removeLast();
        assertEquals("[C, B]", list.toString(), "Remove last elements is incorrect");
    }

    @Test
    void getFirst() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");

        assertEquals("A", list.getLast(), "Incorrect last element");
    }

    @Test
    void getLast() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        assertEquals("B", list.getLast(), "Size must be 0");
    }

    @Test
    void search() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        assertEquals("B", list.search("B"), "Find not correct element");
    }

    @Test
    void remove() {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        list.remove("B");
        assertEquals("[C, A]", list.toString(), "remove not correct element");
    }
}