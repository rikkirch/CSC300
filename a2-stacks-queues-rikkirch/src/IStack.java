/* Warning: Do not modify this file!! */
import java.util.NoSuchElementException;

/**
 * This file describes the interface that will be implemented by any type implementing a LIFO ordered stack.
 * @param <T> The type of data that the stack will store
 */
public interface IStack<T> {

    /**
     * Inserts a new item into the stack
     * @param data The data that is to be inserted into the stack
     */
    void push(T data);

    /**
     * Retreives the front element from the stack and removes it from the front of the stack
     * @return The data found at the start of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    T pop() throws NoSuchElementException;

    /**
     * Retreives the front element from the stack
     * @return The data foundat the start of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    T peek() throws NoSuchElementException;

    /**
     * returns the size of the stack
     * @return the size of the stack
     */
    int size();

    /**
     * Indicates if the stack is empty or not
     * @return true if the stack is empty, otherwise false
     */
    boolean isEmpty();
}
