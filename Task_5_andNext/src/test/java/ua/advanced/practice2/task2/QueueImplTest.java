package ua.advanced.practice2.task2;

import org.junit.jupiter.api.Test;
import ua.advanced.practice2.task1.ListImpl;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    @Test
    void clear() {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        queue.clear();

        assertEquals(0, queue.size(), "Queue must be clear");
    }

    @Test
    void size() {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals(3, queue.size(), "Queue size is incorrect");
    }

    @Test
    void iterator() {
        QueueImpl list = new QueueImpl();
        list.enqueue("A");
        list.enqueue("B");
        list.enqueue("C");

        String result = "";
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            result += iter.next();
        }
        assertEquals("ABC", result, "Iteration work incorrect");
    }

    @Test
    void enqueue() {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("[A, B, C]", queue.toString(), "enqueue work incorrect");
    }

    @Test
    void dequeue() {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.dequeue(), "Queue must be clear");
        assertEquals(2, queue.size(), "Queue size is incorrect");
    }

    @Test
    void top() {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        assertEquals("A", queue.top(), "Queue must be clear");
        assertEquals(3, queue.size(), "Queue size is incorrect");
    }
}