# Lecture 21
If the execution time depends on its variables, it is slow. If the execution time is constant, regardless of the variables, it is fast.

ArrayList: <br>
`void addFirst(E o)` *slow* <br>
`void addLast(E o)` *slow* <br>
`void add(E o, int pos)` *slow* <br>
`E get(int pos)` *fast* <br>
`void removeFirst()` *slow* <br>
`void removeLast()` *fast* <br>

LinkedList: <br>
`void addFirst(E o)` *fast* <br>
`void addLast(E o)` *slow* <br>
`void add(E o, int pos)` *slow* <br>
`E get(int pos)` *slow* <br>
`void removeFirst()` *fast* <br>
`void removeLast()` *slow* <br>

To speed up the `addLast` method of `SinglyLinkedList` we can add a variable `tail` that keeps track of the last element in the linked list.

In Java the classes that are used to store objects are regrouped into a hierarchy of classes called Collection.

There are four boad categories of collections: linear, hierarchical, graph and unordered. 

Linear COllections comprise lists, stack and queues. Elements of a linear collectino all have a specific predecessor and successor, except for the first and last elements.

Hierarchical collections allow the usre to represent various kinds of trees: e.g.: genealogial information.

The graph collections are used to store directed, undirected, weighted and unweighted graphs.

Unordered collections include sets, bags and maps.