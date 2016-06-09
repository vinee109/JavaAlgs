package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * list.Queue.java
 *
 * Created by Vineet Jain on 6/8/16.
 *
 * The Queue class implements a First In First Out (FIFO). It supports
 * enqueue and dequeue operations.
 */

public class Queue<T> implements Iterable<T>{

    private DoublyLinkedList<T> list;

    public Queue() {
        list = new DoublyLinkedList<>();
    }

    /**
     * Enqueues an item to back of the queue.
     * @param item the item to be enqueued
     * @throws NullPointerException if item is null
     */
    public void enqueue(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        list.insertFront(item);
    }

    /**
     * Dequeues an item from the front of the queue.
     * @return the item that was dequeued
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeEnd();
    }

    /**
     * Returns the number of items currently in the queue.
     * @return the number of items currently in the queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns whether this queue is empty or not.
     * @return true if the queue is emtpy, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * String representation of the queue
     * @return a string representation of the items in this queue
     */
    public String toString() {
        return list.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
