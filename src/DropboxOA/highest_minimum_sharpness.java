package DropboxOA;


// Given a 2-d array of "sharpness" values. Find a path from the leftmost column to the rightmost column which has the
// highest minimum sharpness.

// Output the highest minimum sharpness. Each move can only move to the top right, right or bottom right grid.

// Example: 3*3 matrix

// 5 7 2

// 7 5 8

// 9 1 5

// The path with highest minimum sharpness is 7-->7-->8, because 7 is the highest minimum value in all the paths.. check 1point3acres for more.
// dp[r][c] = min(max(dp[r-1][c-1], dp[r][c-1], dp[r+1][c-1]), grid[r][c])
public class highest_minimum_sharpness {

    int walk(int[][] arr){

        int[][] dp = new int[arr.length][arr[0].length];

        //fill leftmost layer
        for(int r = 0; r < arr.length; r++){
            dp[r][0] = arr[r][0];
        }

        //do dp
        //dp[r][c] = min(max(dp[r-1][c-1], dp[r][c-1], dp[r+1][c-1]), arr[r][c])


            for(int c = 1; c < arr[0].length;c++){
                for(int r = 0; r < arr.length; r++){
                    if(r == 0){
                        dp[r][c] = Math.min(Math.max(dp[r][c-1], dp[r+1][c-1]), arr[r][c]);

                }
               else if(r == arr.length-1){
                    dp[r][c] = Math.min(Math.max(dp[r-1][c-1], dp[r][c-1]), arr[r][c]);
                }
                else
                dp[r][c] = Math.min(Math.max(Math.max(dp[r-1][c-1], dp[r][c-1]), dp[r+1][c-1]), arr[r][c]);
            }
        }

        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[0].length;c++) {
                System.out.print(dp[r][c]);
            }
            System.out.println();

        }
        int max = 0;
        for(int r = 0; r < arr.length; r++){
            max = Math.max(max,dp[r][arr[0].length-1]);
        }

        return max;
    }

    public static void main(String[] args){

        highest_minimum_sharpness h = new highest_minimum_sharpness();
        int[][] arr = {{5,7,2},
                        {7,5,7},
                        {9,1,5}};

        int[][] arr2 = {{5,4,6},{1,2,10},{9,4,11}};
        System.out.println(arr[0][1]);

        System.out.println(h.walk(arr));
        System.out.println(h.walk(arr2));
    }



}

/**
 *
 * follow up 100million * 100 million
 *
 */
