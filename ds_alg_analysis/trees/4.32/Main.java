// write efficient methods that take a reference to the root of a binary tree,
// T, and compute:
//   a. the number of nodes in T
//   b. the number of leaves in T
//   c. the number of full nodes in T

public class Main {

    public static void main(String[] args) {

    	BinaryTree bt = new BinaryTree();
    	bt.insert(5);
    	bt.insert(4);
    	bt.insert(10);
    	bt.insert(2);
    	System.out.println(bt.isSearchTree());
    }
}
        
