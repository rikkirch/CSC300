# Stacks and Queues Assignment

## TL;DR

For this assignment you will need to implement two different data structures:

1. A queue data structure which uses a resizing array to store data
2. A stack which leverages two queues to store data (not efficient but still interesting)

## Summary

As discussed in class, there are multiple methods of implementing a given data structure. For this assignment you will be implementing both a stack and a queue. You will first need to implement a queue, that queue will then in turn be used to implement your stack.

## The Queue

Your first task is to implement a Queue data structure which utilizes a resizing array as its data store. This means that the array should adhere to the following rules which were covered in the text

1. The array should start off as an array of size 1
2. The array should double in size when the number of used slots in the array is equal to the length of the array
3. The array should be halved in size when the number of used slots in the array is equal to 25% of the length of the array

Note the difference between the number of used slots in the array and the overall size of the array. At any given time only a subset of the overal array capacity may be being used.

![image-20211121210335223](.rsrc/README/image-20211121210335223.png)

This means that the array should only be resized when all open slots in the array are currently occupied. For instance a an equal number of `push` and `pop` calls may put our queue into the following state:

![image-20211121210520154](.rsrc/README/image-20211121210520154.png)

In this case the next call to `push` _should not_ resize the array as there are still open slots available in the array. Instead we should wrap around to the start of the array and begin inserting data there

![image-20211121210655521](.rsrc/README/image-20211121210655521.png)

This pattern would continue until all slots have been filled

![image-20211121210811633](.rsrc/README/image-20211121210811633.png)

Now the next `push` call would resize the array. Note that when resizing the array you will want to rebase both head and tail such that the front of the queue is again found at index 0.

![image-20211121211007598](.rsrc/README/image-20211121211007598.png)

### The Queue Interface

`IQueue.java` contains the queue interface that is to be implemented inside of `Queue.java`. Each queue method and its associated behavior is described in the file and provides the required information needed to implement the behavior correctly. An example can be seen below

```java
    /**
     * Retrieves the front element from the queue and removes it from the front of the queue
     * @return The data foundat the start of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T pop() throws NoSuchElementException;
```

The above snippet from `IQueue.java` describes the behavior of the `pop` method. The first line describes the overal intent of the method. In this case the method means to retreive whatever is at the front of the queue, remove it from the queue, and return that item to the caller. 

The `@return` line describes the type of object that `pop` will return, in this case a reference to the item that was at the front of the queue. 

The `@throws` line describes the exception that the method should throw in the associated edge case. In this example `pop` will throw a `NoSuchElementException` if the queue is empty and the `pop` method is called.

### Testing the Queue

Multiple unit tests have already been written that you can use to test the functionality of your queue. You can run this tests by highlighting the `test/Queue.java` file in the project explorer and then using the `ctrl+shift+r` keyboard shortcut. This will execute the associated tests and provide you a count of how many passed and how many failed.

![Queue testing](.rsrc/README/queue-test.gif)

If you would like to test your queue interactively using `StdIn` you may use the interactive interface provided in `Main.java`. This file presents an interface where you are able to type in the name of the command that you wish to run with StdIn along with any required parameters. For instance if you wanted to call `push("hello")` you could do so by building Queue.java and Main.java, then executing Main.java. Once the program is running you could type `push hello` into the opened terminal in order execute the push method.

To test in this way first open `Main.java` and make sure that line 46 is commented out. You can then build and run your program.

![Running Queues](.rsrc/README/running-queues.gif)



## The Stack

The second half of this assignment will require you to implement a LIFO stack data structure. In the class videos and text we have discussed how to implement a stack using a linked list as well as an array. For this specific stack implementation you will instead be utilizing two seperate queues as the building blocks for your stack. This implementation will not be efficient and all operations will be at least O(N) in runtime, however it is a good chance to practice utilizing one type of seemingly unrelated data structure to implement another data structure.

The `Stack` type will have two private instance variables that you will need to initialize, `q1` and `q2`.

```java
public class Stack<T> {
  private Queue<T> q1;
  private Queue<T> q2;
  ...
}
```

 The `Stack` constructor should initialize these two stacks. Once initialized, your task will require you to complete the `Stack` push, pop, peek, size, and isEmpty methods with the behaivor defined in `IStack.java`. Each of these methods will need to leverage the APIs provided by your two queues to insert and retreive data from those queues in such a way that Stack behavior of each Stack method is maintained. 

### The Stack Interface

`IStack.java` contains the queue interface that is to be implemented inside of `Stack.java`. Each stack method and its associated behavior is described in the file and provides the required information needed to implement the behavior correctly. An example can be seen below

```java
    /**
     * Retrieves the top element from the stack and removes it from the stack
     * @return The data foundat the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    T pop() throws NoSuchElementException;
```

The above snippet from `IStack.java` describes the behavior of the `pop` method. The first line describes the overal intent of the method. In this case the method means to retreive whatever is at the top of the stack, remove it from the stack, and return that item to the caller. 

The `@return` line describes the type of object that `pop` will return, in this case a reference to the item that was at the top of the stack. 

The `@throws` line describes the exception that the method should throw in the associated edge case. In this example `pop` will throw a `NoSuchElementException` if the stack is empty and the `pop` method is called.

## Testing the Stack

The Stack file may be tested and debugged in the same manner as the Queue file. To run all unit tests on the Stack follow the same steps described in **Testing the Queue** except highlight `Stack.java` inestead of `Queue.java`. If you wish to test the Stack file manually via StdIn you can again follow the same steps as you would follow to test the Queue file with a one line change to `Main.java`, here make sure that line 45 is commented out and line 46 is not commented. This will cause `main` to create an instance of a stack instead of an instance of a queue. Since the stack and queue data types expose the same API no other changes need to be made.

## Grading

The test cases described above will be used as the primary grading metric for this assignment. The percentage of tests 
passed will determine the percentage of credit awarded for the assignment. For example, if you pass 90 percent of the 
tests you earn 90 percent credit for the assignment. If you pass 100 percent of the tests you will earn 100 percent credit 
for the assignment. Code that does not compile will not earn any points. To run all test cases across all files first highlight the `test` directory in the project explorer and use the `ctrl+shift+r` keyboard shortcut to begin running all tests. After the tests have completed you will be shown the number of tests that passed and failed. 