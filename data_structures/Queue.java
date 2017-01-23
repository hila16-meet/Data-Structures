package data_structures;

public class Queue<T> {

	public Queue()
	{
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public T head()
	{
		return first.getValue();
	}
	
	public void insert(T value)
	{
		Node<T> newNode = new Node<T>(value);
		if (last != null) {
			last.setNext(newNode);
			last = newNode;
		} else {
			first = newNode;
			last = newNode;
		}
	}
	
	public T remove()
	{
		T retValue = first.getValue();
		first = first.getNext();
		if (first == null) {
			last = null;
		}
		return retValue;
	}
	
	public String toString()
	{
		String s = "[";
		for (Node<T> node = first; node != null; node = node.getNext()) {
			s += node.getValue();
			if (node.getNext() != null) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}

	private Node<T> first;
	private Node<T> last;
}
