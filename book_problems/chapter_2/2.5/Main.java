// Main.java

// Description: Two numbers, represented by a list, where each node contains a
// single digit, are given. The digits are stored in reverse order, such that
// the 1s digit is stored in the head of the list. Write a function that adds
// and returns the answer as another list.
// Author: Ian Zapolsky (10/16/13)

public class Main {

    public static int listToInt(SinglyLinkedList list) {
       
        int number = 0;
        double power = 0;
        Node ptr = list.head;

        while (ptr != null) {
            number += ptr.data*Math.pow(10.0, power);
            power += 1.0;
            ptr = ptr.next;
        }

        return number;
    }

    public static SinglyLinkedList intToList(int number) {
        
        SinglyLinkedList result = new SinglyLinkedList();
        while (number != 0) {
            result.insertHead(number%10);
            number = number/10;
        }
        return result;
    }

    public static SinglyLinkedList addLists(SinglyLinkedList a,
                                            SinglyLinkedList b) {
        int a_int = listToInt(a);
        int b_int = listToInt(b);
        return intToList(a_int+b_int); 
    }

    public static void main(String[] args) {
        
        SinglyLinkedList a = new SinglyLinkedList();
        SinglyLinkedList b = new SinglyLinkedList();

        a.insertHead(1);
        a.insertHead(1);
       
        b.insertHead(9);
        b.insertHead(9);

        System.out.println(a);
        System.out.println(b);
        
        System.out.println(addLists(a, b));
    }
}









