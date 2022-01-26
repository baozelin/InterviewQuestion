package other;

import java.util.*;

public class Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> ret  = new ArrayList();

        int rowB = 0, rowE = matrix.length-1, colB = 0, colE = matrix[0].length-1;


        while(rowB <= rowE && colB <= colE){

            //travel right
            for(int i = colB; i <= colE; i++){
                ret.add(matrix[rowB][i]);
            }

            rowB++;

            //travel down

            for(int i = rowB; i <= rowE; i++){
                ret.add(matrix[i][colE]);
            }

            colE--;

            //travel left

            if(rowB <= rowE){
                for(int i = colE; i >=colB; i--){
                    ret.add(matrix[rowE][i]);
                }

                rowE--;

            }


            //travel up
            if(colB <= colE){

                for(int i = rowE; i >= rowB; i--){
                    ret.add(matrix[i][colB]);
                }

                colB++;
            }






        }
        return ret;
    }
}
