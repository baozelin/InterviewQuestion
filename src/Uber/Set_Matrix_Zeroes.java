package Uber;

import java.util.HashSet;
import java.util.Set;

//73
//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
//
//You must do it in place.
public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        //check first row and col
        for(int i = 0;i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for(int i = 0;i < matrix.length; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }


        //check 0 of matirx
        for(int i = 1;i < matrix.length; i++){
            for(int j = 1;j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //replace 0
        for( int i = 1;i < matrix.length;i++){
            if( matrix[i][0] == 0)
                for( int j = 1;j < matrix[0].length;j++)
                    matrix[i][j] = 0;
        }

        for( int i = 1;i < matrix[0].length;i++){
            if( matrix[0][i] == 0)
                for( int j = 1;j < matrix.length;j++)
                    matrix[j][i] = 0;
        }

        //
        if(firstRow){
            for(int i = 0; i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }

        if(firstCol){
            for(int i = 0; i < matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
