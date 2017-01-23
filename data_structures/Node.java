package data_structures;

public class Node<T>
{
	public Node(T x)
	{
		this.valude = x;
		this.next = null;
	}
	
	public Node(T x, Node<T> next)
	{
		this.valude = x;
		this.next = next;
	}
	
	public T getValue()
	{
		return valude;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public boolean hasNext()
	{
		return next != null;
	}
	
	public String toString()
	{
		return valude + " --> " + next;
	}
	
	public void setValue(T x)
	{
		valude = x;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	private T valude;
	private Node<T> next;
}
