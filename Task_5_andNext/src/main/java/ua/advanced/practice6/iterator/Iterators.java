package ua.advanced.practice6.iterator;

import ua.advanced.practice6.MyLogger;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;

public class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        MyLogger.logger.log(Level.CONFIG,"Start  intArrayTwoTimesIterator iterator");
        return new Iterator<Integer>() {
            int counter =0;
            @Override
            public boolean hasNext() {
                return counter<array.length*2;
            }

            @Override
            public Integer next() {
                if(!hasNext())throw new NoSuchElementException();
                int a = array[counter/2];
                counter++;
                return a;
            }
        };
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        MyLogger.logger.log(Level.CONFIG,"Start  intArrayThreeTimesIterator iterator");
        return new Iterator<Integer>() {
            int counter =0;
            @Override
            public boolean hasNext() {
                return counter<array.length*3;
            }

            @Override
            public Integer next() {
                if(!hasNext())throw new NoSuchElementException();
                int a = array[counter/3];
                counter++;
                return a;
            }
        };
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        MyLogger.logger.log(Level.CONFIG,"Start  intArrayFiveTimesIterator iterator");
        return new Iterator<Integer>() {
            int counter =0;
            @Override
            public boolean hasNext() {
                return counter<array.length*5;
            }

            @Override
            public Integer next() {
                if(!hasNext())throw new NoSuchElementException();
                int a = array[counter/5];
                counter++;
                return a;
            }
        };
        }

    public static Iterable<String> table(String[] columns, int[] rows){
        MyLogger.logger.log(Level.CONFIG,"Start  table iterator");
        return () -> new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<columns.length*rows.length;
            }

            @Override
            public String next() {
                String result = columns[index/rows.length]+rows[index%rows.length];
                index++;
                return result;
            }
        };
    }



}
