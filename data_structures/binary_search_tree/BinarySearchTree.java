// BinarySearchTree.java

// Description: Implementation of an unbalanced binary search tree in java
// Author: Ian Zapolsky (10/26/13)

import java.util.ArrayList;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertRecursively(int data) {

        Node n = new Node(data);

        // Handle null root
        if (root == null) {
            root = n;
            return;
        }

        root = insertRecurse(root, n);
    }

    private Node insertRecurse(Node cur, Node toInsert) {
        
        if (cur == null)
            return toInsert;
        
        if (toInsert.data <= cur.data)
            cur.left = insertRecurse(cur.left, toInsert);
        else
            cur.right = insertRecurse(cur.right, toInsert);
        
        return cur;
    }

    // This algorithm is iterative, not recursive. There is a better way... ^
    public void insert(int data) {

        Node n = new Node(data);
        
        // Handle edge case where root is null
        if (root == null) {
            root = n;
            return;
        }
          
        Node cur = root;
        for (;;) {
            if (n.data < cur.data) {
                if (cur.left != null)
                    cur = cur.left;
                else {
                    cur.left = n;
                    return;
                }
            }
            else {
                if (cur.right != null)
                    cur = cur.right;
                else {
                    cur.right = n;
                    return;
                }
            }
        }
    }

    // Removes first occurrence of data on the tree
    public void remove(int data) {
        root = removeRecurse(root, data);
    }

    private Node removeRecurse(Node cur, int data) {
        if (cur == null)
            return null;

        if (cur.data == data) {

            // Leaf node case:
            if (cur.left == null && cur.right == null)
                return null;

            // One child case:
            else if (cur.left != null && cur.right == null)
                return cur.left;
            else if (cur.left == null && cur.right != null)
                return cur.right; 

            // Two children case:
            else {
                cur.data = findMinNode(cur.right).data;
                cur.right = removeRecurse(cur.right, cur.data);
                return cur;
            }
        }
        
        else if (data < cur.data)
            cur.left = removeRecurse(cur.left, data);
        else
            cur.right =  removeRecurse(cur.right, data);
        return cur;
    }

    private Node findMinNode(Node cur) {
        if (cur.left == null)
            return cur;
        else 
            return findMinNode(cur.left);
    }

    public int size() {
        return sizeRecurse(root);
    }
    private int sizeRecurse(Node cur) {
        if (cur == null)
            return 0;
        return sizeRecurse(cur.left)+1+sizeRecurse(cur.right);
    }

    public int maxDepth() {
        return maxDepthRecurse(root, 0);
    }
    private int maxDepthRecurse(Node cur, int cur_depth) {
        if (cur == null)
            return cur_depth;
        return Math.max(maxDepthRecurse(cur.left, cur_depth+1),
                        maxDepthRecurse(cur.right, cur_depth+1));
    }

    // This recursive algorithm does not assume the tree it is working on is
    // an ordered binary tree, it searches every node in the tree. 
    public int minValue() {
        return minValueRecurse(root, null);
    }
    private int minValueRecurse(Node cur, Integer cur_min) {
        if (cur == null)
            return cur_min;
        if (cur_min == null)
            cur_min = cur.data;
        else if (cur.data < cur_min)
            cur_min = cur.data;
        return Math.min(minValueRecurse(cur.left, cur_min),
                        minValueRecurse(cur.right, cur_min));

        // Substitute the following return statement to take advants of the
        // ordering of a binary search tree:
        // return minValueRecurse(cur.left, cur_min);
    }

    public boolean hasPathSum(int sum) {
        return hasPathSumRecurse(root, sum);
    }
    private boolean hasPathSumRecurse(Node cur, int sum) {
        if (cur == null && sum == 0)
            return true;
        else if (cur == null || sum < 0)
            return false;
        if (hasPathSumRecurse(cur.left, sum-cur.data) == true ||
            hasPathSumRecurse(cur.right, sum-cur.data) == true)
            return true;
        else
            return false;
    }

    // Good lesson in the behavior of objects across branches of recursion.
    // Though I was passing path through different levels of recursion, the
    // changes I made in one branch were definitely persistent in another,
    // meaning that when I added a node to path and then stepped up a level
    // in the recursion, that leaf node was still there. Therefore, steps
    // are taken below to carefully remove the last node after each recursion.
    public String printPaths() {
        ArrayList<Integer> path = new ArrayList<Integer>();
        return printPathsRecurse(root, path);
    }
    private String printPathsRecurse(Node cur, ArrayList<Integer> path) {
        if (cur == null)
            return "";
        path.add(cur.data);
        
        if (cur.left == null && cur.right == null) {
            String result = evaluatePath(path)+"\n";
            path.remove(path.size()-1);
            return result;
        }
        else {
            String result = (printPathsRecurse(cur.left, path)+""+
                             printPathsRecurse(cur.right, path));
            path.remove(path.size()-1);
            return result;
        }
    }
    private String evaluatePath(ArrayList<Integer> path) {
        String result = "";
        for (Integer i : path)
            result += i+" ";
        return result;
    }

    public void mirror() {
        mirrorRecurse(root);
    }
    private void mirrorRecurse(Node cur) {
        if (cur == null)
            return;
        mirrorRecurse(cur.left);
        mirrorRecurse(cur.right);
        Node temp = cur.right;
        cur.right = cur.left;
        cur.left = temp;
    }

    public void doubleTree() {
        doubleTreeRecurse(root);
    }
    private void doubleTreeRecurse(Node cur) {
        if (cur == null)
            return;
        doubleTreeRecurse(cur.left);
        doubleTreeRecurse(cur.right);
        Node after = cur.left;
        Node duplicate = new Node(cur.data);
        cur.left = duplicate;
        duplicate.left = after;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTreeRecurse(root, 
                                         Integer.MIN_VALUE, 
                                         Integer.MAX_VALUE);
    }

    public boolean isBinarySearchTreeRecurse(Node cur, 
                                             Integer min, 
                                             Integer max) {
        if (cur == null)
            return true;
    
        boolean leftOk = isBinarySearchTreeRecurse(cur.left, min, cur.data);
        boolean rightOk = isBinarySearchTreeRecurse(cur.right, 
                                                    cur.data+1, 
                                                    max); 
        if (leftOk == true && rightOk == true)
            return true;
        else
            return false;
    }

    public boolean isLessOrEqual(Node cur, int target) {
        if (cur == null)
            return true;
        if (cur.data <= target)
            return isLessOrEqual(cur.left, cur.data);
        else
            return false;
    }

    public boolean isMore(Node cur, int target) {
        if (cur == null)
            return true;
        if (cur.data > target)
            return isMore(cur.left, cur.data);
        else
            return false;
    } 
            
    public boolean isBalanced() {
        return isBalancedRecurse(root);
    }
    public boolean isBalancedRecurse(Node cur) {
        if (cur == null)
            return true;
        
        if (Math.abs(maxDepthRecurse(cur.left, 0) - 
                     maxDepthRecurse(cur.right, 0)) <= 1) {
            boolean leftOK = isBalancedRecurse(cur.left);
            boolean rightOK = isBalancedRecurse(cur.right);
            if (leftOK == true && rightOK == true)
                return true;
            else
                return false;
        } 
        else
            return false;
    }
            
    public boolean lookup(int data) {
        return lookup(root, data);
    }

    private boolean lookup(Node cur, int data) {
        
        if (cur == null)
            return false;
        
        if (cur.data == data)
            return true;
        else {
            if (data < cur.data)
                return lookup(cur.left, data);
            else
                return lookup(cur.right, data);
        }
    }

    public String printInOrder() {
        return printInOrder(root);
    }
    private String printInOrder(Node n) {
        if (n == null)
            return "";
        else 
            return (printInOrder(n.left)+""+n.data+" "+printInOrder(n.right));
    }

    public String printPreOrder() {
        return printPreOrder(root);
    }
    private String printPreOrder(Node n) {
        if (n == null)
            return "";
        else
            return (n.data+" "+printPreOrder(n.left)+""+printPreOrder(n.right));
    }

    public String printPostOrder() {
        return printPostOrder(root);
    }
    private String printPostOrder(Node n) {
        if (n == null)
            return "";
        else
            return (printPostOrder(n.left)+""+printPostOrder(n.right)+""+n.data+" ");
    }

    public Node DepthFirstSearch(int target) {
        return DFSRecurse(root, target);
    }
    private Node DFSRecurse(Node cur, int target) {
        if (cur == null)
            return null;
        Node result = DFSRecurse(cur.left, target);
        if (result != null)
            return result;
        else if (cur.data == target)
            return cur;
        else
            return DFSRecurse(cur.right, target);
    }

    public Node BreadthFirstSearch(int target) {
        if (root == null)
            return null;
        
        Queue<Node> q = new Queue<Node>();
        q.enqueue(root);
  
        while (!q.isEmpty()) {
            Node cur = q.dequeue();
            if (cur.data == target)
                return cur;
            else {
                if (cur.left != null)
                    q.enqueue(cur.left);
                if (cur.right != null)
                    q.enqueue(cur.right);
            }
        }
        return null;
    }

}
            
        
        
        
        
    
        

        
        
