// Queue.java

// Description: Simply ArrayList implementation of generic Queue
// Author: Ian Zapolsky (11/12/13)

public class Queue<T> {
    
    QNode<T> root;

    public Queue() {
        root = null;
    }

    public void enqueue(T data) {
        QNode<T> new_node = new QNode<T>(data);
        new_node.next = root;
        root = new_node;
    }

    public T dequeue() {
        T first = root.data;
        root = root.next;
        return first;
    }
    
    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }
   
    static class QNode<T> {
        
        T data;
        QNode next;

        public QNode(T init_data) {
            data = init_data;
            next = null;
        }
    }
}
            
        

    
    
