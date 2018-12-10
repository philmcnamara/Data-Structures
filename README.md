# Data-Structures
This is a set of simple data structures created from scratch in Java for my CS coursework

Building blocks are encapsulated Node objects of generic type E with mutators/accessors

### Stack

Implementation is a singly-linked list with sentinel node "top" 

Methods:

- Push - Adds a new data element to the top of the stack
- Pop - Removes and returns the top element from the stack
- isEmpty - Returns True if the stack is empty, False otherwise
- printStack - Writes the contents of the stack top to bottom to standard output



### Queue

Implementation is a singly-linked list with two sentinel nodes "head" and "tail"

Methods:

- Enqueue - Adds a new data element to the back of the queue
- Dequeue - Removes and returns the element at the front of the queue
- isEmpty - Returns True if the queue is empty, false otherwise
- printQueue - Writes the contents of the queue front to back to standard output