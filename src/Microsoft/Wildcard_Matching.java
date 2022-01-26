package Microsoft;



//44
//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//The matching should cover the entire input string (not partial).

//dp
public class Wildcard_Matching {

    //dp[s.length+1][p.length+1]
    public boolean isMatch(String s, String p) {

        if(s != null && p == null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;


        //initiate
        for(int j = 1; j <= p.length(); j++){
            if(dp[0][j-1] && p.charAt(j-1) == '*')
                dp[0][j] = true;
        }

        // loop
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){

                // ? or correct char
                // dp[i][j] = dp[i-1][j-1]
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }

                // * : dp[i][j] = dp[i-1][j] || dp[i][j-1]
                else if(p.charAt(j-1) == '*'){
                    for(int k = 0; k <= j; k++){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
