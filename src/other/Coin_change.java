package other;

import java.util.Arrays;

public class Coin_change {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            for(int coin:coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }

        if(dp[amount] == amount+1){
            return -1;
        }else{
            return dp[amount];
        }
    }
}
