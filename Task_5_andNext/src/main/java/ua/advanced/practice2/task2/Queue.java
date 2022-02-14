package ua.advanced.practice2.task2;

import ua.advanced.practice1.task2.Container;

public interface Queue extends Container {

    // Appends the specified element to the end.
    void enqueue(Object element);

    // Removes the head.
    Object dequeue();

    // Returns the head.
    Object top();


}
