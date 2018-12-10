public class TwoStackQueue<E> {
	private Stack<E> s1;
	private Stack<E> s2;

    // Constructor, makes two stacks
	public TwoStackQueue(){
		s1 = new Stack<E>();
		s2 = new Stack<E>();
	}

    // Always add data to the first stack
	public void enqueue(E data) {
		s1.push(data);
	}

    // Dequeue uses the second stack
	public E dequeue() {
        // Dequeue always pops the second stack until it's empty
        if(s2.isEmpty() == false) {
			return s2.pop();
		}
        // To dequeue from the first stack, copy everything to the second
		else {
			while(s1.isEmpty() == false) {
				E value = s1.pop();
				s2.push(value);
			}
			return s2.pop();
		}
	}

    // Queue is empty if both stacks are empty
	public boolean isEmpty(){
		return(s1.isEmpty() == true && s2.isEmpty() == true);
	}

}
