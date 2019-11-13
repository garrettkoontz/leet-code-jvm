package com.k00ntz.datastructures;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements List<T> {

    private final ListNode<T> listHead;

    private static class ListNode<T> {
        T value;
        ListNode<T> next = null;

        ListNode(T value) {
            this.value = value;
        }

        ListNode(T value, ListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }

        T remove(ListNode<T> previous) {
            previous.next = this.next;
            return this.value;
        }

        ListNode<T> removeHead() {
            if (this.next == null) {
                throw new IndexOutOfBoundsException();
            }
            return this.next;
        }
    }


    public SinglyLinkedList() {
        this.listHead = new ListNode<>(null);
    }

    @Override
    public int size() {
        int i = 0;
        ListNode node = this.listHead.next;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return listHead.next == null;
    }

    @Override
    public boolean contains(Object o) {
        ListNode node = this.listHead.next;
        while (node != null) {
            if (node.value.equals(o)) return true;
            node = node.next;
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> previousNode = listHead;
            private ListNode<T> thisNode = listHead.next;

            @Override
            public boolean hasNext() {
                return thisNode != null;
            }

            @Override
            public T next() {
                previousNode = thisNode;
                thisNode = thisNode.next;
                return previousNode.value;
            }

            @Override
            public void remove() {
                if (thisNode != null)
                    thisNode.remove(previousNode);
                else
                    previousNode.next = null;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        ListNode<T> node = listHead.next;
        while (node != null) {
            action.accept(node.value);
            node = node.next;
        }

    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] objs = new Object[16];
        return toArray(objs);
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        int i = 0;
        ListNode<T> node = listHead.next;
        while (node != null) {
            if (a.length == i) {
                a = Arrays.copyOf(a, a.length * 2);
            }
            a[i++] = (T1) node.value;
            node = node.next;
        }
        return Arrays.copyOf(a, i);
    }

    @Override
    public boolean add(T t) {
        listHead.next = new ListNode<>(t, listHead.next);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListNode<T> node = listHead.next;
        ListNode<T> previous = listHead;
        while (node != null) {
            if (node.value.equals(o)) {
                node.remove(previous);
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        if (c.isEmpty()) return true;
        Set<?> containingSet = new HashSet<>(c);
        ListNode<T> node = listHead.next;
        while (node != null) {
            containingSet.remove(node.value);
            node = node.next;
        }
        return containingSet.isEmpty();
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        if (c.isEmpty()) return false;
        for (T e : c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> c) {
        ListNode<T> node = getListNodeAt(index);
        ListNode<T> oldNext = node.next;
        for (T t : c) {
            node.next = new ListNode<>((T) c);
            node = node.next;
        }
        node.next = oldNext;
        return true;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        if (c.isEmpty()) return false;
        boolean anyRemoved = false;
        Set<?> collection = new HashSet<>(c);
        ListNode<T> node = listHead.next;
        ListNode<T> previous = listHead;
        while (node != null) {
            if (collection.contains(node.value)) {
                node.remove(previous);
                anyRemoved = true;
            }
            previous = node;
            node = node.next;
        }
        return anyRemoved;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        if (c.isEmpty()) {
            listHead.next = null;
            return true;
        }
        boolean anyRemoved = false;
        Set<?> collection = new HashSet<>(c);
        ListNode<T> node = listHead.next;
        ListNode<T> previous = listHead;
        while (node != null) {
            if (!collection.contains(node.value)) {
                node.remove(previous);
                anyRemoved = true;
            }
            previous = node;
            node = node.next;
        }
        return anyRemoved;
    }

    @Override
    public void clear() {
        listHead.next = null;
    }

    @Override
    public T get(int index) {
        return getListNodeAt(index).value;
    }

    @Override
    public T set(int index, T element) {
        ListNode<T> node = getListNodeAt(index);
        T oldElem = node.value;
        node.value = element;
        return oldElem;
    }

    private ListNode<T> getListNodeAt(int index) {
        int i = -1;
        ListNode<T> node = listHead.next;
        while (++i < index && node != null) {
            node = node.next;
        }
        if (i < index) throw new IndexOutOfBoundsException(index + " > " + i);
        return node;
    }

    @Override
    public void add(int index, T element) {
        ListNode<T> node = getListNodeAt(index);
        node.next = new ListNode<>(element, node.next);
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            listHead.next = listHead.next.next;
        }
        ListNode<T> node = getListNodeAt(index - 1);
        return node.next.remove(node);
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        ListNode<T> node = listHead.next;
        while (node != null) {
            if (node.value.equals(o)) {
                return i;
            }
            i++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = 0;
        int found = -1;
        ListNode<T> node = listHead.next;
        while (node != null) {
            if (node.value.equals(o)) {
                found = i;
            }
            i++;
            node = node.next;
        }
        return found;
    }

    private class SinglyLinkedListListIterator implements ListIterator<T> {

        ListNode<T> next = listHead.next;
        ListNode<ListNode<T>> previous = new ListNode<>(null);
        int nextIndex = 0;
        int previousIndex = -1;

        public SinglyLinkedListListIterator() {
        }

        public SinglyLinkedListListIterator(ListNode<T> next, ListNode<ListNode<T>> previous, int nextIndex, int previousIndex) {
            this.next = next;
            this.previous = previous;
            this.nextIndex = nextIndex;
            this.previousIndex = previousIndex;
        }


        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T returnVal = next.value;
            nextIndex++;
            previousIndex++;
            previous = new ListNode<>(next, previous);
            next = next.next;
            return returnVal;
        }

        @Override
        public boolean hasPrevious() {
            return previous.value != null;
        }

        @Override
        public T previous() {
            T returnVal = previous.value.value;
            nextIndex--;
            previousIndex--;
            next = next.next;
            previous = previous.next;
            return returnVal;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return previousIndex;
        }

        @Override
        public void remove() {
            previous.value.remove(previous.next.value);
            nextIndex--;
            previousIndex--;
        }

        @Override
        public void set(T t) {
            ListNode<T> newValue = new ListNode<>(t, next);
            previous.next.value.setNext(newValue);
            previous.removeHead();
            previous = new ListNode<>(newValue, previous);
        }

        @Override
        public void add(T t) {
            ListNode<T> newValue = new ListNode<>(t, next);
            previous.next.value.setNext(newValue);
            previous = new ListNode<>(newValue, previous);
            previousIndex++;
            nextIndex++;
        }
    }


    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        return new SinglyLinkedListListIterator();
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        SinglyLinkedListListIterator iterator = new SinglyLinkedListListIterator();
        int i = 0;
        while (i++ < index) {
            if (iterator.hasNext()) {
                iterator.next();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return iterator;
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void reverse() {
        if (listHead.next == null) return;
        ListNode<T> current = listHead.next;
        ListNode<T> next = current.next;
        current.next = null;
        while (next != null) {
            ListNode<T> temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        listHead.next = current;
    }

    public void reverseSubset(int fromInclusive, int toExclusive) {

    }
}
