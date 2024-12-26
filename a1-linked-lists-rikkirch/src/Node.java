/******************************************************************************
 *
 * WARNING: DO NOT MODIFY THIS FILE
 * ================================
 *
 * This file is fully implemented and represents the nodes that will end
 * up making our linked list. You will need to create instances of this class
 * in the DoublyLinkedList.java file and then use the public methods defined
 * below in order to store and retreive data from the nodes.
 *****************************************************************************/

/**
 * This is the base node class that will be used to create a linked list.
 * @param <T> The type of data that the node will store
 */
public class Node <T> {
    T data;
    Node<T> next;
    Node<T> prev;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node(){
        data = null;
        next = null;
        prev = null;
    }

    public Node(T data){
        this.data = data;
        next = null;
        prev = null;
    }
}
