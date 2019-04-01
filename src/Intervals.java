import java.util.Arrays;

/**
 * Team members: Yingxie Gao Zhenwei Su Jiawei Deng
 * 
 * @author Yingxie Gao
 * @author Zhenwei Su
 * @author Jiawei Deng
 * 
 *         A wrapper class for RBTree
 */
public class Intervals {
	// private int ID = 0; //If deletion is done, this could be used to keep track
	// of edpoints
	// for the same interval.
	RBTree tree = new RBTree(); // create a new RB tree

	/**
	 * Constructor with no parameters.
	 */
	public Intervals() {

	}

	/**
	 * 
	 * Adds the interval with left endpoint a and right endpoint b to the collection
	 * of intervals. Each newly inserted interval must be assigned an ID. The IDs
	 * should be consecutive; that is, the ID of the interval inserted on the ith
	 * call of this method should be i. For example if intervalInsert is called
	 * successively to insert intervals [5,7],[4,9],[1,8], then the IDs of these
	 * intervals should be 1,2,3, respectively.These IDs are permanent for the
	 * respective intervals. Keep track of the IDs, as multiple intervals that have
	 * the same endpoints on both sides can be added. intervalInsertshould run in
	 * O(logn)time
	 * 
	 * @param a
	 * @param b
	 */
	void intervalInsert(int a, int b) {
		Endpoint e1 = new Endpoint(a); // create the first endpoint for a
		Node a1 = new Node(1, e1); // make the endpoingt to a node and letf endpoint will add 1
		tree.insert(tree, a1); // insert the left endpoingt as a node to RB tree

		Endpoint e2 = new Endpoint(b); // cearte the right endpoing for b
		Node a2 = new Node(-1, e2); // make the endpoint to a node and right endpoingt will minues 1
		tree.insert(tree, a2); // insert the right endpoint as a node to RB tree

	}

	/**
	 * To delete an interval from delete.
	 * 
	 * 
	 * Deletes the interval whose ID (gener-ated byintervalInsert) isintervalID.
	 * Returnstrueif deletion was successful. Thismethod should run
	 * inO(logn)time.Note.TheintervalDeletemethod isoptional; that is, you are not
	 * requiredto implement it. However, your code must provide an interval Delete
	 * method even if you choose not to implement interval deletion. If you do not
	 * implement deletion, the interva lDelete method should consist of just one
	 * line that returns false.
	 * 
	 * @param intervalID
	 * @return
	 */
	boolean intervalDelete(int intervalID) {

		return false;
	}

	/**
	 * Finds the endpoint that has maximum overlap and returns its value. This
	 * method should run in constant time.
	 * 
	 * @return
	 */
	int findPOM() {

		return tree.root.maxval; // the value of the maxval in the root of RB tree is the maximun overlap
	}

	/**
	 * Returns the red-black tree used, which is an object of typeRBTree.
	 * 
	 * @return
	 */
	RBTree getRBTree() {
		return tree;
	}

	// Add more functions as you see fit.

	/**
	 * This is a suggested way on how to add intervals and call POM()
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int points[][] = { { 0, 4 }, { 1, 6 }, { 3, 9 }, { 7, 11 } };
		Intervals intv = new Intervals();

		for (int i = 0; i < points.length; i++) {
			// System.out.println("Inserting: "+ Arrays.toString(points[i]));
			intv.intervalInsert(points[i][0], points[i][1]);
			System.out.println(intv.getRBTree().getRoot());
		}
		System.out.println("POM is: " + intv.findPOM()); // Should return 3.

	}
}
