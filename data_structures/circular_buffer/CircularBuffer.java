/*
 * CircularBuffer
 * Implementation of a circular buffer of size N for Evernote
 * by Ian Zapolsky (01/24/14)
*/

import java.util.Scanner;

public class CircularBuffer {

    int size, newest, oldest;
    String[] buf;

    // initialize a CircularBuffer to a given size
    public CircularBuffer(int init_size) {
        size = init_size;
        buf = new String[size];
        // initialize pointers to -1 to avoid edge case on first insert
        newest = -1;
        oldest = -1;
    }

    // add an element to CircularBuffer in O(1) time
    public void add(String input) {
        if (newest == -1) {
            newest = 0;
            oldest = 0;
        } else {
            newest = inc(newest);
            if (newest == oldest)
                remove();
        }
        buf[newest] = input;
    }
            
    // remove the oldest element from CircularBuffer in O(1) time
    public void remove() {
        oldest = inc(oldest);
    }

    // list CircularBuffer elements from oldest you newest in O(n) time
    public void list() {
        int cur = oldest;
        do {
            System.out.println(buf[cur]);
            cur = inc(cur);
        } while (cur != newest+1);
    }

    // utility functions to handle circular incrementation and decrementation
    private int inc(int index) {
        if (index+1 == size) index = 0;
        else index += 1;
        return index;
    }
    private int dec(int index) {
        if (index-1 < 0) index = size-1;
        else index -= 1;
        return index;
    }

    // main method
    public static void main(String[] args) {

        // initialize scanner
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());

        // create CircularBuffer with size from input
        CircularBuffer cb = new CircularBuffer(size);

        // interpret commands
        while (true) {
            String cmd = in.nextLine();
            if (cmd.equals("Q"))
                break;
            else if (cmd.equals("L"))
                cb.list();
            else if (cmd.substring(0,1).equals("R")) {
                int num = Integer.parseInt(cmd.substring(2));
                for (int i = 0; i < num; i++)
                    cb.remove();
            }
            else if (cmd.substring(0,1).equals("A")) {
                int num = Integer.parseInt(cmd.substring(2,cmd.length()));
                for (int i = 0; i < num; i++)
                    cb.add(in.nextLine());
            }
        }
    }
}
        
      
    
