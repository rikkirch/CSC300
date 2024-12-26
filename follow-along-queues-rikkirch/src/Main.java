import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StopwatchCPU;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
          StackQueue<Integer> q = new StackQueue<>();
	for (int i = 0; i < 20; i++){
	q.push(i);
    }

	while(!q.isEmpty()){
	StdOut.printf("%d",q.pop());
	}
	StdOut.println(); 
 }
}
