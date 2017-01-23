package data_structures;

public class BinNode<T> {

	public BinNode(T x)
	{
		this.value = x;
		this.left = null;
		this.right = null;
	}
	
	public BinNode(T x, BinNode<T> left, BinNode<T> right)
	{
		this.value = x;
		this.left = left;
		this.right = right;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public BinNode<T> getLeft()
	{
		return left;
	}

	public BinNode<T> getRight()
	{
		return right;
	}

	public void setValue(T x)
	{
		value = x;
	}
	
	public void setLeft(BinNode<T> left)
	{
		this.left = left;
	}
	
	public void setRight(BinNode<T> right)
	{
		this.right = right;
	}
	
	public boolean hasLeft()
	{
		return left != null;
	}
	
	public boolean hasRight()
	{
		return right != null;
	}
	
	public String toString()
	{
		return "[" + value + " -left-> " + left + " -right-> " + right + "]";
	}
	
	private T value;
	private BinNode<T> left;
	private BinNode<T> right;
}
