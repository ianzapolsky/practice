// Main.java

// Description: Implement a queue using two stacks.
// Author: Ian Zapolsky (10/26/13)

public class Main {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        for (int i = 1; i <= 1000; i++)
            mq.push(i);
        for (int i = 1; i <= 1000; i++)
            System.out.println(mq.pop());
    }
}
