package list;

import java.util.Iterator;

/**
 * LinkedList.java
 *
 * Created by Vineet Jain on 6/5/16.
 *
 *
 * Implements an abstract class that all Linked Lists (Singly and Doubly) should
 * extend
 */
public abstract class LinkedList<T> implements Iterable<T>{
    protected int size;

    /**
     * Returns the number of elements in this Linked List
     * @return the number of elements in this Linked List
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether this Linked List is empty or not
     * @return true if this Linked List is empty, false otherwise
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public abstract Iterator<T> iterator();

}
