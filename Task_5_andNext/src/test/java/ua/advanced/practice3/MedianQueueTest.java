package ua.advanced.practice3;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MedianQueueTest {

    @Test
    void size() {
        MedianQueue medianQueue = new MedianQueue();
        medianQueue.offer(987);
        medianQueue.offer(4);
        medianQueue.offer(2);
        medianQueue.offer(3);

        assertEquals(4, medianQueue.size());
    }

    @Test
    void peek() {
        MedianQueue medianQueue = new MedianQueue();
        medianQueue.offer(987);
        medianQueue.offer(4);
        medianQueue.offer(2);
        medianQueue.offer(3);

        assertEquals(3, medianQueue.peek());
        assertEquals(4, medianQueue.size());
    }

    @Test
    void poll() {
        MedianQueue medianQueue = new MedianQueue();
        medianQueue.offer(987);
        medianQueue.offer(4);
        medianQueue.offer(2);
        medianQueue.offer(3);

        assertEquals(3, medianQueue.poll());
        assertEquals(3, medianQueue.size());
    }

    @Test
    void iterator() {
        MedianQueue medianQueue = new MedianQueue();
        medianQueue.offer(987);
        medianQueue.offer(4);
        medianQueue.offer(2);
        medianQueue.offer(3);

        int controlSum = 0;
        Iterator<Integer> iterator = medianQueue.iterator();
        while (iterator.hasNext()) {
            controlSum += iterator.next();
        }

        assertEquals(996, controlSum);
    }

    @Test
    void offer() {
        MedianQueue medianQueue = new MedianQueue();
        medianQueue.offer(987);
        medianQueue.offer(4);
        medianQueue.offer(2);
        medianQueue.offer(3);

        int controlSum = 0;
        Iterator<Integer> iterator = medianQueue.iterator();
        while (iterator.hasNext()) {
            controlSum += iterator.next();
        }

        assertEquals(996, controlSum);
        assertEquals(4, medianQueue.size());
    }
}