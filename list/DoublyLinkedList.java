package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * list.DoublyLinkedList.java
 *
 * Created by Vineet Jain on 6/8/16.
 *
 * The DoublyLinkedList class implements a Doubly Linked List using a sentinel
 * node. In this data structure, nodes can traversed in either direction. Every
 * node maintains a reference to the node directly after it as well as the node
 * directly before it
 */
public class DoublyLinkedList<T> extends LinkedList<T> {
    private Node<T> sentinel;

    public DoublyLinkedList() {
        sentinel = new Node<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Inserts an item at the head of the linked list.
     * @param item the item to be inserted
     * @throws NullPointerException if item is null
     */
    public void insertFront(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<T> node = new Node<T>(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    /**
     * Inserts an item at the end of the linked list.
     * @param item the item to be inserted
     * @throws NullPointerException if item is null
     */
    public void insertEnd(T item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<T> node = new Node<T>(sentinel.prev, item, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    /**
     * Removes the item at the head of the linked list.
     * @return the item that was removed
     * @throws NoSuchElementException if the linked list is empty
     */
    public T removeFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    /**
     * Removes the item at the end of the linked list
     * @return the item that was removed
     * @throws NoSuchElementException if the linked list is empty
     */
    public T removeEnd() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    /**
     * Returns a string representation of this linked list.
     * @return a string representation of this linked list
     */
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        for (T item: this) {
            joiner.add(item.toString());
        }
        return "[ " + joiner.toString() + " ]";
    }

    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(sentinel, sentinel.next);
    }

    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T item;

        public Node() {
            item = null;
            next = null;
            prev = null;
        }

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private class DoublyLinkedListIterator<T> implements Iterator<T> {
        private Node<T> sentinel;
        private Node<T> current;

        public DoublyLinkedListIterator(Node<T> sentinel, Node<T> current) {
            this.sentinel = sentinel;
            this.current = current;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != sentinel;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
