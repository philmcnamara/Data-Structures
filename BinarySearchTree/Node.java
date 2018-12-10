public class Node<E extends Comparable<E>> {
    private E data;
    private Node<E> leftChild;
    private Node<E> rightChild;
    private Node<E> parent;

    //Constructor
    public Node(E d){
        data = d;
        leftChild = null;
        rightChild = null;
        parent = null;
    }

    // Data mutator
    public void setData(E d){
        data = d;
    }

    // Left child mutator
    public void setLeftChild(Node<E> lc){
        leftChild = lc;
    }

    // Right child mutator
    public void setRightChild(Node<E> rc){
        rightChild = rc;
    }

    // Parent mutator
    public void setParent(Node<E> p){
        parent = p;
    }

    // Data accessor
    public E getData(){
        return data;
    }

    // Left child accessor
    public Node<E> getLeftChild(){
        return leftChild;
    }

    // Right child accessor
    public Node<E> getRightChild(){
        return rightChild;
    }

    // Parent accessor
    public Node<E> getParent(){
        return parent;
    }
}
