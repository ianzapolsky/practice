// Main.java -- POJ Problem #1003

// description: Determine the amount of cards needed to achieve a certain
// amount of overhang based on the (1/(n+1)) scheme.
// author: Ian Zapolsky (10/2/13)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int countCards(double input) {
        
        double current = 0.00;
        int cards = 0;
       
        while (current < input) {
            current += (1.0/((++cards)+1.0));
        }
        return cards;
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
            
        ArrayList<Double> input = new ArrayList<Double>();
        String nextLine = "";

        while ( !(nextLine = in.readLine()).equalsIgnoreCase("0.00")) {
            input.add(Double.parseDouble(nextLine));
        }

        for (double d : input) {
            System.out.println(countCards(d)+" card(s)");
        }
    }
}
