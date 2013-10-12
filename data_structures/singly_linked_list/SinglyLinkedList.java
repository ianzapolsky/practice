// SinglyLinkedList.java

// description: Implementation of a simple singly linked list in Java,
// following the definition given by the Stanford CS Library: "A single head
// pointer points to the first node in the list. Each node contains a single
// .next pointer to the next node. The .next pointer of the last node is NULL.
// The empty list is represented by a NULL head pointer. All of the nodes are
// allocated in the heap." Note that the last sentence is not relevant here
// because we are implementing in Java.
// author: Ian Zapolsky (10/12/13)

public class SinglyLinkedList {

    Node head;
   
    public SinglyLinkedList() {
        head = null;
    }

    // O(1).
    public void insertHead(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }
    
    // O(n) because we are implementing without a tail pointer. Were we to
    // implement with a tail pointer, we could improve this to O(1).
    public void insertTail(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node current = head;
            while (current.next != null) 
                current = current.next;
            current.next = new_node;
        }
    }

    // O(n)
    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    // O(n)
    public int count(int data) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data)
                count += 1;
            current = current.next;
        }
        return count;
    }

    // O(n) -- basically this is the same as list[n], but obviously the access
    // time is much worse. The advantage of the linked list lies in its memory
    // flexibility.
    public int getNth(int n) throws Exception {
        if (n < 0 || n > length()-1)
            throw new Exception();
        Node current = head;
        while (n-- != 0)
            current = current.next;
        return current.data;
    }

    // O(1)
    public void deleteList() {
        head = null;
    }

    // O(1)
    public int popHead() throws Exception {
        if (head == null)
            throw new Exception();
        int data = head.data;
        head = head.next;
        return data;
    }

    // O(n). Same story with the tail pointer as above. 
    public int popTail() throws Exception {
        if (head == null) {
            throw new Exception();
        } else if (head.next == null) {
            return popHead();
        } else {
            Node current = head;
            while (current.next.next != null)
                current = current.next;
            int data = current.next.data;
            current.next = null;
            return data;
        }
    }

    // O(n)
    public void insertNth(int n, int data) throws Exception {
        if (n < 0 || n > length())
            throw new Exception();
        Node new_node = new Node(data);
        Node current = head;
        if (n == 0) {
            new_node.next = head;
            head = new_node;
        } else {
            while (--n > 0) 
                current = current.next;
            Node temp = current.next;
            current.next = new_node;
            new_node.next = temp;
        }
    }

    // Insert a Node into a list that is assumed to be sorted in increasing
    // order.
    // O(n)
    public void sortedInsert(Node new_node) {
        if (head == null) {
            head = new_node;
        } else {
            Node current = head;
            if (head.data > new_node.data) {
                new_node.next = head;
                head = new_node;
            } else {
                while (current.next != null) {
                    if (current.next.data < new_node.data) {
                        current = current.next;
                    } else {
                        new_node.next = current.next;
                        current.next = new_node;
                        return;
                    }
                }
                current.next = new_node;
            }
        }
    }

    public void sortedInsert(int data) {
        Node new_node = new Node(data);
        sortedInsert(new_node);
    }

    // O(n)
    public String toString() {
        if (length() == 0) {
            return "[]";
        } else {
            String result = "[";
            Node current = head;
            while (current != null) {
                result += current.data+"]->[";
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
            
    static class Node {

        int data;
        Node next;

        public Node(int init_data) {
            data = init_data;
            next = null;
        }
    }

}
