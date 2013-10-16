// Main.java

// Description: Write code to remove duplicates from a singly linked list.
// FOLLOW UP: Do it w/o a temporary buffer
// Author: Ian Zapolsky (10/16/13)

import java.util.HashMap;

public class Main {
    
    // Remove all duplicates from list in one traversal by using a HashMap as
    // a temporary buffer to store seen elements.
    public static void removeDuplicatesBuf(SinglyLinkedList list) {
        
        // Check that list has any elements.
        if (list.head == null)
            return;

        HashMap<Integer, Integer> buf = new HashMap<Integer, Integer>();
        Node current = list.head;
        
        // Add head.data because there is no way it could be a duplicate.
        buf.put(current.data, current.data);
        
        // Scan through list, checking against buf to see if element has been
        // seen before.
        while (current.next != null) {
            if (buf.get(current.next.data) != null) {
                current.next = current.next.next;
            }
            else {
                buf.put(current.next.data, current.next.data);
                current = current.next;
            }
        }
    }

    public static void removeDuplicatesNoBuf(SinglyLinkedList list) {
        
        // Check that list has any elements.
        if (list.head == null)
            return;
           
        Node ptr1 = list.head;
        
        // Simulate nested for loop with two pointers and two while loops.
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

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        list.insertHead(2);
        list.insertHead(5);
        list.insertHead(2);
        list.insertHead(5);
        System.out.println(list);
        
        removeDuplicatesBuf(list);
        // removeDuplicatesNoBuf(list);
    
        System.out.println(list);
    }
}








                
        
