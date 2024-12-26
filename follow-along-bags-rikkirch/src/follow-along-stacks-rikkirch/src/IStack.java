/**
 * The interface to be used by any data structure claiming to implement Stack functionality. A Stack will provide the following:
 *  - Last In First Out (LIFO) data insertion and retrieval
 *
 * @param <T> The type of data that the bag will store
 */
public interface IStack<T> {

    /**
     * Pushes a new item onto the top of the stack
     * @param item The item to put on the stack
     * @requirements This method must complete in O(1) time
     */
    void push(T item);

    /**
     * Removes the top element from the stack and returns it to the caller
     * @return The data that was stored on the top of the stack
     * @throws java.util.NoSuchElementException when the stack is empty
     * @requirements This method must complete in O(1) time
     */
    T pop();

    /**
     * Returns the top element from the stack but _does not_ remove it from the stack
     * @return The data that was stored on the top of the stack
     * @throws java.util.NoSuchElementException when the stack is empty
     * @requirements This method must complete in O(1) time
     */
    T peek();

    /**
     * Returns the number of elements currently stored on the stack
     * @return An integer value indicating how many elements are on the stack
     * @requirements This method must complete in O(1) time
     */
    int size();

    /**
     * Determines whether the stack is currently empty or not
     * @return true if the stack is empty, otherwise false
     * @requirements This method must complete in O(1) time
     */
    boolean isEmpty();
}
