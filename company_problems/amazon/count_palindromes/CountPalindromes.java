// CountPalindromes.java

// Description: Return the number of palindromes in a given String, excluding
// 1-character palindromes.
// Author: Ian Zapolsky (11/14/13)

public class CountPalindromes {

    public static void main(String[] args) {
    
        String test = "abbaba";
        System.out.println(countPalindromes(test));
    }


    public static int countPalindromes(String str) {

        int palindromes = 0;
        for (int i = 1; i < str.length(); i++) {
            for (int j = i+1, k = i; k > 0 && j < str.length(); j++) {
                // even check
                if (str.charAt(k) == str.charAt(j))
                    palindromes += 1;
                // odd check
                k -= 1;
                if (str.charAt(k) == str.charAt(j))
                    palindromes += 1;
            }
        }
        return palindromes;
    }
}
                    
