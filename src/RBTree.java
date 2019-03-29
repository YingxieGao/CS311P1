import jdk.nashorn.internal.runtime.regexp.joni.ast.Node;
import java.util.ArrayList;
import java.util.List;


/**
 * Team members: Jiawei Deng
 * @author Jiawei Deng
 * @author Jiawei Deng
 * 
 * RBTree class, maintains operations on RBTree.
 */
public class RBTree<T extends Comparable<T>> {
	
	private RBTree<T> nil = new RBTree<T>();
	private RBTree<T> root = nil;
	
	Node root;
	Node nil;
	int size;
	int height;
	
	
	/**
	 * RB Tree constructor with no parameter. It 
	 * initializes nil node as well.
	 */
	public RBTree() {
		//TODO: Add code as needed.
		root.left = nil;
		root.right = nil;
		root.parent = nil;
		size = 0;
		height = 0;
		root = nil;
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
	
	private void leftRotate(Node x) {		
		
		Node y;
		y = x.right;
		x.right = y.left;
		
		if(y.left!=null)
			y.left.parent = x;
		y.parent = x.parent;
		if(x.parent == null)
			this.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
		
	}
	
	private void rightRotate(RBTree<T> T, Node x) {
		
		
		
	}
	
	private void insert(RBTree T, Node z) {
		
		Node y = T.nil;
		Node x = T.root;
		
		while(x!=T.nil) {
			y = x;
			if(z.key.compareTo(x.key) < 0)
				x = x.left;
			else
				x = x.right;
		}
		
		if(y==T.nil)
			T.root = z;
		else if(z.key.compareTo(y.key) < 0)
			y.left = z;
		else
			y.right = z;
		
		z.left = T.nil;
		z.right = T.nil;
		//??? int color red = 0???
		z.color = 0;
		insertFixup(T, z);
		
	}
	
	private void insertFixup(RBTree T, Node z, Node y) {
		
		while(z.parent.color == 0) {
			
			if(z.parent == z.parent.parent.left) {
				y = z.parent.parent.right;
				if(y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				}
				else {
					if(z == z.parent.right) {
						z = z.parent;
						leftRotate(T, z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					rightRotate(T, z.parent.parent);
				}
			}
			else {
				y = z.parent.parent.left;
				if(y.color == 0) {
					z.parent.color = 1;
					y.color = 1;
					z.parent.parent.color = 0;
					z = z.parent.parent;
				}
				else {
					if(z == z.parent.left) {
						z = z.parent;
						rightRotate(T, z);
					}
					z.parent.color = 1;
					z.parent.parent.color = 0;
					leftRotate(T, z.parent.parent);
				}
			}
			
		}
		T.root.color = 1;
	}
	
	
	
}
