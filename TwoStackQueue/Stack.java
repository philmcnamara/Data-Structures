public class Stack<E> {
	private Node<E> top;

    // Constructor
	public Stack(){
		top = null;
	}

    // Adds a new data element to the top of the stack
	public void push(E newData){
		// Create new node that points to current top
		Node<E> node = new Node<E>(newData, top);
		// Update top to point to the new node
		top = node;
	}

    // Removes and returns the top element from the stack
	public E pop(){
        if(top == null) {
        // Empty case
			return null;
		}
		else {
            // Use a temp node so we can move top
			Node<E> temp = top;
			top = top.getNext();
			return temp.getData();
		}
	}

    // Returns True if the stack is empty, False otherwise
	public boolean isEmpty(){
		return(top == null);
	}

    // Writes the contents of the stack top to bottom to standard output
	public void printStack(){
		//Empty Case
		if(top == null) {
			System.out.println("Empty");
		}
		else {
			Node<E> temp = top;
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}
}
