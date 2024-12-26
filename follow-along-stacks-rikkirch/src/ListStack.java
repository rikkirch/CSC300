import java.util.Iterator;

public class ListStack<T> implements IStack<T>{
    private GenericList<T> list;

    public ListStack(){
list = new GenericList<>();
    }

    public void push(T item) {
list.addToFront(item);
    }

    public T pop() {
T item = list.getFront();
list.removeFront();
        return item;
    }

    public T peek() {
        return list.getFront();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();;
    }
}
