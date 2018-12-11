# Data-Structures
This is a set of simple data structures created from scratch in Java 10.0.2 for my CS coursework

Building blocks are encapsulated Node objects of generic type E

## Stack

**Implementation:** singly-linked list with sentinel node "top" 

**Methods:**

- Push - Adds a new data element to the top of the stack
- Pop - Removes and returns the top element from the stack
- isEmpty - Returns True if the stack is empty, False otherwise
- printStack - Writes the contents of the stack top to bottom to standard output



## Queue

**Implementation:** singly-linked list with two sentinel nodes "head" and "tail"

**Methods:**

- Enqueue - Adds a new data element to the back of the queue
- Dequeue - Removes and returns the element at the front of the queue
- isEmpty - Returns True if the queue is empty, false otherwise
- printQueue - Writes the contents of the queue front to back to standard output



## TwoStackQueue

**Implementation:** two stacks

**Methods**: 

Implements all the above Queue methods with two stacks



## BinarySearchTree

**Implementation:** Nodes of comparable types with four fields: data, left child pointer, right child pointer, and parent pointer

All right children of a node are greater than the parent, and all left children are less than the parent

Duplicate values are not supported

**Methods:**

- Insert - Searches the tree and inserts the new data at the proper location
- Find - Searches the tree for a node whose data field is equal to the query, then returns it
- Delete - Removes the target value from the tree and replaces it with its "successor", the minimum value of its right subtree
- Traverse - Prints the contents of the tree to standard out by a "preorder", "inorder", or "postorder" traversal
- getMin - Returns the minimum value of the subtree rooted at "top", used in "delete"
