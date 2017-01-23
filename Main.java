import data_structures.BinNode;
import data_structures.Node;
import data_structures.Stack;
import data_structures.Queue;
import data_structures.IntSet;

public class Main {

	public static void main(String[] args) {
		//testNode();
		//testBinNode(6);
		//testStack();
		//testQueue();
//		int[] digits = {1, 3, -9, 1, 2, 3, -9, 3, 4, -9, 6, 6};
//		Node<Integer> firstNode = null;
//		for (int i = digits.length - 1; i >= 0; i--) {
//			firstNode = new Node<Integer>(digits[i], firstNode);
//		}
//		System.out.println(firstNode);
//		System.out.println(listOfNums(firstNode));
//		//System.out.println("ZigZag: " + zigZag2(firstNode));
//		System.out.println("ZigZag: " + zigNzag(firstNode));
		
//		BinNode<Stack<Integer>> root = new BinNode<Stack<Integer>>(new Stack<Integer>());
//		Stack<Integer> s = root.getValue();
//		s.push(7);
//		s.push(9);
//		s.push(4);
//		s.push(8);
//		root.setRight(new BinNode<Stack<Integer>> (new Stack<Integer>()));
//		s = root.getRight().getValue();
//		s.push(2);
//		s.push(1);
//		s.push(8);
//		s.push(1);
//		root.getRight().setLeft(new BinNode<Stack<Integer>> (new Stack<Integer>()));
//		s = root.getRight().getLeft().getValue();
//		s.push(1);
//		s.push(3);
//		root.getRight().setRight(new BinNode<Stack<Integer>> (new Stack<Integer>()));
//		root.getRight().getRight().setLeft(new BinNode<Stack<Integer>> (new Stack<Integer>()));
//		s = root.getRight().getRight().getLeft().getValue();
//		s.push(1);
//		s.push(4);
//		s.push(9);
//		s.push(2);
//		
//		s = treeOfStacks(root);
//		System.out.println(s);
//		dfs_inorder(root);
//		dfs_preorder(root);
//		System.out.println("____________");
//		dfs_postorder(root);
		
		IntSet set = new IntSet();
		set.insert(5);
		set.insert(1);
		set.insert(8);
		set.insert(4);
		set.insert(13);
		set.insert(10);
		set.insert(3);
		System.out.println(set.lookup(2));
	}

	private static void testNode() 
	{
		System.out.println("===== Testing Node =====");
		Node<Integer> firstNode = new Node<Integer>(1);
		Node<Integer> currentNode = firstNode;
		for (int i = 2; i < 10; i++) {
			Node<Integer> newNode = new Node<Integer>(i);
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		System.out.println(firstNode);
		System.out.println("=========================");
	}
	
	private static void testBinNode(int numNodes)
	{
		System.out.println("===== Testing BinNode =====");
		BinNode<Integer> tree = buildTree(numNodes, 0);
		System.out.println(tree);
		System.out.println("=========================");
	}
	
	private static BinNode<Integer> buildTree(int numNodes, int rootValue)
	{
		if (numNodes > 0) {
			BinNode<Integer> rootNode = new BinNode<Integer>(rootValue);
			rootNode.setLeft(buildTree(numNodes/2, rootValue + 1));
			rootNode.setRight(buildTree(numNodes/2, rootValue + 2));
			return rootNode;
		} else {
			return null;
		}
	}
	
	private static void testStack()
	{
		System.out.println("===== Testing Stack =====");
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 1; i < 10; i++) {
			stack.push(i);
		}
		System.out.println("Stack after pushing 9 numbers:");
		System.out.println(stack);
		for (int i = 0; i < 5; i++) {
			System.out.println("Popped value: " + stack.pop());
		}
		System.out.println("Stack after popping 5 times:");
		System.out.println(stack);
		System.out.println("Emptying the stack:");
		while (! stack.isEmpty()) {
			System.out.println("Popped value: " + stack.pop());
		}
		System.out.println("Stack is empty:");
		System.out.println(stack);
		System.out.println("=========================");
	}
	
