/**
 * Team members:
 * 
 * @author Yingxie Gao
 * @author 
 * 
 *         Node class for RBTree.
 */
public class Node {

	Node right;
	Node left;
	Node parent;
	int key;
	int p;
	int val;
	int maxval;
	Endpoint endpoint;
	Endpoint emax;
	int color;

	/**
	 * Initializes a new Node object with its key, and the p.
	 * 
	 * @param key e of this node
	 * @param p p(e), which is to tell if this node is a left or
	 * right endpoint. If left p=1, else p=-1;
	 * @param endpoint the endpoint of this node
	 */
	public Node(int key, int p, Endpoint endpoint)
	{
		right = null;
		left = null;
		parent = null;
		this.key = key;
		this.p = p;
		if(this.isNil()==true){
			val = 0;
		}
		else{
			this.val = this.left.val + this.p + this.right.val;
		}
		maxval = Math.max(this.left.maxval, Math.max(this.left.val + this.p, this.left.val + this.p + this.right.maxval));
		this.endpoint = endpoint;
		//TODO: Add code as needed.  how to get emax;
		color = 1;
	}
	/**
	 * Returns the parent of this node.
	 * @return
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Returns the left child.
	 * 
	 * @return
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Returns the right child.
	 * 
	 * @return
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Returns the endpoint value, which is an integer.
	 * 
	 * @return
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Returns the value of the functionpbased on this endpoint.
	 * 
	 * @return
	 */
	public int getP() {
		return p;
	}

	/**
	 * Returns the val of the node as described in this assignment.
	 * 
	 * @return
	 */
	public int getVal() {
		return val;
	}

	/**
	 * Returns the maxvalof the node as described in this assignment.
	 * 
	 * @return
	 */
	public int getMaxVal() {
		return maxval;
	}

	/**
	 * Returns theEndpointobject that this node represents.
	 * 
	 * @return
	 */
	public Endpoint getEndpoint() {
		return endpoint;
	}

	/**
	 * Returns an Endpoint object that represents emax. Calling this method on the
	 * root node will give the Endpoint object whose getValue() provides a point of
	 * maximum overlap.
	 * 
	 * @return
	 */
	public Endpoint getEmax() {
		return emax;
	}

	/**
	 * Returns 0 if red. Returns 1 if black.
	 * 
	 * @return
	 */
	public int getColor() {
		return color;
	}

	// Add more functions as you see fit.
	public boolean isNil() {
		if(this.left == null && this.right ==null)
		return true;
		else
		return false;
	}
}
