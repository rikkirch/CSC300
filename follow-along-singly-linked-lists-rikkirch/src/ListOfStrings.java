import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class ListOfStrings {

    private static class Node {
        String data;
        Node next;
        public Node(){
            this.data = null;
            this.next = null;
        }
    }

    Node head;

    public ListOfStrings(){
        this.head = null;
    }

    public void addToFront(String val){

Node n = new node();
n.data = val;

if(this.head == null){
this.head = n;
    }
else{
n.next = head; 
head = n;


    public void removeFront(){
   if(this.head == null) {
System.Out.println("The list is Empty");
return;
    }
head = head.next;
}

    public String getFront(){
if (this.head == null) {
           System.Out.println("List is empty, no front element");
return;
        } else {
            return this.head.data; // Return the data at the front node
        }       
 return null;
    }
}

















:w
:q



