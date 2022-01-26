package LinkedIn;

//hard
public class Count_Different_Palindromic_Subsequences {

    //base case: count"" = 0. count"a" = 1
    //1.  first == last:count"bccb" = 2* count"cc" + 2
    //1.2  count"bcbcb" = 2 * count"cbc" + 1
    //1.3  count"bbcabb" = 2* count("bcab") - count"ca"
    //2.  first != last: count"abccd" = count"abcc" + count"bccb" - count"bcc"

    long[][] m;
    int k = 1000000007;
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        m = new long[n][n];

        return (int)count(s.toCharArray(), 0, n -1);


    }

    long count(char[] s, int i, int j){
        if(i > j) return 0;  // ""
        if(i == j) return 1;  //"a"
        if(m[i][j] > 0) return m[i][j]; // visited before
        long ret = 0;


        if(s[i] == s[j]){
            ret += count(s, i+1, j-1) * 2;
            int l = i+1;
            int r = j-1;

            while(l <= r && s[l] != s[i]) l++;
            while(l <= r && s[r] != s[j]) r--;

            if(l > r) ret +=2; //1.
            else if(l == r) ret += 1; //1.2
            else{ //1.3
                ret -= count(s, l+1, r-1);

            }
        }else{
            ret = count(s, i, j-1) + count(s, i+1,j) - count(s, i+1, j-1);
        }

        m[i][j] = ((ret+k) % k );    //need to add k, otherwise its negative
        return m[i][j];

    }
}
