package ua.advanced.practice2.task2;

import ua.advanced.practice2.task1.ListImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QueueImpl implements Queue {
    Node head;

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.dequeue());
        System.out.println(queue);
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
        return null;
    }

    @Override
    public void enqueue(Object element) {
        if (head == null) {
            head = new Node(element, null);
        }else {
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }
            prev.next = new Node(element, null);
        }
    }

    @Override
    public Object dequeue() {
        if(head !=null ){
            Node temp = head;
            head = head.next;
            return temp.value;
        }else {
            return null;
        }
    }

    @Override
    public Object top() {
        if(head == null)return null;
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = head;
        while (node != null){
            result.append(node.value.toString());
            node = node.next;
            if(node !=null) {
                result.append(", ");
                if (node.next == null) {
                    result.append(node.value + "]");
                    return result.toString();
                }
            }else {
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
            return node.next != null;
        }

        @Override
        public Object next() {
            prev = node;
            node = node.next;
            return node.value;
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
