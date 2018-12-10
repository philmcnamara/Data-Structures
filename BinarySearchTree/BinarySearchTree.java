public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    public BinarySearchTree(){
        root = null;
    }
    // This pointer keeps track of our position in the tree, it is reset to root when a function returns
    Node<E> current = root;
    // Recursively searches the tree and inserts the new data at the proper location
    public void insert(E data){
    	Node<E> newNode = new Node<E>(data);
        // Empty Case
    	if(root == null) {
    		root = newNode;
    		current = root;
    		return;
    	}
    	// Insert Left Base Case
        // We use Object.compareTo() to ensure search works for all objects implementing the Comparable interface
    	if(newNode.getData().compareTo(current.getData()) < 0 && current.getLeftChild() == null){
    		current.setLeftChild(newNode);
    		newNode.setParent(current);
    		current = this.root;
            return;
    	}
    	// Insert Right Base Case
    	else if(newNode.getData().compareTo(current.getData()) > 0 && current.getRightChild() == null){
    		current.setRightChild(newNode);
    		newNode.setParent(current);
    		current = this.root;
            return;
    	}
    	// Recursive Case Left
    	else if(newNode.getData().compareTo(current.getData()) < 0) {
    		current = current.getLeftChild();
    		insert(data);
    	}
    	// Recursive Case Right
    	else if(newNode.getData().compareTo(current.getData()) > 0){
    		current = current.getRightChild();
    		insert(data);
    	}
        // Duplicate Case
        else{
            System.out.println("Cannot insert duplicate values");
            return;
        }
    }
    // Searches the tree for a node whose data field is equal to the query
    public Node<E> find(E data){
    	// Base Case
    	if(current.getData() == data) {
    		Node<E> result = current;
    		current = this.root;
    		return result;
    	}
    	// Search Right Recursive Case
    	else if(current.getData().compareTo(data) < 0) {
    		// No Right Child, not in the tree
    		if(current.getRightChild() == null) {
    			return null;
    		}
    		// Right child exists, keep searching right
    		else {
    			current = current.getRightChild();
    			return find(data);
    		}
    	}
    	// Search Left Recursive Case
    	else {
    		// No Left Child, not in the tree
    		if(current.getLeftChild() == null) {
    			return null;
    		}
    		// Left child exists, keep searching left
    		else {
    			current = current.getLeftChild();
    			return find(data);
    		}
    	}
    }
    // Removes the target value from the tree
    public void delete(E data){
        // Find the right node to be deleted
    	Node<E> target = find(data);
    	if(target == null) {
    		System.out.println("Node not in tree, not deleted");
    	}
    	// Root Cases
    	if(target.equals(root)) {
    		// No Children
    		if(target.getLeftChild() == null && target.getRightChild() == null) {
        		root = null;
        	}
        	// Right Child Only
        	else if(target.getLeftChild() == null && target.getRightChild() != null) {
        		root = target.getRightChild();
        		target.setRightChild(null);
        		root.setParent(null);
        	}
        	// Left Child Only
        	else if(target.getRightChild() == null && target.getLeftChild() != null) {
        		root = target.getLeftChild();
        		target.setLeftChild(null);
        		root.setParent(null);
        	}
    		// Two Children
    		else if(target.getRightChild() != null && target.getLeftChild() != null) {
        		Node<E> successor = getMin(target.getRightChild());
        		successor.setLeftChild(target.getLeftChild());
        		target.getLeftChild().setParent(successor);
        		// If successor is not the right child of target
        		if(target.getRightChild().equals(successor) == false) {
        			// If successor has a right child, set that to its parent
        			if(successor.getRightChild() != null){
            			successor.getParent().setLeftChild(successor.getRightChild());
            			successor.getRightChild().setParent(successor.getParent());
            		}
            		else {
            			successor.getParent().setLeftChild(null);
            		}
            		// Set successor's right child to target's right child
            		successor.setRightChild(target.getRightChild());
        		}
        		// Break parent-child pointers for successor
        		successor.setParent(null);
        		target.getRightChild().setParent(successor);
        		// Update root pointer
        		this.root = successor;
        	}
    	}
    	// Non-root cases
    	else {
    		Node<E> target_parent = target.getParent();
    		// No Children
    		if(target.getLeftChild() == null && target.getRightChild() == null) {
        		// Remove parent's pointers to target
        		// Left pointer case
        		if(target_parent.getData().compareTo(target.getData()) > 0) {
        			target_parent.setLeftChild(null);
        		}
        		// Right pointer case
        		else {
        			target_parent.setRightChild(null);
        		}
        		// Remove target's pointer to parent
        		target.setParent(null);
    		}
    		// Right child Only
    		else if(target.getLeftChild() == null && target.getRightChild() != null) {
    			// Left pointer Case
    			if(target_parent.getData().compareTo(target.getData()) > 0) {
        			// Point parent to child
        			target_parent.setLeftChild(target.getRightChild());
        			// Point child to parent
        			target.getRightChild().setParent(target_parent);
    			}
    			// Right Pointer Case
    			else {
        			// Point parent to child
        			target_parent.setRightChild(target.getRightChild());
        			// Point child to parent
        			target.getRightChild().setParent(target_parent);
    			}

    		}
    		// Left Child Only
    		else if(target.getLeftChild() != null && target.getRightChild() == null) {
    			// Left pointer Case
    			if(target_parent.getData().compareTo(target.getData()) > 0) {
        			// Point parent to child
        			target_parent.setLeftChild(target.getLeftChild());
        			// Point child to parent
        			target.getLeftChild().setParent(target_parent);
    			}
    			// Right Pointer Case
    			else {
        			// Point parent to child
        			target_parent.setRightChild(target.getLeftChild());
        			// Point child to parent
        			target.getLeftChild().setParent(target_parent);
    			}
    		}
    		else if(target.getRightChild() != null && target.getLeftChild() != null) {
        		Node<E> successor = getMin(target.getRightChild());
        		successor.setLeftChild(target.getLeftChild());
        		target.getLeftChild().setParent(successor);
        		// If successor is not the right child of target
        		if(target.getRightChild().equals(successor) == false) {
        			// If successor has a right child, set that to its parent
        			if(successor.getRightChild() != null){
            			successor.getParent().setLeftChild(successor.getRightChild());
            			successor.getRightChild().setParent(successor.getParent());
            		}
            		else {
            			successor.getParent().setLeftChild(null);
            		}
            		// Set successor's right child to target's right child
            		successor.setRightChild(target.getRightChild());
        		}
        		// Break parent-child pointers for successor
        		successor.setParent(target.getParent());
        		// Set up pointers between successor and target's parent
        		target.getParent().setRightChild(successor);
        		target.getRightChild().setParent(successor);
        		// Delete target's pointers
        		target.setParent(null);
        		target.setLeftChild(null);
        		target.setRightChild(null);
        	}
    	}
    }
    // Prints the tree's contents to standard output by a "preorder", "inorder", or "postorder" traversal
    public void traverse(String order) {
    	traverseHelper(order, root);
    	System.out.println();
    }

    // Helper method for traverse
    public void traverseHelper(String order, Node<E> top) {
        if (top != null){
            switch (order) {
                case "preorder":
                	System.out.print(top.getData() + " ");
                	traverseHelper("preorder", top.getLeftChild());
                	traverseHelper("preorder", top.getRightChild());
                	break;
                case "inorder":
                	traverseHelper("inorder", top.getLeftChild());
                	System.out.print(top.getData() + " ");
                	traverseHelper("inorder", top.getRightChild());
                    break;
                case "postorder":
                	traverseHelper("postorder", top.getLeftChild());
                	traverseHelper("postorder", top.getRightChild());
                	System.out.print(top.getData() + " ");
                    break;
            }
        }
    }

    // Returns the minimum value of the subtree rooted at "top", used in "delete"
    public Node<E> getMin(Node<E> top){
    	if(top.getLeftChild() == null) {
    		return top;
    	}
    	else {
    		top = top.getLeftChild();
    		return getMin(top);
    	}
    }
}
