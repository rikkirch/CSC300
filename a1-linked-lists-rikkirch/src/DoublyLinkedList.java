import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<T> implements ILinkedList<T>, Iterable<T> {
    private Node<T> front;
    private Node<T> back;
    private int len;

    // Node class representing each element in the doubly linked list
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> getNodeAtPosition(int pos) throws NoSuchElementException {
        if (pos < 0 || pos >= len) {
            throw new NoSuchElementException("Requested position greater than length of list");
        }
        Node<T> current = front;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    public void insertFront(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        len++;
    }

    public void insertBack(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            newNode.prev = back;
            back = newNode;
        }
        len++;
    }

    public void insertAt(T item, int position) throws NoSuchElementException {
        if (position < 0 || position > len) {
            throw new NoSuchElementException("Position out of bounds");
        }
        if (position == 0) {
            insertFront(item);
        } else if (position == len) {
            insertBack(item);
        } else {
            Node<T> newNode = new Node<>(item);
            Node<T> prevNode = getNodeAtPosition(position - 1);
            Node<T> nextNode = prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            len++;
        }
    }

    public T getFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return front.data;
    }

    public T getBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return back.data;
    }

    public T getAt(int position) throws NoSuchElementException {
        if (position < 0 || position >= len) {
            throw new NoSuchElementException("Position does not exist in the list");
        }
        return getNodeAtPosition(position).data;
    }

    public void removeFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (len == 1) {
            front = null;
            back = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        len--;
    }

    public void removeBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (len == 1) {
            front = null;
            back = null;
        } else {
            back = back.prev;
            back.next = null;
        }
        len--;
    }

    public void removeAt(int position) throws NoSuchElementException {
        if (position < 0 || position >= len) {
            throw new NoSuchElementException("Position out of bounds");
        }
        if (position == 0) {
            removeFront();
        } else if (position == len - 1) {
            removeBack();
        } else {
            Node<T> toRemove = getNodeAtPosition(position);
            Node<T> prevNode = toRemove.prev;
            Node<T> nextNode = toRemove.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            len--;
        }
    }

    public int len() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public void print() {
        StdOut.print("front -> ");
        Node<T> current = front;
        while (current != null) {
            StdOut.print(current.data + " -> ");
            current = current.next;
        }
        StdOut.println("back");
    }

    public void printReverse() {
        StdOut.print("back -> ");
        Node<T> current = back;
        while (current != null) {
            StdOut.print(current.data + " -> ");
            current = current.prev;
        }
        StdOut.println("front");
    }

    public void printDataAt(int position) {
        if (position < 0 || position >= len) {
            throw new NoSuchElementException("Position is greater than the length of the list");
        }
        StdOut.println(getAt(position));
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(front);
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        // Test code can be written here if needed.
    }
}
