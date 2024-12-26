import java.util.NoSuchElementException;

public class StackQueue<T> implements IQueue<T> {
    Stack<T> s1, s2;

    public StackQueue() {
	`s1 = new Stack<>();
	s2 = new Stack<>();
    }

    public void push(T data) {
	s1.push(data);
    }

    public T pop() throws NoSuchElementException {
        if(s2.isEmpty()){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}
	return s2.pop();
    }

    public T peek() throws NoSuchElementException {
        if(s2.isEmpty()){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
	}
	return s2.peek();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
