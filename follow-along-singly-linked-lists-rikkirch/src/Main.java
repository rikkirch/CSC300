

public class Main {
    public static void main(String[] args) {
ListOfStrings list = new ListOfStrings();

list.addToFront("World");
list.addToFront("Hello");

System.out.println("list.getFront());  //displays Hello

list.removeFront(); // will remove Hello

System.out.println("list.getfront());  // displays World

list.removeFront(); // will remove World

System.out.println(list.getfront()); // displays nothing 
    }
}


