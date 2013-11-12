// MaxHeap.java

// Description: Node implementation of a max heap.
// Author: Ian Zapolsky (10/29/13)

public class MaxHeap {

    Node root;

    public MaxHeap() {
        root = null;
    }

    public void insert(int data) {
        insert(root, data); 
    }
    private void insert(Node current, data) {
        if (current.left == null) 
        

    public void bubbleDown(Node insert) {
        root = bubbleDown(root, insert);
    }

    public Node bubbleDown(Node current, Node insert) {
        if (current == null)
            return null;
        if (insert.data > current.data)
            insert.
    
