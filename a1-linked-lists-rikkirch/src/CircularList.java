import java.util.NoSuchElementException;
import java.util.Iterator;

public class CircularList<T> implements ILinkedList<T>, Iterable<T> {
    private Node<T> front;
    private int len;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<T> getNodeAtPosition(int pos) throws NoSuchElementException {
        if (pos >= len) {
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
            front.next = front;
            front.prev = front;
        } else {
            Node<T> back = front.prev;
            newNode.next = front;
            newNode.prev = back;
            front.prev = newNode;
            back.next = newNode;
            front = newNode;
        }
        len++;
    }

    public void insertBack(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            front.next = front;
            front.prev = front;
        } else {
            Node<T> back = front.prev;
            newNode.next = front;
            newNode.prev = back;
            back.next = newNode;
            front.prev = newNode;
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
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
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
        return front.prev.data;
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
        } else {
            Node<T> back = front.prev;
            front = front.next;
            front.prev = back;
            back.next = front;
        }
        len--;
    }

    public void removeBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (len == 1) {
            front = null;
        } else {
            Node<T> back = front.prev;
            Node<T> newBack = back.prev;
            newBack.next = front;
            front.prev = newBack;
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
        if (isEmpty()) {
            StdOut.println("back");
            return;
        }
        Node<T> current = front;
        do {
            StdOut.print(current.data + " -> ");
            current = current.next;
        } while (current != front);
        StdOut.println("back");
    }

    public void printReverse() {
        StdOut.print("back -> ");
        if (isEmpty()) {
            StdOut.println("front");
            return;
        }
        Node<T> current = front.prev;
        do {
            StdOut.print(current.data + " -> ");
            current = current.prev;
        } while (current != front.prev);
        StdOut.println("front");
    }

    public void printDataAt(int position) {
        if (position >= len) {
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
            return current != null && current.getNext() != front;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }
}
