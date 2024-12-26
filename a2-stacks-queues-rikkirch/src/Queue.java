import java.util.NoSuchElementException;

public class Queue<T> {
    private T[] dataArray;
    private int front;
    private int back;
    private int usedSlots;

    public Queue() {
        dataArray = (T[]) new Object[100];
        front = 0;
        back = 0;
        usedSlots = 0;
    }

    public void push(T data) {
        if (usedSlots == dataArray.length) {
            resize(dataArray.length * 2); // Double the array size if full
        }
        dataArray[back] = data;
        back = (back + 1) % dataArray.length; // Wrap around using modulo
        usedSlots++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = dataArray[front];
        dataArray[front] = null; // Prevent loitering
        front = (front + 1) % dataArray.length; // Wrap around using modulo
        usedSlots--;

        if (usedSlots > 0 && usedSlots == dataArray.length / 4) {
            resize(dataArray.length / 2); // Shrink if quarter-full
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return dataArray[front];
    }

    public boolean isEmpty() {
        return usedSlots == 0;
    }

    public int size() {
        return usedSlots;
    }

    public int totalCapacity() {
        return dataArray.length;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < usedSlots; i++) {
            newArray[i] = dataArray[(front + i) % dataArray.length]; // Copy elements in correct order
        }
        dataArray = newArray;
        front = 0;
        back = usedSlots;
    }
}
