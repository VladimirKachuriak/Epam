package ua.advanced.practice3;


import java.util.Iterator;

public class RangedOpsIntegerSet implements Iterable<Integer> {
    private Node head = null;

    public static void main(String[] args) {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        set.add(1, 15);
        set.add(1);
        set.remove(3, 12);
        for(int el : set){
            System.out.println(el);
        }
    }
    public boolean add(int fromInclusive, int toExclusive) {
        for (int i = fromInclusive; i < toExclusive; i++) {
            add(i);
        }
        return true;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        boolean flag = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            if (remove(i)) flag = true;
        }
        return flag;

    }

    public boolean add(int value) {
        if(isExist(value))return false;
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

    private boolean isExist(Integer element) {
        if(head == null)return false;
        Node node = head;
        while (node != null) {
            if(element.equals(node.value))return true;
            node = node.next;
        }
        return false;
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
