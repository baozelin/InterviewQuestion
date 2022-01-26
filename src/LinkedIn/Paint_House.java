package LinkedIn;

public class Paint_House {

    /**
     *  dp:    dp[n][0] = min(dp[n+1][1], dp[n+1][2]) + cost[n][0]
     */
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;

        int[][] dp = new int[costs.length][costs[0].length];

        dp[costs.length-1][0] = costs[costs.length-1][0];
        dp[costs.length-1][1] = costs[costs.length-1][1];
        dp[costs.length-1][2] = costs[costs.length-1][2];


        for(int n = costs.length-2; n >= 0; n--){
            dp[n][0] += Math.min(dp[n+1][1], dp[n+1][2]) + costs[n][0];
            dp[n][1] += Math.min(dp[n+1][0], dp[n+1][2]) + costs[n][1];
            dp[n][2] += Math.min(dp[n+1][0], dp[n+1][1]) + costs[n][2];
        }


        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);

    }
}
