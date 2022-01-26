package Amazon;

 //Leetcode 70
//     a) Followup: what if we change the requirement to you can either climb 1, 3, or 5 steps
//   b) Followup: what if we change the requirement to you can either climb 1, 3, or 7 steps (how can you further scale this method)


public class Climbing_Stairs {


    // can change steps
    public int climbStairs(int n, int[] steps) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){

            for(int step: steps){

                if(i - step >= 0){
                    dp[i] = dp[i] + dp[i-step];
                }
            }

        }
        return dp[n];

    }
}
