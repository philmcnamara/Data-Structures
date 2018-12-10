public class Queue<E> {
	private Node<E> head;
	private Node<E> tail;

    // Constructor
	public Queue(){
		head = null;
		tail = null;
	}

    // Adds a new data element to the back of the queue
	public void enqueue(E newData){
		Node<E> node = new Node<E>(newData, null);
		// Empty Case
		if(head == null && tail == null) {
			head = node;
			tail = node;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
	}

    // Removes and returns the element at the front of the queue
	public E dequeue(){
        // Empty Case
		if(head == null) {
			return null;
		}
        // Use a temporary node to move the head pointer
		else {
			Node<E> temp = head;
			head = head.getNext();
			return temp.getData();
		}
	}

    // Returns True if the queue is empty, false otherwise
	public boolean isEmpty(){
		return(head == null);
	}

    // Writes the contents of the queue front to back to standard output
	public void printQueue(){
		// Empty Case
		if(tail == null && head == null) {
			System.out.println("Empty");
		}
		else {
			Node<E> temp = head;
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}
}
