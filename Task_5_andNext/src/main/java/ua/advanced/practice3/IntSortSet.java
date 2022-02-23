package ua.advanced.practice3;

import ua.advanced.practice2.task1.ListImpl;

import java.util.Iterator;

public class IntSortSet implements Iterable<Integer> {
    private Node head = null;

    public static void main(String[] args) {
        IntSortSet set = new IntSortSet();
        set.add(5);
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(7);
        set.add(-6);
        IntSortSet set2 = new IntSortSet();
        set2.add(5);
        set2.add(2);
        for (int e : set) {
            System.out.print(e+" ");
        }
    }

    public void addCollection(IntSortSet set) {
        for (int e : set) {
            add(e);
        }
    }

    public boolean add(int value) {
      /*  Node current = head;
        Node prev = head;
        if (head == null) {
            head = new Node(value, null);
            return true;
        }
        if (head.value > value) {
            head = new Node(value, head);
            return true;
        }
        while (current != null) {
            if (value < current.value) {
                prev.next = new Node(value, current);
                return true;
            }
            prev = current;
            current = current.next;
        }
        prev.next = new Node(value, null);
        return true;*/
                Node current = head;

        if (head == null) {
            head = new Node(value, null);
            return true;
        }
        if (head.value > value) {
            head = new Node(value, head);
            return true;
        }
        while (current.next != null) {
            if (value < current.next.value) {
                current.next = new Node(value, current.next);
                return true;
            }
            current = current.next;
        }
        current.next = new Node(value, null);
        return true;
    }

    public boolean remove(Integer element) {
        if (head == null) return false;
        if (element.equals(head.value)) {
            head = head.next;
            return true;
        }
        Node node = head;
        Node prev = null;

        while (node != null) {
            if (element.equals(node.value)) {
                prev.next = node.next;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public Integer search(Integer element) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            if (element.equals(node.value)) return node.value;
            node = node.next;
        }
        return null;
    }

    public int size() {
        if (head == null) return 0;
        int counter = 1;
        Node node = head;
        while (node.next != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }


    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Integer> {
        private Node node = head;
        private Node prev;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Integer next() {
            prev = node;
            node = node.next;
            return prev.value;
        }

        @Override
        public void remove() {
            prev = node.next;
            node = node.next;
        }
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
