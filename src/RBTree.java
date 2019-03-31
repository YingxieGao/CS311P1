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
	Node nil = new Node();
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
		return size;
	}
	
	
	/**
	 * Returns the height of the tree.
	 * @return height
	 */


	
	//Add more functions as  you see fit.
	
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
		x.updateNode();;
		
	}
	
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
		x.updateNode();;
	}
	
	public void insert(RBTree T, Node z) {
		
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
		insertFixup(T, z);

	}
	
	public void inOrderUpdate(Node x) {
		if(x!=nil) {
			inOrderUpdate(x.left);
			x.updateNode();
			inOrderUpdate(x.right);
		}
	}
	
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
	
	public void RBTransplant(RBTree T, Node u, Node v){
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