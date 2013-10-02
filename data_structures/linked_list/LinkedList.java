// LinkedList.java
// by Ian Zapolsky (09/27/13)

public class LinkedList<T> {
    public Node head;
    public Node tail;
    
    public LinkedList() {
        head = null;
        tail = null;
    }
    
    public void insert(T value) {
    // inserts a new node at the head of the LinkedList

        if (head == null) {
            Node newNode = new Node(value, null, null);
            head = newNode;
            tail = newNode;
        }
        else {
            Node newNode = new Node(value, null, head);
            head.prev = newNode;
            head = newNode;
        }
    }

    public boolean find(T value) {
    // returns true if found, false if not found

        if (head == null)
            return false;
        Node cur = head;
        while (cur != null) {
            if (cur.value.equals(value)) 
                return true;
            cur = cur.next;
        }   
        return false;
    }
    
    public boolean remove(T value) {
    // deletes the first occurrence of value in the LinkedList
    // returns true if any nodes were deleted, false if value not found

        if (head == null)
            return false;
        Node cur = head;
        while (cur != null) {
            if (cur.value.equals(value)) {
                if (cur.next != null) 
                    cur.next.prev = cur.prev;
                if (cur.prev != null) 
                    cur.prev.next = cur.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void reverse() {
    // reverses the LinkedList
        
       i

    public String toString() {
    // prints the LinkedList, assuming that type T implements toString()

        String result = "";
        if (head == null)
            result += "empty";
        else {
            Node cur = head;
            while (cur != null) {
                result += cur.value+" | "; 
                cur = cur.next;
            }
        }
        return result;
    }

}
