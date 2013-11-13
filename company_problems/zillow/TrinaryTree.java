// TrinaryTree.java

// Description: Implement insert and delete on a tri-nary tree, where left
// child is < root, middle child == root, and right child > root.
// Author: Ian Zapolsky (11/12/13)

public class TrinaryTree {

    Node root;
    
    public TrinaryTree() {
        root = null;
    }

    public void insert(int data) {
       
        Node new_node = new Node(data);
        if (root == null)
            root = new_node;
        else
            insertRecurse(root, new_node);
    }

    private Node insertRecurse(Node cur, Node new_node) {
        if (cur == null)
            return new_node;
        if (new_node.data < cur.data)
            cur.left = insertRecurse(cur.left, new_node);
        else if (new_node.data == cur.data)
            cur.cntr = insertRecurse(cur.cntr, new_node);
        else 
            cur.right = insertRecurse(cur.right, new_node);
        return cur;
   }

    /*
    // Deletes the first matching value in the tree.
    public boolean delete(int data) {
        if (deleteRecurse(root, data) == true)
            return true;
        else
            return false;
    }

    public boolean deleteRecurse(Node root, int target)
    */
    



    public String printInorder() {
        return inorderRecurse(root);
    }

    private String inorderRecurse(Node current) {
        if (current == null)
            return "";
        return (inorderRecurse(current.left)+inorderRecurse(current.cntr)+
                current.data+", "+inorderRecurse(current.right));
    }
        
    static class Node {
        
        int data;
        Node left, cntr, right;

        public Node(int init_data) {
            data = init_data;
            left = null;
            cntr = null;
            right = null;
        }
    }
}

