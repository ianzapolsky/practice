// Main.java 

// Description: Implement a function to check if a singly linked list is a
// palindrome.
// Author: Ian Zapolsky (10/17/12)

public class Main {

    public static boolean isSame(SinglyLinkedList a_list, 
                                 SinglyLinkedList b_list) {

        Node a = a_list.head;
        Node b = b_list.head;

        while (a != null && b != null) {
            if (a.data != b.data)
                return false;
            a = a.next;
            b = b.next;           
        }
        if ( (a == null && b != null) || (a != null && b == null) )
            return false;
        return true;
    }

    public static boolean isPalindrome(SinglyLinkedList list) {
    
        SinglyLinkedList reverse = list;
        reverse.reverse();
        return isSame(list, reverse);

    }

    public static void main(String[] args) {
        
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertHead(1);
        list.insertHead(2);
        list.insertHead(1);
        System.out.println(isPalindrome(list));

    }

}
