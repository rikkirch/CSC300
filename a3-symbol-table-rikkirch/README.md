# Symbol Table Assignment

## TL;DR

For this assignment you will need to implement a symbol table data structure. The symbol table you are creating should use a binary search tree for its implementation. 

## Summary

As discussed in the videos and text, a symbol table is a data structure that can be used to map some key to a specific value. This type of data structure is very powerful and is used in some fashion across most projects you will encounter. It is so useful that that some languages bake symbol tables (known as dictionaries or hash maps in other languages) directly into the language. For instance, if you have ever seen pyhon code that looks like:

```python
dict["age"] = 25
dict["name"] = "bill"
dict["eye_color"] = "green"
```

You have seen a symbol table in use. Unfortunetly languages like C/C++/Java do not have this data structure built in as part of the language so we will just need to make it!

As with all data structures we've covered so far there are multiple ways to create a data structure such as this, the trick is to create a data structure which is efficient and can handle large data sets. This requirement leaves us with two primary options: a hash table or a binary search tree.

For our purposes we will be using a binary search tree for our implementation. This structure will allow us to practice our recursive programming skills and allows us to write methods with an average O(log n) time (Note a BST can still degrade to O(N) time in some situations).

## The Symbol Table Interface

`ISymbolTable.java` contains the interface that you will be expected to implement inside of `SymbolTable.java` This file describes the expected behavior of each symbol table method, what the methods should return, and what exceptions should be thrown in specific edge cases. An example can be seen below:

```java
    /**
     * Inserts a new key/value pair into the symbol table
     * @param k The key to use
     * @param v The value that should be associated with key
     * @throws InvalidParameterException if k or v are null if a duplicate key is found
     * @requirements This method should execute in O(log n) or better time
     */
    void put(Key k, Value v) throws InvalidParameterException;
```

Here we see the description for the `put` method. The comments describe the purpose of the function as well as the parameters to the function. Below that we can see the `@throws` line which describes how a `InvalidParameterException` should be thrown if either parameters to the method are `null` or if a duplicate key is found. Finallya we see the `@requirements` line which describes the expected runtime for this method. For the `put` method we expect this method to execute in O(log n) or better time. 

## The Symbol Table

Your primary task for this assignment is to implement the interface described in `ISymbolTable` inside of `SymbolTable.java`. Your implementation should be based on a binary search tree. This means that the `SymbolTable` class itself should be a binary search tree. As a result this class should have an inner private class which will represent the nodes of the tree and also an instance variable which represents the root of the tree.

```java
public class SymbolTable<Key extends Comparable<Key>, Value> implements ISymbolTable<Key , Value> {
    // the nodes of our tree
    private class Node{
        ....
        }
    }
    // the root of our tree
    Node root;
```

The methods defined in `ISymbolTable.java` will then map to their respective tree based operations. For example, a call to the symbol table `put()` method is actually going to be implemented by performing a BST insertion operations while a symbol table `contains()` method will be implemented by performing a search of the BST. 

### Testing the Symbol Table

Multiple unit tests have already been written that you can use to test the functionality of your symbol table. You can run this tests by highlighting the `test` folder in the project explorer and then using the `ctrl+shift+r` keyboard shortcut. This will execute the associated tests and provide you a count of how many passed and how many failed.

![sym table testing](.rsrc/st-unit-tests.gif)

If you would like to test your symbol table interactively using `StdIn` you may use the interactive interface provided in `Main.java`. This file presents an interface where you are able to type in the name of the command that you wish to run with StdIn along with any required parameters. For instance if you wanted to insert a value into the symbol table you could do so by typing:

`put age 23`

The commands that are available directly mirror those that the API exposes. See `Main.java` for a list of all commands you can provide via StdIn when running your program manually. To test manually first hilight the `src` folder in the project explorer and rebuild by  right clicking and selecting `rebuild <default>`.

![image-20211127210842104](.rsrc/README/image-20211127210842104.png)

After the program has been built you can execute it by right clicking on `Main.java` and selecting `Run with arguments`

![image-20211127210926217](.rsrc/README/image-20211127210926217.png)

Hit `OK` on the window that pops up, after that a new blank window should appear on the bottom of the Intellij window. You can then begin typing commands into the window.

![testing manually](.rsrc/st-test-manual.gif)

## Grading

The test cases described above will be used as the primary grading metric for this assignment. The percentage of tests 
passed will determine the percentage of credit awarded for the assignment. For example, if you pass 90 percent of the 
tests you earn 90 percent credit for the assignment. If you pass 100 percent of the tests you will earn 100 percent credit 
for the assignment. Code that does not compile will not earn any points. To run all test cases across all files first highlight the `test` directory in the project explorer and use the `ctrl+shift+r` keyboard shortcut to begin running all tests. After the tests have completed you will be shown the number of tests that passed and failed. 

## Extra Credit Opportunity

We have discussed how the efficiency of the methods used by binary search trees will be strongly influenced by the order in which the data is inserted into the tree. If for example a fully sorted list of data is inserted into the tree, all methods will degrade to O(N) as the tree will effectively be nothing more than a linked list. 

The videos and text described how we can resolve this by adding extra logic to the tree which forces the tree to be self balancing and prevents it from degradding to the worst case scenario. The primary method we discussed which would accomplish this task is the use of a left leaning red-black tree. Extra credit for this assignment can be earned if the tree is reworked into a left leaning red-black tree which allows all tree methods (insertion, search, and removal) to be self balancing.
