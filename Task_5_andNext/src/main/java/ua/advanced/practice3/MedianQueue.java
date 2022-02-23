package ua.advanced.practice3;


import java.util.Iterator;

public class MedianQueue implements Iterable<Integer>{
    private Node head = null;

    public static void main(String[] args) {
        MedianQueue queue = new MedianQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(3);
        System.out.println(queue.peek());
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

    public int peek() {
        int arr[] = new int[size()];
        Node current = head;
        for (int i = 0; i < arr.length; i++, current = current.next) {
            arr[i] = current.value;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr[size() / 2];
    }

    public int poll() {
        int result = peek();
        remove(result);
        return result;
    }

    private boolean remove(Object element) {
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

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }


    public void offer(int element) {
        if (head == null) {
            head = new Node(element, null);
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = new Node(element, null);
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            result.append(node.value);
            node = node.next;
            if (node != null) {
                result.append(", ");
                if (node.next == null) {
                    result.append(node.value).append("]");
                    return result.toString();
                }
            } else {
                result.append("]");
                return result.toString();
            }
        }
        result.append("]");
        return result.toString();
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

        public Object getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
