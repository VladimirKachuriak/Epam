package ua.advanced.practice2.task3;

import org.junit.jupiter.api.Test;
import ua.advanced.practice2.task2.QueueImpl;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {

    @Test
    void clear() {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.clear();

        assertEquals(0,stack.size(),"Stack must be clear");
    }

    @Test
    void size() {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        stack.clear();

        assertEquals(0,stack.size(),"Stack must be clear");
    }

    @Test
    void iterator() {
        StackImpl list = new StackImpl();
        list.push("A");
        list.push("B");
        list.push("C");

        String result = "";
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            result += iter.next();
        }
        assertEquals("CBA", result, "Iteration work incorrect");
    }

    @Test
    void push() {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");


        assertEquals("[C, B, A]",stack.toString(),"Stack must be clear");
    }

    @Test
    void pop() {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");


        assertEquals("C",stack.pop(),"Incorrect pop element");
        assertEquals(2,stack.size());

    }

    @Test
    void top() {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");


        assertEquals("C",stack.top(), "Incorrect top element");
        assertEquals(3,stack.size());
    }
}