package Expedia;


import java.util.Arrays;

//1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
public class Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts {

    // sort cuts
    // max(horicut) * max(verticut)
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;


        //important, edges
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);

        for (int i = 1; i < n; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        //important, edges
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++){
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int) ((maxWidth * maxHeight) % (1000000007));
    }
}
