package ua.advanced.practice2.task1;

import java.util.Iterator;

public class ListImpl implements List {
    private Node head = null;

    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addFirst("A");
        list.addFirst("B");
        //list.addFirst("C");
        System.out.println(list.remove(""));
        System.out.println(list);
        System.out.println("///////////////////");
        for (Object obj: list) {
            System.out.println(obj);
        }
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {
        if(head == null)return 0;
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
    public void addFirst(Object element) {
        head = new Node(element, head);
    }

    @Override
    public void addLast(Object element) {
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
    public void removeFirst() {
        if(head !=null ){
            head = head.next;
        }
    }

    @Override
    public void removeLast() {
        Node node = head;
        Node prev = null;
        while (node.next != null) {
            prev = node;
            node = node.next;
        }
        if(prev == null){
            head = null;
        }else {
            prev.next = null;
        }
    }

    @Override
    public Object getFirst() {
        if(head !=null ){
            return head.value;
        }else {
            return null;
        }
    }

    @Override
    public Object getLast() {
        if(head == null)return null;
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public Object search(Object element) {
        if(head == null)return null;
        Node node = head;
        if(element.equals(node.value))return node.value;
        while (node.next != null) {
            if(element.equals(node.value))return node.value;
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if(head == null)return false;
        if(element.equals(head.value)){
            head = head.next;
            return true;
        }
        Node node = head;
        Node prev = null;

        while (node != null) {
            if(element.equals(node.value)){
                prev.next = node.next;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
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
            if(node == null)return false;
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
            prev=node.next;
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
