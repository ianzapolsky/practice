// Main.java -- POJ Problem #1004

// description: Average 12 numbers.
// author: Ian Zapolsky (10/2/13)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    public static double average(double[] input) {
        
        double sum = 0.00;
        for (double d : input)
            sum += d;
        return sum/12.00;
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
        double[] input = new double[12];
        int lines = 0;
        while (lines < 12)
            input[lines++] = Double.parseDouble(in.readLine());
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("$"+df.format(average(input)));
    }

}
