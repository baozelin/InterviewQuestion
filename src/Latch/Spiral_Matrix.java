package Latch;
import java.io.*;
import java.util.*;

//54
public class Spiral_Matrix {
/*
Spiral copy the below array:

Input:
{
 {1,  2, 3, 4, 5},     0
 {6,  7, 8, 9,10},
 {11,12,13,14,15},
 {16,17,18,19,20}
                  }

 Output:
 {1,2,3,4,5,10,15,20,19,18,17,16,11,6,7,8,9,14,13,12}
*/

// right, down, left, up

//. upside, downside, leftside, rightside
    /**
     // loop upside < downside && leftside < rightside:
     right -- > 1. add item to res, 2. update upside +1,
     down, --->        2 update rightside -1
     left  --->    2. update downside-1;
     up,------>.    update leftsid+1;


     //ending case upside >= downside && leftside >= rightside



     **/


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


