import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This file describes the interface that will be exposed by any type that is implementing a symbol table.
 * @param <Key> The type that will be used as the key for the symbol table
 * @param <Value> The type that will be stored by the symbol table
 */
public interface ISymbolTable<Key, Value> {

    /**
     * Inserts a new key/value pair into the symbol table
     * @param k The key to use
     * @param v The value that should be associated with key
     * @throws InvalidParameterException if k or v are null or if a duplicate key is found
     * @requirements This method should execute in O(log n) or better time
     */
    void put(Key k, Value v) throws InvalidParameterException;

    /**
     * retrieves a value from the symbol table
     * @param k The key for the value that should be returned
     * @return A reference to the value that is referenced by k
     * @throws NoSuchElementException if k does not exist in the table
     * @throws InvalidParameterException if k is null
     * @requirements This method should execute in O(log n) or better time
     */
    Value get(Key k) throws NoSuchElementException, InvalidParameterException;

    /**
     * Removes a key/value pair from the symbol table
     * @param k The key which should be removed from the table
     * @throws NoSuchElementException if k does not exist in the table
     * @throws InvalidParameterException if k is null
     * @requirements This method should execute in O(log n) or better time
     */
    void del(Key k) throws NoSuchElementException, InvalidParameterException;

    /**
     * Checks to see if a give key exists in the symbole table
     * @param k The key which should be searched for
     * @return true if the key is found, otherwise false
     * @throws InvalidParameterException if k is null
     */
    boolean contains(Key k) throws InvalidParameterException;

    /**
     * checks to see if the symbol table currently has any data
     * @return true if the table has no data, otherwise false
     * @requirements this method must execute in O(1) time
     */
    boolean isEmpty();

    /**
     * returns the current number of keys found in the symbol table
     * @return the integer value of keys in the table
     * @requirements this method must execute in O(1) time
     */
    int size();

    /**
     * returns a list of all keys currently found in the table
     * @return A linked list of keys that exist in the table. The list must be sorted in ascending order
     */
    LinkedList<Key> keys();
}
