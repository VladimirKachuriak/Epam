package ua.advanced.practice1.task2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
    Object[] arr = new Object[0];
    int current = -1;

    @Override
    public void add(Object element) {
        if (current + 1 >= arr.length) {
            arr = Arrays.copyOf(arr, arr.length + 1);
        }
        arr[++current] = element;
    }

    @Override
    public void set(int index, Object element) {
        if (index < 0 || index > arr.length - 1) throw new NoSuchElementException();
        arr[index] = element;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > arr.length - 1) throw new NoSuchElementException();
        return arr[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > arr.length - 1) throw new NoSuchElementException();
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr = Arrays.copyOf(arr, arr.length - 1);
    }

    @Override
    public void clear() {
        arr = new Object[0];
        current = -1;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("C");

        array.remove(2);
        System.out.println(array);
        for (Object obj : array) {
            System.out.print(obj + " ");
        }

        array.set(0, "D");
        System.out.println("\n" + array.get(0));
        System.out.println("index of object 'B' = " + array.indexOf("B"));
        array.clear();
        System.out.println("size of cleared array = " + array.size());

        System.out.println("////////////////");
        array.add("D");
        array.add("E");
        array.add("Q");
        Iterator<Object> iter = array.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
    }

    class IteratorImpl implements Iterator<Object> {
        private int counter = -1;

        @Override
        public boolean hasNext() {
            return counter + 1 < arr.length;
        }

        @Override
        public Object next() {
            return arr[++counter];
        }

        @Override
        public void remove() {
            ArrayImpl.this.remove(++counter);
        }
    }
}
