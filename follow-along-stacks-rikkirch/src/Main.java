import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StopwatchCPU;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
ArrayStack<Integer> ls = new ArrayStack<>();
	for (int i = 0; i < 10; i++){
		ls.push(i);
  		}	
		while(!ls.isEmpty()){
		StdOut.println(ls.pop());
		} 

	}
}
