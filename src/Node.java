/**
 * Team members: Yingxie Gao Zhenwei Su Jiawei Deng
 * 
 * @author Yingxie Gao Node class for RBTree.
 */
public class Node {

	private static final Node NILNode = new Node();

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
	 * @param key      e of this node
	 * @param p        p(e), which is to tell if this node is a left or right
	 *                 endpoint. If left p=1, else p=-1;
	 * @param endpoint the endpoint of this node
	 */
	public Node(int p, Endpoint endpoint) {
		right = NILNode;
		left = NILNode;
		parent = NILNode;
		this.key = endpoint.value;
		this.p = p;
		if (this.isNil() == true) {
			val = 0;
		} else {
			this.val = this.left.val + this.p + this.right.val;
		}
		maxval = Math.max(this.left.maxval,
				Math.max(this.left.val + this.p, this.left.val + this.p + this.right.maxval));
		this.endpoint = endpoint;
		if (maxval == this.left.maxval) {
			emax = this.left.endpoint;
		}

		else if (maxval == this.left.val + this.p) {
			emax = this.endpoint;
		}

		else {
			emax = this.right.endpoint;
		}

		color = 1;

	}

	/**
	 * Constructor for NILNode
	 */
	public Node() {
		right = NILNode;
		left = NILNode;
		parent = NILNode;
		val = 0;
		maxval = 0;
		p=0;
		key=-1;
		endpoint = null;
		emax = null;
		color = 1;
	}

	/*
	 * static Node NILNode; static { NILNode = new Node(); NILNode.parent = NIL;
	 * NILNode.left = NIL; NILNode.right = NIL; NILNode.val = 0; NILNode.maxval = 0;
	 * NILNode.endpoint = null; NILNode.emax = null; NILNode.color = 1; }
	 */

	/**
	 * Returns the parent of this node.
	 * 
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

	/**
	 * Returns if this node is nil.
	 * 
	 * @return
	 */
	public boolean isNil() {
		if (this == NILNode)
			return true;
		else
			return false;
	}

	/**
	 * Update Node when needed.
	 */
	public void updateNode() {
		if (this.isNil() == true) {
			val = 0;
		} else {
			this.val = this.left.val + this.p + this.right.val;

		}

	}
}
