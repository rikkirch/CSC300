/******************************************************************************
 *
 * WARNING: DO NOT MODIFY THIS FILE
 *
 *******************************************************************************/

import java.util.NoSuchElementException;

/**
 * Defines the API that will be exported by any class that claims to implement a linked list data structure. Each class
 * that implements these methods will be responsible for returning the correct data type, accepting the right parameters,
 * throwing appropriate exceptions, and implementing the expected data behavior.
 *
 * @param <T> The type of data that the list will store
 */
public interface ILinkedList <T>{

    /**
     * Inserts new data at the very beginning of the list.
     * @requirements This method must execute in O(1) time
     * @param item The object that is to be stored in the list
     */
    void insertFront(T item);

    /**
     * Inserts new data at the very end of the list.
     * @requirements This method must execute in O(1) time
     * @param item The object that is to be stored in the list
     */
    void insertBack(T item);

    /**
     * This method allows you to specify a location in the list where the new data should be placed. When the list contains
     * data this will 'bump' whatever was at that position to the right. So for instance we may have the following list:
     *      front -> a -> b -> c -> d <- back
     * if we call list.insertAt(E, 0), the resulting list would look like
     *      front -> E -> a -> b -> c -> d <- back
     * if we call list.insertAt(F, 2), the resulting list would look like
     *      front -> E -> a -> F -> b -> c -> d <- back
     *
     * If the requested position does not exist in the list, then the new value will be appended to the end of the list
     *
     * @param item The object that is to be stored in the list
     * @param position The 0 indexed position into the list where the new item should be placed
     */
    void insertAt(T item, int position);

    /**
     * Returns the item found at the very front of the list
     *
     * @requirements This method must execute in O(1) time
     * @return A reference to the item at the front of the list
     * @throws NoSuchElementException when the requested position is greater then the size of the list
     */
    T getFront() throws NoSuchElementException;

    /**
     * Returns the item found at the very back of the list
     *
     * @requirements This method must execute in O(1) time
     * @return A reference to the item at the back of the list
     * @throws NoSuchElementException when the requested position is greater then the size of the list
     */
    T getBack() throws NoSuchElementException;

    /**
     * Returns the item found at the given position in the list
     *
     * @return A reference to the item at the requested position
     * @param position The 0 based position in the list from which the value should be returned
     * @throws NoSuchElementException when the requested position is greater then the size of the list
     */
    T getAt(int position) throws NoSuchElementException;

    /**
     * Removes the item found at the front of the list
     * @requirements This method must execute in O(1) time
     * @throws NoSuchElementException when if the list is empty
     */
    void removeFront() throws NoSuchElementException;

    /**
     * Removes the item found at the back of the list
     * @requirements This method must execute in O(1) time
     * @throws NoSuchElementException when if the list is empty
     */
    void removeBack() throws NoSuchElementException;

    /**
     * Removes the item found at the given position in the list
     * @param position The 0 indexed position into the list that should be removed
     * @throws NoSuchElementException if 'position' does not exist in the list
     */
    void removeAt(int position) throws NoSuchElementException;

    /**
     * Returns the length of the list
     * @requirements This method must execute in O(1) time
     * @return The length of the list
     */
    int len();

    /**
     * Checks to see if the list is empty or not
     * @requirements This method must execute in O(1) time
     * @return true if the list is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * prints the contents of the list with the same format you see below:
     *
     *      front -> i1 -> i2 -> i3 -> back
     */
    void print();

    /**
     * prints the contents of the list in reverse order with the same format you see below
     *
     *      back -> i3 -> i2 -> -1 -> front
     */
    void printReverse();

    /**
     * prints the item found at the given position in the list
     * @param position The 0 indexed position into the list
     * @throws NoSuchElementException if 'position' does not exist in the list
     */
    void printDataAt(int position) throws NoSuchElementException;
}


