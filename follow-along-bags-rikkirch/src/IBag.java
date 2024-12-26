/**
 * The interface to be used by any data structure claiming to implement bag functionality. A bag will provide the following:
 *  - unordered insertion of data
 *  - unordered retreival of data
 *  - unordered iteration of data
 *
 * @param <T> The type of data that the bag will store
 *
 * @note This interface extends the Iterable interface. That indicates that any implementing type MUST implement an iterator
 */
public interface IBag<T> extends Iterable<T> {

    /**
     * Adds a new item to bag data structure
     * @param item The item that will be added
     */
    void add(T item);

    /**
     * Indicates if any data is currently stored in the bag
     * @return true if the bag contains data, otherwise false
     */
    boolean isEmpty();

    /**
     * Retreives the size of the bag
     * @return An integer indicating how many things are currently stored in the data structure
     */
    int size();
}
