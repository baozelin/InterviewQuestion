package LinkedIn;


//516
//Given a string s, find the longest palindromic subsequence's length in s.
//
//A subsequence is a sequence that can be derived from another sequence by deleting some
// or no elements without changing the order of the remaining elements.
public class Longest_Palindromic_Subsequence {

    //dp
    //function:
    //若 s.charAt(i) == s.charAt(j), dp[i][j] = dp[i + 1][j - 1] + 2
    //若 s.charAt(i) != s.charAt(j)，dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
    public int longestPalindromeSubseq(String s) {

        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n][n]; //dp[i][j]表示区间[i,j]内最长回文子序列的长度
        //initiate dp
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = 0;
            }
            dp[i][i] = 1; // 单个字符为 palindromic
        }


        for (int i = n - 1; i >= 0; i--) {//遍历左边界
            for (int j = i + 1; j < n; j++) {//遍历右边界，[i,j]区间范围应从小到大，因此右边界遍历方向和左边界相反
                if (str[j] == str[i])//两端字符相同
                    dp[i][j] = dp[i + 1][j - 1] + 2;//最长回文子序列长度+2
                else//两端字符不同
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);//长度为范围-1区间对应的较大值
            }
        }
        return dp[0][n - 1];//整个字符串对应的最长回文子序列长度
    }

}
