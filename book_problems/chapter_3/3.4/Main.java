// Main.java

// Description: Write a program to solve the infamous towers of hanoi problem.
// This is an area where I need work: recursion. Starting with the base case
// of n = 1 and working up, we can derive the recursive function to solve this
// but it is not necessarily intuitive. The more problems like this the better.
// Author: Ian Zapolsky (10/25/13)

public class Main {

    public static void main(String[] args) {
    
        TowersOfHanoi th = new TowersOfHanoi(5);
        System.out.println(th);
        th.solve();
        System.out.println(th);
    }
}
