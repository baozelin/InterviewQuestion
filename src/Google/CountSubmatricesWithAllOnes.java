package Google;


//Input: mat = [[1,0,1],
//              [1,1,0],
//              [1,1,0]]
//Output: 13
//Explanation:
//There are 6 rectangles of side 1x1.
//There are 2 rectangles of side 1x2.
//There are 3 rectangles of side 2x1.
//There is 1 rectangle of side 2x2.
//There is 1 rectangle of side 3x1.
//Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
public class CountSubmatricesWithAllOnes {


    //基础题：
    //485. Max Consecutive Ones
    //1D
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxcount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            }else{
                maxcount = Math.max(maxcount,count);
                count = 0;
            }
        }
        return Math.max(maxcount, count);
    }


    //2D
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];

        for(int i = 0; i < n;i++){
            int c = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1) c++;
                else c = 0;
                dp[i][j] = c;
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k < n; k++){

                    min = Math.min(min, dp[k][j]);
                    res += min;
                }
            }
        }
        return res;

    }
}
