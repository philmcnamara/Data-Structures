public class Node<E> {
	private E data;
	private Node<E> next;

    // Constructor
	public Node(E c, Node<E> n){
		data = c;
		next = n;
	}

    // Data mutator
	public void setData(E d){
		data = d;
	}

    // "Next" pointer mutator
	public void setNext(Node<E> n){
		next = n;
	}

    // Data accessor
	public E getData(){
		return data;
	}

    // "Next" pointer accessor
	public Node<E> getNext(){
		return next;
	}

}
