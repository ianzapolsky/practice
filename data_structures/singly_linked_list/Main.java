public class Main {
   
    public static void main(String[] args) throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList blist = new SinglyLinkedList();
        list.insertHead(10);
        list.insertHead(11);
        list.insertHead(12);
        list.insertHead(13);
        blist.insertTail(4);
        blist.insertHead(5);
        blist.insertHead(10);
        blist.insertHead(4);
        blist.insertHead(20);
        System.out.println(list);
        System.out.println(blist);
        list.append(blist);
        System.out.println(list);
    
        list.reverse();
        
        System.out.println(list);


    }

}
