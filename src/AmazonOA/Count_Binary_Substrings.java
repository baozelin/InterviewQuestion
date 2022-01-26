package AmazonOA;

public class
Count_Binary_Substrings {

    //Input: s = "00110011"
    //Output: 6
    //Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
    //Notice that some of these substrings repeat and are counted the number of times they occur.
    //Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.



    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }
}
