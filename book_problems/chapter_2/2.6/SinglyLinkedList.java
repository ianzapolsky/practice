// SinglyLinkedList.java

// description: Implementation of a simple singly linked list in Java,
// following the definition given by the Stanford CS Library: "A single head
// pointer points to the first node in the list. Each node contains a single
// .next pointer to the next node. The .next pointer of the last node is NULL.
// The empty list is represented by a NULL head pointer. All of the nodes are
// allocated in the heap." Note that the last sentence is not relevant here
// because we are implementing in Java.
// author: Ian Zapolsky (10/12/13)

import java.util.HashMap;

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
    // time is much worse (O(n) as opposed to O(1)). The advantage of the 
    // linked list lies in its memory flexibility.
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
        // Handle empty list case
        if (head == null) { 
            head = new_node;
        } 
        // Else handle the other two cases:
        else { 
            Node current = head;
            // Case 1: new_node is smaller than current head and so becomes the
            // new head.
            if (head.data > new_node.data) {
                new_node.next = head;
                head = new_node;
            } 
            // Case 2: new_node is not smaller than current head and so we
            // begin moving forward through the list, searching for the first
            // node that is bigger than new_node.
            else {
                while (current.next != null) {
                    if (current.data < new_node.data) {
                        current = current.next;
                    } else {
                        new_node.next = current.next;
                        current.next = new_node;                    
                        return;
                    }
                }
                // If we never find a node bigger than new_node, slide new_node
                // in at the end of the list.
                current.next = new_node;
            }
        }
    }

    // Variant of sortedInsert that takes an int as argument.
    public void sortedInsert(int data) {
        Node new_node = new Node(data);
        sortedInsert(new_node);
    } 

    // Rearrange the list into sorted order, making use of sortedInsert() and a
    // second list.
    // O(n), O(n)
    public void insertSort() {
        Node current = head;
        SinglyLinkedList sorted_list = new SinglyLinkedList();
        while (current != null) {
            sorted_list.sortedInsert(current.data);
            current = current.next;
        }
        this.head = sorted_list.head;
    }

    // Append other to the end of this.
    public void append(SinglyLinkedList other) {
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = other.head;
        other.deleteList();
    }

    // Splits this down the middle into a front list and a back list. If there 
    // are an odd number of elements, the front list gets the extra. Note that
    // this method destroys the list on which it is applied.
    public void frontBackSplit(SinglyLinkedList front, SinglyLinkedList back) {    
        Node frontPtr = head;
        Node backPtr = head;
        boolean even = true;
            
        // Special handling for lists of length < 2.
        if (length() <= 2) {
            if (length() == 2) {
                backPtr = head.next;
                back.head = backPtr;
                frontPtr.next = null;
                front.head = frontPtr;
                return;
            } else if (length() == 1) {
                back.head = null;
                front.head = frontPtr;
                return;
            } else {
                back.head = null;
                front.head = null;
                return;
            }
        }
        
        // Scan through list with two pointers, one moving two at a time, one
        // moving one at a time.
        while (backPtr != null) {
            if (backPtr.next == null) {
                even = false;
                break;
            } 
            frontPtr = frontPtr.next;
            backPtr = backPtr.next.next;
        }
        
        // If there are an odd number of elements on the list, frontPtr.next
        // should be the head of the back list.
        if (even == false) {
            backPtr = frontPtr.next;
            frontPtr.next = null;
            frontPtr = head;
            front.head = frontPtr;
            back.head = backPtr;
            return;
        } 
        // If there are an even number of elements on the list, frontPtr should
        // be the head of the back list.
        else {
            backPtr = frontPtr;
            back.head = backPtr;
            frontPtr = head;
            while (frontPtr.next != backPtr)
                frontPtr = frontPtr.next;
            frontPtr.next = null;
            frontPtr = head;
            front.head = frontPtr;
            return;
        }
    }

    // Removes all duplicates from the list, using a HashMap as temporary
    // buffer.
    public void removeDuplicates() {
        HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();
        if (head == null)
            return;
        Node current = head;
        buffer.put(current.data, current.data);
        while (current.next != null) {
            if (buffer.get(current.next.data) != null) {
                current.next = current.next.next;
            }
            else {
                buffer.put(current.next.data, current.next.data);
                current = current.next;
            }
        }
    }

    public void removeDuplicatesNoBuf() {
        Node ptr1 = head;
        while (ptr1 != null) {
            Node ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr2.next.data == ptr1.data)
                    ptr2.next = ptr2.next.next;
                else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    public void reverse() {
        if (length() <= 1)
            return;
        Node a = head;
        Node b = head.next;
        recurse_reverse(a, b);
        a.next = null;
    }

    public void recurse_reverse(Node a, Node b) {
        if (b == null) {
            head = a;
            return;
        }
        recurse_reverse(a.next, b.next);
        b.next = a;
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
            
    /*
    static class Node {

        int data;
        Node next;

        public Node(int init_data) {
            data = init_data;
            next = null;
        }
    }
    */

}
