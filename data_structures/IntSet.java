package data_structures;

public class IntSet //עץ בינארי ממויין בחיפוש בינארי
{
	public IntSet()
	{
		root = null;
	}
	
	public void insert(int value)
	{
		if (root == null) {
			root = new BinNode<Integer>(value);
		} else {
			insert(value, root);
		}
	}
	
	private void insert(int value, BinNode<Integer> node)
	{
		if (node.getValue() == value) {
			return;
		}
		if (value < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(new BinNode<Integer>(value));
			} else {
				insert(value, node.getLeft());
			}
		} else {
			if (node.getRight() == null) {
				node.setRight(new BinNode<Integer>(value));
			} else {
				insert(value, node.getRight());
			}
		}
	}
	
	public void remove(int value)
	{
		BinNode<Integer> node = root;
		if (node.getLeft().getValue() == value) {
			node.getLeft() = null;
		}
		if (node.getRight().getValue() == value) {
			node.getRight() = null;
		}
		if (value < node.getValue()) {
			return remove();
		}
	}
	
	public boolean lookup(int value)
	{
		return lookup(value, root);
	}
	
	private boolean lookup(int value, BinNode<Integer> node)
	{
		if (node.getValue() == value) {
			return true;
		}
		if ((value < node.getValue()) && (node.getLeft() != null)) {
			return lookup(value, node.getLeft());
		}
		if ((value > node.getValue()) && (node.getRight() != null)) {
			return lookup(value, node.getRight());
		}
		return false;
	}
	
	private BinNode<Integer> root;
}
