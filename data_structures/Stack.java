package data_structures;

public class Stack<T> {

	public Stack()
	{
		top = null;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public void push(T value)
	{
		top = new Node<T>(value, top);
	}
	
	public T top()
	{
		return top.getValue();
	}
	
	public T pop()
	{
		T val = top();
		top = top.getNext();
		return val;
	}
	
	public String toString()
	{
		String s = "[";
		for (Node<T> node = top; node != null; node = node.getNext()) {
			s += node.getValue();
			if (node.getNext() != null) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	
	private Node<T> top;
}
