import java.util.ArrayList;
import java.util.List;


/**
 * Team members: Jiawei Deng
 * 				Yingxie Gao
 * 				Zhengwei Su
 * @author Jiawei Deng
 * 
 * RBTree class, maintains operations on RBTree.
 */
public class RBTree{
	
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
		return nil;
	}
	
	/**
	 * Returns the number of internal nodes in the tree.
	 * @return size
	 */
	public int getSize() {
		//TODO: Modify it accordingly.
		//return root.numLeft + root.numRight + 1;
		return 0;
	}
	
	
	/**
	 * Returns the height of the tree.
	 * @return height
	 */
	public int getHeight() {
		//TODO: Modify it accordingly.
		//return root.numLeft + 1;
		return 0;
	}
	
	//Add more functions as  you see fit.
	
	private void leftRotate(RBTree T, Node x) {		
		
		Node y;
		y = x.right;
		x.right = y.left;
		
		if(y.left!=null)
			y.left.parent = x;
		y.parent = x.parent;
		if(x.parent == null)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
		
	}
	
	private void rightRotate(RBTree T, Node x) {
		
		Node y;
		y = x.left;
		x.left = y.right;
		
		if(y.right!=null)
			y.right.parent = x;
		y.parent = x.parent;
		if(x.parent == null)
			T.root = y;
		else if(x == x.parent.right)
			x.parent.right = y;
		else
			x.parent.left = y;
		y.right = x;
		x.parent = y;
	}
	
	private void insert(RBTree T, Node z) {
		
		Node y = T.nil;
		Node x = T.root;
		
		while(x!=T.nil) {
			y = x;
			if(z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		
		if(y==T.nil)
			T.root = z;
		else if(z.key < y.key)
			y.left = z;
		else
			y.right = z;
		
		z.left = T.nil;
		z.right = T.nil;
		//??? int color red = 0???
		z.color = 0;
		insertFixup(T, z, y);
		
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
	
	private void RBTransplant(RBTree T, Node u, Node v){
		if(u.parent == T.nil)
			T.root = v;
		else if(u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		v.parent = u.parent;
	}
	
	/*private void RBDelete(RBTree T, Node z) {
		Node y = z;
		Node x;
		int yOrigColor = y.color;
		if(z.left == T.nil) {
			x = z.right;
			RBTransplant(T, z, z.right);
		}
		else if(z.right == T.nil) {
			x = z.left;
			RBTransplant(T, z, z.left);
		}
		else {
			y = Minimum(z.right);
			
		}
	}*/
	
	
	
}