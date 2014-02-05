/*
 * CreditAnalyzer
 * Given a credit C, and a list of items L with prices P, determine the two
 * items whose prices sum to C
 * Ian Zapolsky (01/01/14)
*/

import java.util.Scanner;

public class CreditAnalyzer {

    private int n;
    private int[][] pairs;
    private Scanner in;

    public CreditAnalyzer() { }

    public void analyzeCreditCases() {
      
        init(); 
        readAndAnalyzeCases();
        output();

    }

    public void init() {
     
        in = new Scanner(System.in);
        n = Integer.parseInt(in.nextLine());
        pairs = new int[n][2];
    } 

    public void output() {
        
        for (int caseNumber = 0; caseNumber < n; caseNumber++) {
            String output = "Case #"+(caseNumber+1)+":";
            output += " "+pairs[caseNumber][0];
            output += " "+pairs[caseNumber][1];
            System.out.println(output);
        }
    }

    public void readAndAnalyzeCases() {
        for (int caseNumber = 0; caseNumber < n; caseNumber++)
            readAndAnalyzeCase(caseNumber);
    }

    public void readAndAnalyzeCase(int caseNumber) {
      
        int credit = Integer.parseInt(in.nextLine());
        int numberItems = Integer.parseInt(in.nextLine());
        int[] items = new int[numberItems];
        for (int i = 0; i < numberItems; i++) 
            items[i] = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numberItems-1; i++) {
            for (int j = i+1; j < numberItems; j++) {
                if (items[i]+items[j] == credit) {
                    pairs[caseNumber][0] = (i+1);
                    pairs[caseNumber][1] = (j+1);
                    break;
                }
            }
        }
    }
}

            
