n# Linked List Assignment

## TL;DR

For this assignmnet you will be completling two different tasks:

1. Complete the `DoublyLinkedList` class inside of `DoublyLinkedList.java`. This class will implement all methods defined inside of `ILinkedList.java` with the specified requirements using a doubly linked list. See the `Doubly Linked List` section below for details on how a doubly linked list differs from a singly linked list
2. Complete the `CircularList` class inside of `CircularList.java`. This class will implement all methods defined inside of `ILinkedList.java` with the specified requirements using a circular list. See the `Circular List` section below for the differences between the Doubly Linked List and the Circular Linked List

## Doubly Linked List

A doubly linked list is a type of list where each node contains two pointers. It maintains the `next` pointer which is used to move to the next node in the list and it also maintains a `prev` pointer which is used to move to the node that comes before a given node. This allows the list to be traversed in either direction, forword or backwards.

![image-20211121125500659](.rsrc/README/image-20211121125500659.png)

The use of the prev pointer allows us to simply some of the linked list operations by giving access to any node's predecessor without needing to re-traverse the list to find it such as one needs to do with an `insertAt` operation. Visually, a doubly linked list appears as: 

![image-20211121125859994](.rsrc/README/image-20211121125859994.png)

By correctly maintaining the `next` and `prev` pointers we are able to perform list operations as we have before such as traversing the list from front to back:

```Java
Node n = head;
while(n != null){
  n = n.next;
}
```

Or when combined with the use of the `tail` pointer we could traverse the list from back to front:

```java
Node n = tail;
while(n != null){
  n = n.prev;
}
```

Using this pointer can also make several of the linked list operations (such as `removeAt` or `insertAt`) much easier by no longer requiring us to traverse the list multiple times in order to modify the list.

## Circular List

In most standard lists we indicate we have reached the end of list by setting a node's `next` field to `null`. This tells us that there are no other nodes in the list. Another option is to instead create a circular linked list. In this structure the last node's `next` field instead points back to the first node in the list and if a doubly linked list is implemented the first node's `prev` point will point at the last node in the list.

![image-20211121130644961](.rsrc/README/image-20211121130644961.png)

There are a few added benefits to this style of list:

1. We could start at any position in the list and easily reach any other node in the list without first searching in one direction and then searching in the other. We just need to note what node started at and stop once we reach that node again
2. We can achieve the same `O(1)`operation time for removeBack/insertBack/getBack operations while only maintaining the `front` pointer

## The LinkedList Interface

The `ILinkedList.java` file defines the interface that will be implemented by the `DoublyLinkedList` and `CircularList` classes. `ILinkedList.java` lists all methods that you will be expected to implement as well as defines the expected behavior of those including the expected runtime of each method. Behaviors include what type the method should return, what parameters the method accepts and expected behavior in edge cases such as if an exception should be thrown. Let's look at an example of one of 
these defenitions:

```java
    /**
     * Returns the item found at the very front of the list
     *
     * @requirements This method must execute in O(1) time
     * @return A reference to the item at the front of the list
     * @throws NoSuchElementException when the list is empty
     */
    T getFront() throws NoSuchElementException;
```

The above example from `ILinkedList.java` contains all of the information you need to correctly implement `getFront`.The comments state the expected behavior of the method. In this case it indicates that this method is expected to return whatever value is found at the front of the list. 

Next in the comments, a specific runtime requirement of the method is stated by the `@requirements` line. In this example we are stating that this method must execute in `O(1)` time. This means that a proper implementation _should not_ iterate over the contents of the list in order to find the front of the list. 

Next the `@return` line describes _what_ is returned by the method. Here we are returning a reference to the object that 
is stored at the front of the list. In this example the type of the object is denoted by `T` as we are using Java Generics.

Finally the `@throws` line tells us that this method can throw a `NoSuchElementException` in edge cases. Here, the edge 
case that can trigger that behavior is when the list is empty and this method is called. 

## The Node Object

The base type that comprises a linked list is the `Node` object. This is the object that actually stores the data and 
contains pointers to the other nodes found in the linked list. A fully implemented `Node` type has already been created 
for you inside of `Node.java`. 

Your linked list code will need to create new instances of the `Node` type when adding nodes to the linked list. After 
creating a new node you can access fields of the node using the getters and setters defined in `Node.java`. 

For example, if you wanted to retreive the `next` pointer of a Node instance you would use the `getNext()` method. If you 
wanted to set the `next` field of a node, you would use the `setNext()` method. Search for any `public` methods inside of 
`Node.java` if you are unsure how to get or set a specific value of the node. 

## The DoublyLinkedList Object

`DoublyLinkedList.java` will contain the doubly linked list implementation of the LinkdedList interface. This is one of the two files you will be modifying for this assignment. Skeleton code for all methods you will need to implement already exists, you will need to fill in the appropriate logic required to fully implement the method(s). The expected behavior of each method you will 
be completeing is defined inside of `ILinkedList.java`. See the corresponding method in that file for its documentation.

