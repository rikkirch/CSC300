import java.util.Iterator;

public class ArrayStack<T> implements IStack<T> {
    T[] arr;
    int top;

    public ArrayStack(){
	arr = (T[]) new Object[100];
	top = 0;
    }

    public void push(T item) {
	arr[top] = item;
	top++;
    }

    public T pop() {
	--top;
	T item = arr[top];
	arr[top] = null'
        return item;
    }

    public T peek() {
        return arr[top-1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        if(top == 0){
		return true;
	}

	return false;
    }

}
