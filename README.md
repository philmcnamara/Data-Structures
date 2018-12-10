# Data-Structures
This is a set of simple data structures created from scratch in Java for my CS coursework

It includes a stack, a queue, a binary search tree, and a max-heap

Building blocks are encapsulated Node objects of generic type E with mutators/accessors for access to their contents

### Stack

Implementation is a singly-linked list with sentinel node "top" 

Methods:

- Push - Adds a new data element to the top of the stack
- Pop - Removes and returns the top element from the stack
- isEmpty - Returns True if the stack is empty, False otherwise
- printStack - Writes the contents of the stack top to bottom to standard output