public class Main {
    
    public static void main(String[] args) throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.sortedInsert(4);
        list.sortedInsert(5);
        list.sortedInsert(1);
        list.sortedInsert(2);
        list.sortedInsert(9);
        System.out.println(list);
    }
}
