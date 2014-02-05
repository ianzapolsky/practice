// check if some index in a diverse array, containing Strings, Integers,
// Doubles, etc, contains a String.

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(5);
        list.add(2.5);
        list.add("hello");
        list.add(3.5421);
        list.add("world");
    
        System.out.println(isString(list, 0));
        System.out.println(isString(list, 2));
    }

    public static boolean isString(ArrayList<Object> list, int index) {
  
        if (list == null || index < 0 || index >= list.size()) return false;
        else if (list.get(index) instanceof String == true)
            return true;
        else return false;
    } 
}
