/* Warning: Do not modify this file!! */
import java.util.NoSuchElementException;

/**
 * This file describes the interface that will be implemented by any type implementing a FIFO ordered queue.
 * @param <T> The type of data that the queue will store
 */
public interface IQueue<T> {
    /**
     * Inserts a new item into the queue
     * @param data The data that is to be inserted into the queue
     */
    void push(T data);

    /**
     * Retrieves the front element from the queue and removes it from the front of the queue
     * @return The data found at the start of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T pop() throws NoSuchElementException;

    /**
     * Retreives the front element from the queue
     * @return The data found at the start of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T peek() throws NoSuchElementException;

    /**
     * returns the size of the queue
     * @return the size of the queue
     */
    int size();

    /**
     * Indicates if the queue is empty or not
     * @return true if the queue is empty, otherwise false
     */
    boolean isEmpty();
}
