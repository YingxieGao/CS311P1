/**
 * Team members:
 * Yingxie Gao
 * Zhenwei Su
 * Jiawei Deng
 * 
 * @author Yingxie Gao
 * 
 * Endpoint class for Node.
 */
public class Endpoint {
	int value;

	/**
	 * Constructor for Endpoint
	 */
	public Endpoint(int value)
	{
		this.value = value;
	}
	
	/**
	 * returns the endpoint value.  For example if the
	 * End point object represents the left endpoint of the 
	 * interval [1,3], this would return 1.
	 * @return
	 */
	public int getValue() {
		
		return value;
	}
}
