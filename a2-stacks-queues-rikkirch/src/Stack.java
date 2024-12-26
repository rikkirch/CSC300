import java.util.NoSuchElementException;

public class Stack<T> {
    T[] stackArray;
    int size;

    public Stack() {
        stackArray = (T[]) new Object[100];
        size = 0;
    }

    public void push(T data) {
        stackArray[size++] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = stackArray[--size];
        stackArray[size] = null;

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackArray[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
