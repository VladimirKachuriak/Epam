package ua.advanced.practice3;


import java.util.*;

public class IntStringCappedMap implements Iterable<String> {
    private Node head = null;
    private final int maxSize;

    public static void main(String[] args) {
        IntStringCappedMap map = new IntStringCappedMap(25);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");
        for (Object el : map) {
            System.out.println(el);
        }
    }

    public IntStringCappedMap(int maxSize) {
        this.maxSize = maxSize;
    }

    public AbstractSet entrySet() {
        return new AbstractSet() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator() {
                    private Node node = head;

                    @Override
                    public boolean hasNext() {
                        return node != null;
                    }

                    @Override
                    public String next() {
                        Node prev = node;
                        node = node.next;
                        return prev.value;
                    }
                };
            }

            @Override
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
        };
    }

    public int size() {
        return entrySet().size();
    }

    public void put(int i, String one) {
        if (one.length() > maxSize) throw new IllegalArgumentException();
        while (sumOfValue() + (one).length() > maxSize) {
            deleteOld();
        }
        if (head == null) {
            head = new Node(i, one, null);
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = new Node(i, one, null);
        }
    }

    public Object get(int element) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            if (element == node.key) return node.value;
            node = node.next;
        }
        return null;
    }

    public boolean remove(Integer key) {
        if (head == null) return false;
        if (key.equals(head.key)) {
            head = head.next;
            return true;
        }
        Node node = head;
        Node prev = null;

        while (node != null) {
            if (key.equals(node.key)) {
                prev.next = node.next;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    private void deleteOld() {
        if (head == null) return;
        head = head.next;
    }

    private int sumOfValue() {
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter += temp.value.length();
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public Iterator<String> iterator() {
        return entrySet().iterator();
    }

    public static class Node {
        private int key;
        private String value;
        private Node next;

        public Node(int key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