## The CircularList Object

`CircularList.java` will contain the circular list implementation of the LinkdedList interface. This is the second of the two files you will be modifying for this assignment. Skeleton code for all methods you will need to implement already exists, you will need to fill in the appropriate logic required to fully implement the method(s). The expected behavior of each method you will be completeing is defined inside of `ILinkedList.java`. See the corresponding method in that file for its documentation.

## Main.java

This project includes a test client that you can use to test your code with. This client is found inside of `Main.java`. 
This file will create an instance of the `DoublyLinkedList` class and then wait for commands to be typed into `StdIn` and then the associated `LinkedList` method will by called. This allows you to interactively interface with the linked list, provide data to the list, and validate that everything is working as expected. If you would like to test the `CircularList` class instead comment out the line 45 of Main.java and add a new line which creates an instance of the circular list class

```java
// DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
CircularList<Integer> ll = new CircularList<>();
```

The commands that the test client will accept mirror the names of the methods defined in `ILinkedList.java`. For instance, if you want to remove the front of the list, you would type `removeFront` into the terminal that opens when running `Main.java`.If the method takes parameters, such at `insertFront` you simply add a space between the method name and the value you wish to pass to it. For instance, if you want to add 10 to the front of the list you would type `insertFront 10` and hit enter. 

![Test Client Usage](.rsrc/test-client-usage.gif)

## Building Your Program

To build your program, first click and highlight the `src` directory in the project explorer on the left hand side of the 
Intellij window. Once hilighted, select the `Build` option from the toolbar, and then click `Build Project`. If there are 
compile time errors a window will appear at the bottom describing the cause of the errors and lines that they were found on. 

![Building your program](.rsrc/building.png)

## Running the Test Client

To run the test client and interactively interface with the doubly linked list, first make sure that you have followed 
the `Building Your Program` instructions defined above. Next, hilight `Main.java` in the project explorer on the left 
hand side of the Intellij window. Then select `Run` from the toolbar and click on `Run 'Main'`. This will execute your 
program and a new window will appear at the bottom of the screen that you can type commands into.

![Building your program](.rsrc/running.png)

## Testing 

This project includes a suite of tests that will be run on your code. These tests are used to validate that the code 
behaves as expected in different scenarios and handles various edge cases appropriatly. The test cases can be found inside of the `test` folder in the project. Each test case consists of a single, self contained method, which exercises a specific 
piece of functionality. The following is an example of a single test

```java
    @Test
    void getLenWhenEmpty() {
        assertEquals(0, ll.len());
    }
```

The above code ensures that a call to the `len` method returns 0 when the list is empty.

To execute the tests, first highlight the `test` directory in the project explorer and then use the following keyboard
shortcut to execute all tests. 
- Windows/Linux: `ctrl + shif + f10` 
- Mac: `ctrl + shift + r`

A new window will open at the bottom which shows the results of the tests as they are executed.

![Running Tests](.rsrc/tests.gif)

If any tests fail, you will be alerted in the window and can then see why the test failed. 

![Failed Test](.rsrc/failed.png)

In the above case we can see that the test failed because the output provided by the method call did not match what was expected. For this example, we expected to see a 1 returned but actually got a 0 back. The window also includes the list of calls that led to the failure. In our case the line that caused the test to fail was found on line 54 of DoublyLinkedListTest.java inside of the `test` directory. You can click on the blue file name to take you directly to the line of code that failed. For this example, line 54 is the `assertEquals` line of the code snippet shown above.

What this tells us is that the `len` method of the `DoublyLinkedList` class is not implemented correctly. In the test 
code, the list is empty therefor we know any calls to `len` should return 0. This indicates that a bug exists in the 
`len` method. 

## Grading

The test cases described above will be used as the primary grading metric for this assignment. The percentage of tests 
passed will determine the percentage of credit awarded for the assignment. For example, if you pass 90 percent of the 
tests you earn 90 percent credit for the assignment. If you pass 100 percent of the tests you will earn 100 percent credit 
for the assignment. Code that does not compile will not earn any points.

## Extra Resources

- [Doubly Linked List Overview - wikipedia](https://en.wikipedia.org/wiki/Doubly_linked_list)

- [Doubly Linked Lists - Vizualgo](https://visualgo.net/en/list?slide=6)

- [Linked Lists - Computerphile](https://www.youtube.com/watch?v=_jQhALI4ujg)

- [Data Structures: Introduction to Doubly Linked List](https://www.youtube.com/watch?v=JdQeNxWCguQ)

 [Introduction to Circular Linked List](https://www.youtube.com/watch?v=HMkdlu5sP4A)

- [Circular Linked List Data Structure in C++ With Illustration](https://www.softwaretestinghelp.com/circular-linked-list/)

zsh:1: command not found: :q
