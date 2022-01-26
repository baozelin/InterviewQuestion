package Uber;

import java.util.List;

public class Leftmost_Column_with_at_Least_a_One {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        int r = 0, c = cols-1;

        while(r < rows && c >= 0){
            if(binaryMatrix.get(r, c) == 0){
                r++;
            }else{
                c--;
            }
        }

        if(c == cols-1) return -1;
        else return c+1;

    }

    class BinaryMatrix {
     public int get(int row, int col) {return 0;}
     public List<Integer> dimensions() {return null;}
 }
}
