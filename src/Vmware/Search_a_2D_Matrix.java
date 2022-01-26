package Vmware;



//74
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true


public class Search_a_2D_Matrix {

    // left bottom   O(log(mn)
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length ==0) return false;
        if(matrix[0] == null || matrix[0].length == 0) return false;

        int x = matrix.length -1; // bottom
        int y = 0;  // left

        while(x >= 0 && y < matrix[0].length){

            if(matrix[x][y] < target) y++;
            else if(matrix[x][y] > target) x--;
            else{
                return true;
            }
        }

        return false;
    }
}
