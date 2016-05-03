package myextension.solved;

public interface PriorityQueue<T extends Comparable<T>> {
	
	public boolean isEmpty();
	public Node<T> insert(T thing);

}
