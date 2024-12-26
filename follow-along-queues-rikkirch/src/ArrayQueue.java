public class ArrayQueue<T> implements IQueue<T> {
    T[] arr;
    int front, back;
	int usedSlots;
    
    public ArrayQueue(){
	arr = (T[]) new Object[100];
	front = 0;
	back = 0;
	usedSlots = 0;
    }

    public void push(T item) {
	arr[back++] = item;
	usedSlots++;
    }

    public T pop() {
        T item = arr[front];
	arr[front++] = null;
	usedSlots--;
	return item;
    }

    public T peek() {
        return arr[front];
    }

    public int size() {
        return usedSlots;
    }

    public boolean isEmpty() {
        return usedSlots == 0;
    }
}
