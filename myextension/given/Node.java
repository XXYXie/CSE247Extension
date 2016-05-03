package myextension.given;

/**
 * A front office for the MinHeap to handle decrease calls
 * 
* @author Han Liu and Xueyan Xie
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> {
	
	private T thing;
	final int loc;
	
	/**
	 * 
	 * @param thing the thing inserted into the tree
	 * @param loc the current location of the thing in the tree array.
	 */
	public Node(T thing, int loc) {
		this.thing = thing;
		this.loc   = loc;
	}
	
	/**
	 * Handle requests for decreasing the item at location loc
	 * @param newvalue the new value for the item at location loc
	 */
	public void decrease(T newvalue) {
		if (newvalue.compareTo(thing) < 0) {
			this.thing = newvalue;
		}
		else if (newvalue.compareTo(thing) == 0) {
			// do nothing, same value
		}
		else throw new IllegalArgumentException("Value was " + thing + " and cannot be decreased to " + newvalue);
	}
	
	public T getValue() {
		return this.thing;
	}
	
	public String toString() {
		return "" + thing + " at " + loc;
	}

}
