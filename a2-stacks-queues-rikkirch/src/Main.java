/******************************************************************************
 *
 * WARNING: DO NOT MODIFY THIS FILE
 * ================================
 *
 * This file acts as a test client for the doubly linked list class. When built
 * and executed, this program lets you type commands and parameters into Stdin
 * which will then call the associated method of the DoublyLinkedList class.
 *
 * For example, typing:
 *
 *      insertFront 10
 *
 * into stdin after running this program will result in the insertFront method
 * of the DoublyLinkedList class being called with 10 being passed as its
 * parameter. See the switch statement below to see how commands and their
 * parameters are being used to call the linked list methods.
 *
 * Use this program as one method of testing the code you are writing. You can
 * quickly build, run, and test different scenarios and edge cases using this
 * program. You can also set breakpoint on calls to the linked list methods and
 * then 'step into' those methods if you are running into a tricky situation
 * where things are not behaving quite as expected.
 *
 * If you get into a situation where you find a bug after typing a series of
 * commands and need to repeatedly re-test that sequence, you can automate the
 * process by using Input Redirection. First create a text file and place your
 * series of commands into the text file. Once the file exists, go to the Intellij
 * toolbar and select Run -> Edit Configurations, a new window will appear.
 *
 * Look at the bar that appears on the left hand side of the bar and ensure that
 * "Application -> Main" is highlighted. To the right you will see a check box
 * that says "Redirect input from:" with a text box to the right. Select the textbox
 * and then enter the path to the textfile that you just created.
 *
 * By selecting that option, intellij will automatically open the file when you
 * run the Main program, read the contents, and pass the contents to your program
 * just as if you were typing it into ther terminal.
 *
 *****************************************************************************/
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        //Stack<String> q = new Stack<>();
        while(!StdIn.isEmpty()){
            String cmd = StdIn.readString();
            switch(cmd){
                case "push":
                    String val = StdIn.readString();
                    q.push(val);
                    break;
                case "pop":
                    try {
                        StdOut.println(q.pop());
                    }
                    catch(NoSuchElementException e){
                        StdOut.println("list is empty");
                    }
                    break;
                case "peek":
                    try {
                        StdOut.println(q.peek());
                    }
                    catch(NoSuchElementException e){
                        StdOut.println("list is empty");
                    }
                    break;
                case "isEmpty":
                    StdOut.println(q.isEmpty());
                    break;
                case "size":
                    StdOut.println(q.size());
                    break;
                default:
                    StdOut.println("unknown command: " + cmd);

            }
        }
    }
}
