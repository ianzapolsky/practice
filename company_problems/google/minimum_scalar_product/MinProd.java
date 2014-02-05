/*
 * MinProd.java
 * File reading and high-level problem solving for Minimum Scalar Product code
 * jam problem
 * Ian Zapolsky (01/03/14)
*/

import java.util.ArrayList;
import java.util.Scanner;

public class MinProd {

    private Scanner in;
    private ArrayList<VectorCase> cases;

    public MinProd() {
  
        in = new Scanner(System.in);
        cases = new ArrayList<VectorCase>();
    }

    public void read() {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[] vector1 = new int[size];
            int[] vector2 = new int[size];
            for (int j = 0; j < size; j++) 
                vector1[j] = in.nextInt();
            for (int j = 0; j < size; j++)
                vector2[j] = in.nextInt();
      
            cases.add(new VectorCase(vector1, vector2));
            // create a new VectorCase structure with the data and append it to
            // cases
        }
    }
    
    public void test() {
        int caseCounter = 1;
        for (VectorCase vc : cases)
            System.out.println("Case #"+(caseCounter++)+": "+vc.minimumScalarProduct);
    }
    
}
