package CaptialOne;

import java.util.Arrays;

public class coinchange {

    //greedy
    public int change_greedy(double[] coins, double amount){

        int count = 0;
        Arrays.sort(coins);
        for(int i = coins.length-1; i >= 0; i--){
            double value = coins[i];

            while(amount >= value){
                count++;
                amount -= value;
            }
        }
        //System.out.println(amount);
        return count;
    }

    public int change_greedy_int(int[] coins, int amount){

        int count = 0;
        Arrays.sort(coins);
        for(int i = coins.length-1; i >= 0; i--){
            int value = coins[i];

            while(amount >= value){
                count++;
                amount -= value;
            }
        }
        //System.out.println(amount);
        return count;
    }

    //Exact 题就是Convert usd to euro (assume conversion rate is 1:1.25), Then find how many bills and coins you need to
    // make up that amount,
    //Ex. 500.15
    //Ans: 1 500 euro bill 1 0.10 euro coin and 1   0.05  euro coin


    public static void main(String[] args){
        coinchange c = new coinchange();
        System.out.println(c.change_greedy(new double[]{500.00, 0.10, 0.05}, 500.15));
        System.out.println(c.change_greedy_int(new int[]{50000, 10, 5}, 50015));
    }




    // dp[i]  = min(dp[i-coin]+1, dp[i])
    public int change(int[] coins, int amount){


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
