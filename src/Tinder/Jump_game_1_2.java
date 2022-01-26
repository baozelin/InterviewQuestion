package Tinder;

import java.util.Arrays;

public class Jump_game_1_2 {

    //1
    //true or false
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){

            if(!dp[i]) return false;
            int cur = nums[i];
            if(cur + i >= nums.length-1) return true;

            for(int j = 0; j <= cur; j++){
                dp[i+j] = true;
            }
        }

        return false;
    }

    //2 return min step

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){

            int step = nums[i];

            for(int j = 0; j <= step; j++){
                if(j+i >= nums.length) break;
                dp[j+i] = Math.min(dp[i] + 1, dp[j+i]);

            }
        }
        return dp[nums.length-1];
    }
}
