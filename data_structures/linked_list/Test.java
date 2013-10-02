// Test.java for LinkedList and Node
// by Ian Zapolsky (09/27/13)

public class Test {
    
    public static void main(String args[]) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        System.out.println(ll);
        ll.insert(4);
        ll.insert(5);
        ll.insert(142);
        ll.insert(1);
        ll.insert(6);
        System.out.println(ll);
        System.out.println(ll.find(1));
        System.out.println(ll.remove(1));
        System.out.println(ll);
    }

}
