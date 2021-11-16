package com.company;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import static com.company.Task1.SortEnum;

import static com.company.Task1.isSorted;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;


public class TaskTest {

    @Test
    public void prograssionTask3() {
        assertEquals("All right", 104720, Task3.progression(5, 3, 5));
        assertEquals("All right", 6160, Task3.progression(5, 3, 4));

    }

    @Test
    public void prograssionTask4() {
        assertEquals("In task4 all okay", 175.0, Task4.progression(100, 0.5f, 20), 0.0);
        assertEquals("In task4 all okay", 29.399999618530273, Task4.progression(15, 0.6f, 4), 0.0);
        assertEquals("In task4 all okay", 5.0, Task4.progression(5, 0.1f, 3), 0.0);
    }

    @Test
    public void Task2Test() {
        int[] a = {1, 2, 3};
        Task2.transform(a, SortEnum.ASC);
        assertArrayEquals("All right in task 2", new int[]{1, 3, 5}, a);
        a = new int[]{3, 2, 1};
        Task2.transform(a, SortEnum.DESC);
        assertArrayEquals("All right in task 2", new int[]{3, 3, 3}, a);
    }


    @Test
    public void Task1Test() {

        assertEquals("In task 1 all okay", true, Task1.isSorted(new int[]{100, 255, 888}, SortEnum.ASC));
        assertEquals("In task 1 all okay", true, Task1.isSorted(new int[]{1, 2, 3}, SortEnum.ASC));
        assertEquals("In task 1 all okay", false, Task1.isSorted(new int[]{1, 2, 3}, SortEnum.DESC));
        assertEquals("In task 1 all okay", true, Task1.isSorted(new int[]{5, 4, 1}, SortEnum.DESC));
    }

}
