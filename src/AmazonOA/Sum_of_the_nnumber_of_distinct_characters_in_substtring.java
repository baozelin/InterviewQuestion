package AmazonOA;

import java.util.Arrays;




//Given a string, return the sum of count of distinct characters in all the substrings of that string.
//For example:
//Input String - "test"
//Possible substrings with distinct character count
//"t" -> 1
//"e" -> 1
//"s" -> 1
//"t" -> 1
//"te" -> 2
//"es" -> 2
//"st" -> 2
//"tes" -> 3
//"est" -> 3
//"test" -> 3

public class Sum_of_the_nnumber_of_distinct_characters_in_substtring {

    public  static int helper(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int res = 0;
        int[] lastChar = new int[26];
        int[] dp = new int[n];

        Arrays.fill(lastChar, -1);
        dp[0] = 1;
        res += dp[0];
        lastChar[str.charAt(0) - 'a'] = 0;

        for (int i = 1; i < str.length(); i++) {

            char cur = str.charAt(i);

            int idxOfLastChar = lastChar[cur - 'a'];
            dp[i] += dp[i - 1] + i + 1 - (idxOfLastChar + 1);
            res += dp[i];
            lastChar[cur - 'a'] = i;
        }


        return res;
    }


    public static void main(String[] args){

        System.out.print(helper("test"));
        System.out.print(helper("good"));
    }

}

