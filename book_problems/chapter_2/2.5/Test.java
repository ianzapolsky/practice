// quick and dirty experiment to use the actual Java implementation of
// LinkedList<E> and ListIterator<E>

import java.util.LinkedList;
import java.util.ListIterator;

public class Test {

    public static void main(String[] args) {
    
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.push(3);
        list.push(4);
        list.push(2);
        list.push(1);
        System.out.println(list);

        ListIterator<Integer> itr = list.listIterator(0);
      
        System.out.println(itr.next()); 
        System.out.println(itr.next()); 
        System.out.println(itr.next()); 

    }

}
