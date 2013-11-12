// Node.java

// Description: A standard node which holds an int as data for a java
// implementation of a binary search tree
// Author: Ian Zapolsky (10/26/13)

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int init_data) { 
        data = init_data;
        left = null;
        right = null;
    }

}
