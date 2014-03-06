// Problem 4.32
// Design a recursive linear-time algorithm that tests whether
// a binary tree satisfies the search tree order property at
// every node.
// Ian Zapolsky (02/08/14)

public class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int data) {
		root = insert(data, root);
	}

	private Node insert(int data, Node t) {

		// make a new leaf
		if (t == null) {
			return new Node(data);
		}
		else if (data < t.data) {
			t.left = insert(data, t.left);
		}
		else {
			t.right = insert(data, t.right);
		}
  		return t;
	}

	public boolean isSearchTree() {
		return isSearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isSearchTree(Node t, Integer min, Integer max) {

		if (t == null)
			return true;

		boolean leftOK = isSearchTree(t.left, min, t.data);
		boolean rightOK = isSearchTree(t.right, t.data, max);

		if (leftOK && rightOK)
			return true;
		return false;
	}

	private static class Node {

		int data;
		Node left;
		Node right;

		public Node(int init_data) {
			data = init_data;
			left = null;
			right = null;
		}

		public String toString() {
			return ""+data;
		}
	}

}
