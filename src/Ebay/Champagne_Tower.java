package Ebay;

public class Champagne_Tower {


    //build 2d tower
    // o
    // o o
    // o o o

    //下一层 == （当前-1）/2
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = poured;

        //loop this tower
        for(int r = 0; r <= query_row; r++){

            //col
            for(int c = 0; c <= r; c++){

                double rest = (tower[r][c] - 1.0) / 2.0;

                if(rest > 0){
                    tower[r+1][c] += rest;  //left
                    tower[r+1][c+1] += rest;  //rigth
                }
            }
        }
        return Math.min(1.0, tower[query_row][query_glass]);

    }
}

