public class ListQueue<T> implements IQueue<T> {
    private GenericList<T> list;

    public ListQueue(){
	list = new GenericList<>();
    }

    public void push(T item) {
	list.addToBack(item);
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
        return list.isEmpty();
    }
}
