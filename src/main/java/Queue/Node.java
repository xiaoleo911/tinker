package Queue;

public class Node<E> {
	Node<E> next = null;
	E data;
	public Node(E data){
		this.data = data;
	}
}
