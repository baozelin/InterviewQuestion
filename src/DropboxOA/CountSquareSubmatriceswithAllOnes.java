package DropboxOA;

public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {


        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 1)
                dp[i][0] = 1;
        }


        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 1)
                dp[0][i] = 1;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){

                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }


        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
