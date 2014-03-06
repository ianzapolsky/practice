// Problem 4.31
// Write efficient methods that take a reference to the root of a binary tree,
// T, and compute:
//   a. the number of nodes in T
//   b. the number of leaves in T
//   c. the number of full nodes in T
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

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(Node t) {
		if (t == null)
			return 0;
		if (t.left == null && t.right == null)
			return 1;
		return 1 + countNodes(t.left) + countNodes(t.right);
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node t) {
		if (t == null)
			return 0;
		if (t.left == null && t.right == null)
			return 1;
		return countLeaves(t.left) + countLeaves(t.right);
	}

	public int countFullNodes() {
		return countFullNodes(root);
	}

	private int countFullNodes(Node t) {
		if (t == null)
			return 0;
		if (t.left == null || t.right == null)
			return 0;
		return 1 + countFullNodes(t.left) + countFullNodes(t.right);

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
