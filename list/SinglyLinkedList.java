package list;

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

    private class Node<T> {
        T item;
        Node<T> next;

        public Node() {
            item = null;
            next = null;
        }
    }
}
