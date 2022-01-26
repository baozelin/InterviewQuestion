package Flexport;

import java.util.HashMap;
import java.util.Map;

//91
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
public class Decode_Ways {

    //dp[i] = dp[i-1] + dp[i-2]
    public int numDecodings(String s) {

        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0'? 0:1;

        if(s.length() == 1) return dp[0];

        dp[1] = s.charAt(0) > '0' && s.charAt(1) > '0'? 1:0;   // 0, 和 1 各自
        dp[1] +=  (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) < '7')? 1:0);

        for(int i = 2; i < dp.length; i++){

            //1 i*10 + i-1
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2'&& s.charAt(i) < '7')){
                dp[i] += dp[i-2];
            }

            //2. i, i-1
            if(s.charAt(i) != '0'){
                dp[i] += dp[i-1];
            }
        }
        return dp[s.length()-1];
    }


    Map<Integer, Integer> memo = new HashMap<>();
    public int numDecodings_meme(String s) {
        return recursive(0, s);

    }

    private int recursive(int index, String str) {

        if(memo.containsKey(index)){
            return memo.get(index);
        }

        //reach the end
        if(index == str.length()) return 1;

        //0 can not dechode
        if(str.charAt(index) == '0') return 0;


        if(index == str.length()-1) return 1;
        int ans = recursive(index+1, str);

        if(Integer.parseInt(str.substring(index, index + 2)) <= 26){
            ans += recursive(index+2, str);
        }

        memo.put(index, ans);
        return ans;
    }
}
