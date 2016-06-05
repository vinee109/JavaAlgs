package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque.java
 *
 * Created by Vineet Jain on 6/5/16.
 *
 * Implements a double-ended queue or deque that supports adding and removing
 * items to either the head or the tail of the data structure.
 */
public class Deque<Item> implements Iterable<Item> {

    private int size;

    public Deque() {

    }

    /**
     * Returns whether the deque is empty or not
     * @return True if the deque is empty, False otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque
     * @return the number of items in the deque
     */
    public int size() {
        return size;
    }

    /**
     * Adds an item to the head of the deque.
     * @param item the item to be added
     * @throws NullPointerException if item is null
     */
    public void addFirst(Item item) throws NullPointerException{

    }

    /**
     * Adds an item to the tail of the deque.
     * @param item the item to be added
     * @throws NullPointerException if item is null
     */
    public void addLast(Item item) throws NullPointerException {

    }

    /**
     * Removes the item at the head of the deque, if possible.
     * @return the item that was removed.
     * @throws NoSuchElementException if deque is empty
     */
    public Item removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes the item at the tail of the deque, if possible. Throws
     * NoSuchElementException if the deque is empty.
     * @return the item that was removed.
     * @throws NoSuchElementException if deque is empty
     */
    public Item removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {

    }
}
