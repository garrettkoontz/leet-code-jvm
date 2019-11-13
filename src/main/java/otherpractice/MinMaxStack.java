package otherpractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class MinMaxStack<T> {

    public MinMaxStack() {
        this.map = new TreeMap<>();
    }

    public MinMaxStack(Comparator<T> comparator) {
        this.map = new TreeMap<>(comparator);
    }

    private final LinkedList<T> linkedList = new LinkedList<>();
    private final TreeMap<T, List<Node<T>>> map;

    public void push(T t) {
        Node<T> node = linkedList.pushHead(t);
        List<Node<T>> currentList = map.getOrDefault(t, new ArrayList<>());
        currentList.add(node);
        map.put(t, currentList);
    }

    public T pop() {
        Node<T> t = linkedList.removeHead();
        List<Node<T>> currentList = map.get(t);
        currentList.remove(currentList.size() - 1);
        return t.value;
    }

    public T popMax() {
        List<Node<T>> currentList = map.lastEntry().getValue();
        Node<T> node = currentList.remove(currentList.size() - 1);
        return node.remove();
    }

    public T popMin() {
        List<Node<T>> currentList = map.firstEntry().getValue();
        Node<T> node = currentList.remove(currentList.size() - 1);
        return node.remove();
    }

    private static class LinkedList<T> {
        Node<T> head;
        Node<T> tail;

        Node<T> pushHead(T t) {
            Node<T> newNode = new Node<>(t, head, null);
            if (tail == null) {
                this.tail = newNode;
            }
            this.head = newNode;
            return newNode;
        }

        Node<T> pushTail(T t) {
            Node<T> newNode = new Node<>(t, null, tail);
            if (head == null) {
                this.head = newNode;
            }
            this.tail = newNode;
            return newNode;
        }

        Node<T> removeHead() {
            if (head == null) throw new RuntimeException();
            Node<T> returnedNode = head;
            head = head.next;
            return returnedNode;
        }

    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T t, Node<T> next, Node<T> previous) {
            value = t;
            this.next = next;
            this.previous = previous;
        }

        public T remove() {
            if (next != null) {
                this.next.previous = this.previous;
            }
            if (previous != null) {
                this.previous.next = this.next;
            }
            return this.value;
        }
    }

    public static void main(String[] args) {
        System.out.println(newIndex(0, 4));
        System.out.println(newIndex(1, 4));
        System.out.println(newIndex(2, 4));
        System.out.println(newIndex(3, 4));
        System.out.println(newIndex(4, 4));
    }

    private static int newIndex(int i, int modSize) {
        return (int) (modSize * Math.sin(2 * i * Math.PI / modSize + Math.PI));
    }
}
