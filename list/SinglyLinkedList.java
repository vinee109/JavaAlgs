package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * list.SinglyLinkedList.java
 *
 * Created by Vineet Jain on 6/7/16.
 *
 * The SinglyLinkedList class implements a Singly Linked List data structure,
 * where nodes can only be traversed in one direction but not in the opposite
 * direction. That is every node in the Linked List only maintains a next
 * reference to the next node in the Linked List.
 */
public class SinglyLinkedList<T> extends LinkedList<T> {

    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
        size = 0;
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
        if (head == null) {
            head = new Node<T>(item);
        } else {
            Node<T> node = new Node<T>(item, head);
            head = node;
        }
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
        if (head == null) {
            head = new Node<T>(item);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(item);
        }
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
        T item;
        if (size == 1) {
            item = head.item;
            head = null;
        } else {
            Node<T> node = head;
            head = head.next;
            node.next = null;
            item = node.item;
        }
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
        T item;
        if (size == 1) {
            item = head.item;
            head = null;
        } else {
            Node<T> node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            item = node.next.item;
            node.next = null;
        }
        size--;
        return item;
    }

    public Iterator<T> iterator() {
        return new SLinkedListIterator<T>(head);
    }

    private class Node<T> {
        T item;
        Node<T> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(T item) {
            this.item = item;
            this.next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class SLinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public SLinkedListIterator(Node<T> node) {

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
            return current.next != null;
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
