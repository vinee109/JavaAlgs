package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * list.Stack.java
 *
 * Created by Vineet Jain on 6/8/16.
 *
 * The Stack class implements a Last-In First-Out (LIFO) Stack data structure.
 * It supports the push and pop operations of a stack.
 */
public class Stack<T> implements Iterable<T> {
    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    /**
     * Pushes an item onto the stack.
     * @param item the item to be pushed
     * @throws NullPointerException if item is null
     */
    public void push(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        list.add(item);
    }

    /**
     * Pops an item off the stack
     * @return the item that was popped off
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.remove(size() - 1);
    }

    /**
     * Returns the number of items in the stack
     * @return the number of items in the stack
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns whether this stack is empty or not
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString(){
        return list.toString();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
