// Main.java

// Description: Given a singly linked list with a loop, implement an algorithm
// that returns the node at the beginning of the loop. Also implement an
// algorithm to determine if a linked list has a loop.
// Author: Ian Zapolsky (10/20/13)

public class Main {

    public static boolean hasLoop(SinglyLinkedList list) {
        
        Node slow = list.head;
        Node fast = list.head;

        slow = slow.next;
        fast = fast.next.next;

        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast || slow == fast.next)
                return true;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    // Assumes that list DOES have a loop
    public static Node findLoopStart(SinglyLinkedList list) {
        
        Node slow = list.head;
        Node fast = list.head;
    
        slow = slow.next;
        fast = fast.next.next;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = list.head;
        while (slow != fast) { 
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
        
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertHead(1);
        list.insertHead(4);
        list.insertHead(6);
        list.insertHead(7);

        // Create a loop in list.
        Node a = list.head;
        Node b = list.head;
        a = a.next.next.next;
        b = b.next;
        a.next = b;
        
        System.out.println(hasLoop(list));
        Node start = findLoopStart(list);
        System.out.println(start.data);
    }
}
        
            
