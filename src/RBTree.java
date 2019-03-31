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
		nil = new Node();
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
		return size;
	}
	
	
	/**
	 * Returns the height of the tree.
	 * @return height
	 */
	public int getHeight() {
		//TODO: Modify it accordingly.
		/**Node y = nil;
		int height = 0;
		while(y.parent != root) {
			y = y.parent;
			height++;
		}
		return height;**/
		//return Math.max(root.numLeft + 1, root.numRight + 1);
		//return (int) (Math.log(size) / Math.log(2.0));
		//return root.height;
		return height;
	}
	
	//Add more functions as  you see fit.
	
	/**
	 * updates the height of the RBTree.
	 */
	public void updateHeight() {
		height = (int) (Math.log(size) / Math.log(2.0));
	}
	
	/**
	 * left rotate the RBTree at Node x.
	 * @param T
	 * @param x
	 */
	public void leftRotate(RBTree T, Node x) {		
		
		Node y = new Node();
		y = x.right;
		x.right = y.left;
		
		if(y.left!=nil)
			y.left.parent = x;
		y.parent = x.parent;
		if(x.parent == nil)
			T.root = y;
		else if(x == x.parent.left)
			x.parent.left = y;
		else
			x.parent.right = y;
		y.left = x;
		x.parent = y;
		x.updateNode();
		updateHeight();
	}
	
	/**
	 * right rotate the RBTree T at Node x.
	 * @param T
	 * @param x
	 */
	public void rightRotate(RBTree T, Node x) {
		
		Node y = new Node();
		y = x.left;
		x.left = y.right;
		
		if(y.right!=nil)
			y.right.parent = x;
		y.parent = x.parent;
		if(x.parent == nil)
			T.root = y;
		else if(x == x.parent.right)
			x.parent.right = y;
		else
			x.parent.left = y;
		y.right = x;
		x.parent = y;
		x.updateNode();
		updateHeight();
	}
	
	/**
	 * insert a new Node z into the RBTree T.
	 * @param T
	 * @param z
	 */
	public void insert(RBTree T, Node z) {
		
		size++;
		Node y = nil;
		Node x = T.root;
		
		while(x!=nil) {
			y = x;
			if(z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;
		if(y==nil){
			T.root = z;
			z.color=1;
			z.left = nil;
			z.right = nil;
			return;
		}
		else if(z.key < y.key)
			y.left = z;
		else
			y.right = z;
		
		z.left = nil;
		z.right = nil;
		z.color = 0;
		z.updateNode();
		updateHeight();
		insertFixup(T, z);

	}
	
	/**
	 * fix up the colors, positions of a RBTree T at Node z.
	 * @param T
	 * @param z
	 */
	public void insertFixup(RBTree T, Node z) {
		
		while(z.parent.color == 0) {
			
			if(z.parent == z.parent.parent.left) {
				Node y = new Node();
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
				Node y =new Node();
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