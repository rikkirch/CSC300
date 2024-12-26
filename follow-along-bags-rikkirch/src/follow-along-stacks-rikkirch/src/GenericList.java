import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericList<T> implements Iterable<T>{

    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    private static class ListIterator<T> implements Iterator<T>{
        Node<T> curr;

        public ListIterator(Node<T> head){
            curr = head;
        }

        public boolean hasNext() {
            if(curr != null){
                return true;
            }
            return false;
        }

        public T next() {
            T data = curr.data;
            curr = curr.next;
            return data;
        }
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(){
            this.next = null;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    public GenericList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToFront(T val){
        Node<T> n = new Node<>();
        n.data = val;

        if(this.isEmpty()){
            this.head = n;
            this.tail = n;
        }
        else {
            n.next = head;
            head = n;
        }
        this.size++;
    }

    public void removeFront(){
        if(!this.isEmpty()) {
            Node<T> n = head;
            head = head.next;
            n.next = null;
            if(head == null){
                tail = null;
            }
        }
        else{
            throw new NoSuchElementException("list is empty");
        }
        this.size--;
    }

    public T getFront(){
        if(!this.isEmpty()){
            return this.head.data;
        }
        else{
            throw new NoSuchElementException("list is empty");
        }
    }

    public void addToBack(T value){
        Node<T> n = new Node<>();
        n.data = value;

        if(this.isEmpty()){
            this.head = n;
            this.tail = n;
        }
        else {
            this.tail.next = n;
            tail = n;
        }
        this.size++;
    }

    public void removeBack(){
        if(!this.isEmpty()) {
            Node<T> w = head;
            while(w.next != tail){
                w = w.next;
            }
            w.next = null;
            tail = w;
        }
        this.size--;
    }

    public T getBack(){
        if(!this.isEmpty()){
            return tail.data;
        }
        else{
            throw new NoSuchElementException("list is empty");
        }
    }

    public void print(){
        if(!this.isEmpty()){
            Node<T> n = head;
            while(n != null){
                StdOut.printf("%s -> ", n.data);
                n = n.next;
            }
            StdOut.print("null\n");
        }
    }

    // 1 -> 2 -> 3 -> 5 -> null
    // insertAt(0, 99);
    // 99 -> 1 -> 2 -> 3 -> 5 -> null
    // insertAt(3, 77);
    // 99 -> 1 -> 2 -> 3 -> 5 -> null
    public void insertAt(int idx, T value) {
        if(idx >= this.size()){
            throw new NoSuchElementException("idx is longer than the length of the list");
        }
        else if (idx == 0) {
            addToFront(value);
        }
        else if(idx == this.size() -1){
            addToBack(value);
        }
        else {
            Node<T> w = head;
            int i = 0;
            while(w != null && i < idx){
                w = w.next;
                i++;
            }
            Node<T> r = head;
            while(r.next != w){ r = r.next; }
            Node<T> n = new Node<>();
            n.data = value;
            r.next = n;
            n.next = w;
            this.size++;
        }
    }

    public void removeAt(int idx){

    }

    public T getAt(int idx){
        if(idx > size()-1){
            throw new NoSuchElementException("idx: " + idx + " is greater than the list length");
        }
        if(idx == 0){
            return getFront();
        }
        else if(idx == size()-1){
            return getBack();
        }
        Node<T> n = head;
        for(int i = 0; i < idx; i++){
            n = n.next;
        }
        return n.data;
    }

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

}
