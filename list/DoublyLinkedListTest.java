package list;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * list.DoublyLinkedListTest.java
 *
 * Created by Vineet Jain on 6/7/16.
 *
 * Unit Test for Singly Linked List
 */
public class DoublyLinkedListTest {

    @Test
    public void testIsEmpty() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testInsertFront() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFront(1);
        assertEquals("[ 1 ]", list.toString());
        list.insertFront(2);
        assertEquals("[ 2 1 ]", list.toString());
        list.insertFront(3);
        assertEquals("[ 3 2 1 ]", list.toString());
        list.insertFront(4);
        assertEquals("[ 4 3 2 1 ]", list.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testInsertFrontNull() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFront(null);
    }

    @Test
    public void testInsertEnd() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertEnd(1);
        assertEquals("[ 1 ]", list.toString());
        assertEquals(1, list.size());
        list.insertEnd(2);
        assertEquals("[ 1 2 ]", list.toString());
        assertEquals(2, list.size());
        list.insertEnd(3);
        assertEquals("[ 1 2 3 ]", list.toString());
        assertEquals(3, list.size());
        list.insertEnd(3);
        assertEquals("[ 1 2 3 3 ]", list.toString());
        assertEquals(4, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void testInsertEndNull() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertEnd(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFrontEmpty() throws Exception {
        DoublyLinkedList<Integer> empty = new DoublyLinkedList<>();
        empty.removeFront();
    }

    @Test
    public void testRemoveFront() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(2);
        list.insertEnd(2);
        assertEquals("[ 1 2 2 2 ]", list.toString());
        assertEquals(new Integer(1), list.removeFront());
        assertEquals(3, list.size());
        assertEquals("[ 2 2 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeFront());
        assertEquals(2, list.size());
        assertEquals("[ 2 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeFront());
        assertEquals(1, list.size());
        assertEquals("[ 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeFront());
        assertEquals(0, list.size());
        assertEquals("[  ]", list.toString());
    }

    @Test
    public void testRemoveEnd() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(2);
        list.insertEnd(2);
        assertEquals("[ 1 2 2 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeEnd());
        assertEquals(3, list.size());
        assertEquals("[ 1 2 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeEnd());
        assertEquals(2, list.size());
        assertEquals("[ 1 2 ]", list.toString());
        assertEquals(new Integer(2), list.removeEnd());
        assertEquals(1, list.size());
        assertEquals("[ 1 ]", list.toString());
        assertEquals(new Integer(1), list.removeEnd());
        assertEquals(0, list.size());
        assertEquals("[  ]", list.toString());
    }

    @Test
    public void testIterator() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        List<Integer> expected = Arrays.asList(3, 2, 1);
        int i = 0;
        for (Integer actual: list) {
            assertEquals(expected.get(i++), actual);
        }

    }

    @Test
    public void testToString() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFront(1);
        assertEquals("[ 1 ]", list.toString());
        list.insertFront(2);
        assertEquals("[ 2 1 ]", list.toString());
        list.insertFront(3);
        assertEquals("[ 3 2 1 ]", list.toString());
    }
}