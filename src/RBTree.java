/**
 * Team members: Jiawei Deng
 * @author John Doe
 * @author Jane Doe
 * 
 * RBTree class, maintains operations on RBTree.
 */
public class RBTree {
	
	Node root;
	Node NILNode;
	int size;
	int height;
	
	
	/**
	 * RB Tree constructor with no parameter. It 
	 * initializes nil node as well.
	 */
	public RBTree() {
		NILNode = new Node();
        root = NILNode;
        size = 0;
		height = 0;
		
	}
	
	/**
	 * Returns the root Node.
	 * @return root
	 */
	public Node getRoot() {
		//TODO: Modify it accordingly.
		return root;
	}
	
	/**
	 * Returns reference for the nil node, for the rbTree.
	 * @return NILNode
	 */
	public Node getNILNode() {
		//TODO: Modify it accordingly.
		return NILNode;
	}
	
	/**
	 * Returns the number of internal nodes in the tree.
	 * @return size
	 */
	public int getSize() {
		//TODO: Modify it accordingly.
		return size;
	}
	
	
	/**
	 * Returns the height of the tree.
	 * @return height
	 */
	public int getHeight() {
		//TODO: Modify it accordingly.
		return height;
	}
	
	//Add more functions as  you see fit.
}
