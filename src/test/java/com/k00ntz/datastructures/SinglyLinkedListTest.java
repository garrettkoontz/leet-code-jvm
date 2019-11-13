package com.k00ntz.datastructures;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void size() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        assertEquals(0, integerSinglyLinkedList.size());
        integerSinglyLinkedList.add(1);
        assertEquals(1, integerSinglyLinkedList.size());
        integerSinglyLinkedList.add(1);
        assertEquals(2, integerSinglyLinkedList.size());
        integerSinglyLinkedList.add(1);
        assertEquals(3, integerSinglyLinkedList.size());
        integerSinglyLinkedList.add(2);
        assertEquals(4, integerSinglyLinkedList.size());
        integerSinglyLinkedList.remove(1);
        assertEquals(3, integerSinglyLinkedList.size());
        integerSinglyLinkedList.remove(1);
        assertEquals(2, integerSinglyLinkedList.size());
        integerSinglyLinkedList.remove(1);
        assertEquals(1, integerSinglyLinkedList.size());
        integerSinglyLinkedList.remove(2);
        assertEquals(0, integerSinglyLinkedList.size());
    }

    @Test
    void isEmpty() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        assertTrue(integerSinglyLinkedList.isEmpty());
        integerSinglyLinkedList.add(1);
        assertFalse(integerSinglyLinkedList.isEmpty());
        integerSinglyLinkedList.add(2);
        assertFalse(integerSinglyLinkedList.isEmpty());
        integerSinglyLinkedList.remove(2);
        assertFalse(integerSinglyLinkedList.isEmpty());
        integerSinglyLinkedList.remove(1);
        assertTrue(integerSinglyLinkedList.isEmpty());
    }

    @Test
    void contains() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        integerSinglyLinkedList.add(1);
        integerSinglyLinkedList.add(2);
        integerSinglyLinkedList.add(3);
        integerSinglyLinkedList.add(1);
        assertTrue(integerSinglyLinkedList.contains(1));
        assertTrue(integerSinglyLinkedList.contains(2));
        assertTrue(integerSinglyLinkedList.contains(3));
        assertFalse(integerSinglyLinkedList.contains(4));
    }

    @Test
    void iterator() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        integerSinglyLinkedList.add(1);
        integerSinglyLinkedList.add(2);
        integerSinglyLinkedList.add(3);
        integerSinglyLinkedList.add(1);
        Iterator<Integer> iter = integerSinglyLinkedList.iterator();
        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(1, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    void add() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        assertTrue(integerSinglyLinkedList.add(1));
        assertTrue(integerSinglyLinkedList.add(1));
        assertTrue(integerSinglyLinkedList.add(1));
        assertTrue(integerSinglyLinkedList.add(2));
        assertTrue(integerSinglyLinkedList.add(-3));
        assertTrue(integerSinglyLinkedList.add(0));
        assertTrue(integerSinglyLinkedList.add(null));
    }

    @Test
    void remove() {
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        integerSinglyLinkedList.add(1);
        integerSinglyLinkedList.add(2);
        integerSinglyLinkedList.add(3);
        integerSinglyLinkedList.add(1);
        assertTrue(integerSinglyLinkedList.remove(new Integer(2)));
        assertFalse(integerSinglyLinkedList.remove(new Integer(2)));
        assertFalse(integerSinglyLinkedList.remove(new Integer(20)));
        assertTrue(integerSinglyLinkedList.remove(new Integer(1)));
        assertTrue(integerSinglyLinkedList.remove(new Integer(1)));
        assertTrue(integerSinglyLinkedList.remove(new Integer(3)));
        assertFalse(integerSinglyLinkedList.remove(new Integer(2)));
    }

    @Test
    void containsAll() {

    }

    @Test
    void addAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void removeIf() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void reverse() {
    }
}