	private static void testQueue()
	{
		System.out.println("===== Testing Queue =====");
		Queue<Integer> queue = new Queue<Integer>();
		System.out.println("Inserting values 1, 2, 3");
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		System.out.println("Queue: " + queue);
		System.out.println("Remove: " + queue.remove());
		System.out.println("Inserting values 4, 5");
		queue.insert(4);
		queue.insert(5);
		System.out.println("Queue: " + queue);
		System.out.println("Removing until queue is empty...");
		while (! queue.isEmpty()) {
			System.out.println("Remove: " + queue.remove());			
		}
		System.out.println("Queue is empty:" + queue);
		System.out.println("=========================");
	}

	public static Node<Integer> listOfNums(Node<Integer> One)
	{
		Node<Integer> newList = null;
		Node<Integer> newListPos = null;
		int num = 0;
		Node<Integer> pos = One;
		while (pos != null)
		{
			while ((pos != null) && (pos.getValue() != -9))
			{
				num = 10 * num + pos.getValue();
				pos = pos.getNext();
			}
			Node<Integer> newNode = new Node<Integer>(num);
			if (newList == null) {
				newList = newNode;
				newListPos = newNode;
			} else {
				newListPos.setNext(newNode);
				newListPos = newNode;				
			}
			if (pos != null) {
				pos = pos.getNext();
			}
			num = 0;
		}
		return newList;
	}
	
	public static boolean zigNzag(Node<Integer> One)
	{
		Node<Integer> pos1 = listOfNums(One);
		boolean isAscending = false;
		int count = 0;
		
		if (pos1 == null || pos1.getNext() == null)
		{
			return false;
		}
		
		Node<Integer> pos2 = pos1.getNext();

		if (pos1.getValue() < pos2.getValue())
		{
			isAscending = true;
		}
		
		pos1 = pos1.getNext();
		pos2 = pos2.getNext();
		
		while (pos2 != null)
		{
			if (isAscending && pos1.getValue() < pos2.getValue())
			{
				return false;
			}
			else if (!isAscending && pos1.getValue() > pos2.getValue())
			{
				return false;
			}
			count++;
			pos1 = pos1.getNext();
			pos2 = pos2.getNext();
			isAscending = !isAscending;
		}
		
		return (count % 2 == 0);
	}
	
	//
	// Lushi - this is my solution.
	//         Read it only after you try yourself.
	//
	public static boolean zigZag2(Node<Integer> one)
	{
		Node<Integer> pos = listOfNums(one);
		if ((pos == null) || (pos.getNext() == null)) {
			return false;
		}
		int numNodes = 2;
		boolean goingUp = (pos.getValue() < pos.getNext().getValue());
		pos = pos.getNext();
		while (pos.getNext() != null) {
			if ((goingUp && (pos.getValue() < pos.getNext().getValue())) ||
				(!goingUp && (pos.getValue() > pos.getNext().getValue()))) {
				return false;
			}
			pos = pos.getNext();
			numNodes++;
			goingUp = ! goingUp;
		}
		return (numNodes % 2 == 0);
	}
	
	public static <T> void dfs_inorder(BinNode<T> root)
	{
		if (root != null)
		{
			dfs_inorder(root.getLeft());
			System.out.println(root.getValue());
			dfs_inorder(root.getRight());
		}	
	}
	
	public static <T> void dfs_preorder(BinNode<T> root)
	{
		if (root != null)
		{
			System.out.println(root.getValue());
			dfs_preorder(root.getLeft());
			dfs_preorder(root.getRight());
		}
	}
	
	public static <T> void dfs_postorder(BinNode<T> root)
	{
		if (root != null)
		{
			dfs_postorder(root.getLeft());
			dfs_postorder(root.getRight());
			System.out.println(root.getValue());
		}
	}
	
	public static Stack<Integer> treeOfStacks(BinNode<Stack<Integer>> t)
	{
		Stack<Integer> returnedStack = new Stack<Integer>();
		treeOfStacksInternal(t, returnedStack);
		return returnedStack; 
	}
	
	public static void treeOfStacksInternal(BinNode<Stack<Integer>> t, Stack<Integer> s)
	{
		if (t != null)
		{
			treeOfStacksInternal(t.getLeft(), s);
			Stack<Integer> currentStack = t.getValue();
			// calculate new value to push
			int value = 0;
			for (int i = 0; i < 3; i++) {
				if (currentStack.isEmpty()) {
					break;
				}
				value += currentStack.pop();
			}
			// push that value to 's'
			s.push(value);
			treeOfStacksInternal(t.getRight(), s);
		}
	}

}
