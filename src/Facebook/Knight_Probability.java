package Facebook;


import java.util.Arrays;

//688

//DP问题. 求最后在board上的概率. 反过来想，走完K步棋子在board上的哪个位置呢. 反过来走, 看board上所有位置走完K步后能到初始位置(r,c)的数目和.
//
//储存历史信息是走到当前这步时棋盘上能走到每个位置的不同走法.
//
//递推时, 向所有方向移动, 若是还在board上就把自己的走法加到新位置的走法上.
//
//初始化所有位置只有1种走法.
//
//答案K步之后到初始位置的走法除以Math.pow(8,K).
//
//Time Complexity: O(K*N^2).
//
//Space: O(N^2).
public class Knight_Probability {

    public double knightProbability(int n, int k, int row, int column) {
        int [][] directions = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
        double[][] dp = new double[n][n];

        //fill dp
        for(double[] d : dp){
            Arrays.fill(d, 1);
        }

        for(int step = 0; step < k; step++){

            double[][] dp1 = new double[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                    for(int[] move: directions){
                        int r = i + move[0];
                        int c = j + move[1];

                        if(r <0|| c <0|| r >= n || c >= n)
                            continue;
                        else{
                            dp1[r][c] += dp[i][j];
                        }
                    }
                }
            }
            dp = dp1;
        }

        return dp[row][column] / Math.pow(8, k);
    }
}
