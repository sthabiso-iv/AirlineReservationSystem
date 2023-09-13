/**
  *
  * @author (32465092 MSM Dhlamini)
  * @version (8 September 2023)
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head, tail;
 
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (head == null) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void prepend(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;

        if (tail == null)
            tail = head;
    }

    public void append(E item) {
        Node<E> newNode = new Node<>(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E temp = head.element;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> ptr = head;

        while (ptr != null) {
            result.append(ptr.element);
            ptr = ptr.next;
            if (ptr != null) {
                result.append(",");
            }
        }

        result.append("]");
        return result.toString();
    }

    public void clear() {
        head = tail = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            E data = current.element;
            current = current.next;
            return data;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
            next = null;
        }
    }
}
