package DropboxOA;

import java.lang.reflect.Array;
import java.util.Arrays;

public class coinchange {


    // dp[i]  = min(dp[i-coin]+1, dp[i])
    public int chagne(int[] coins, int amount){


        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 1; i < dp.length;i++){

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

    int min = 0;
    public  int dfs(int[] coins, int amount)
    {
        if(amount == 0) return 0;
        int current = 0;
        Arrays.sort(coins);
        dfs(coins,current,amount, 0);
        return min;
    }

    void dfs(int[] coins, int current, int amount, int count){

        if(current == amount){
            min = Math.min(count, min);
            return;
        }
        if(current > amount) return;

        for(int coin:coins){
            current = current + coin;

            dfs(coins, current, amount, count++);
            current = current -coin;
        }
    }
}
