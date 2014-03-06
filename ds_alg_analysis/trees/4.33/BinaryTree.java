// Problem 4.33
// Write a recursive method that takes a reference to the root 
// node of a tree T and returns a reference to the root node
// of the tree that results from removing all leaves from T.
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

	public void removeLeaves() {
		root = removeLeaves(root);
	}

	private Node removeLeaves(Node t) {

		if (t == null)
			return null;

		if (t.left == null && t.right == null)
			return null;
		
		t.left = removeLeaves(t.left);
		t.right = removeLeaves(t.right);
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
