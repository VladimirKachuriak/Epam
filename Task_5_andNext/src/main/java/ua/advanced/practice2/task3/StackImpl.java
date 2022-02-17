package ua.advanced.practice2.task3;

import java.util.Iterator;

public class StackImpl implements Stack {
    private Node head;

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        System.out.println(stack);
        Iterator<Object> iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.printf(iter.next().toString());
        }
    }

    @Override
    public void clear() {
        head = null;
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

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void push(Object element) {
        head = new Node(element, head);
    }

    @Override
    public Object pop() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp.value;
        } else {
            return null;
        }
    }

    @Override
    public Object top() {
        if (head != null) {
            return head.value;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            result.append(node.value.toString());
            node = node.next;
            if (node != null) {
                result.append(", ");
                if (node.next == null) {
                    result.append(node.value + "]");
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

    class IteratorImpl implements Iterator<Object> {
        private Node node = head;
        private Node prev;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
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
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }


        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
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
