package Facebook;


import java.util.HashSet;
import java.util.Set;

//939
//You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
public class Minimum_Area_Rectangle {

    public int minAreaRect(int[][] points) {
        //Set to maintain easy lookup for points.
        Set<String> seen = new HashSet<>();
        for(int[] p : points) {
            seen.add(p[0] + "_" + p[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] p : points) {
            for(int[]  q : points) {
                //Check for each of the diagonal Points.
                if(q[0] > p[0] && q[1] > p[1]) {
                    //Condition to check if the opposite diagonal points are present in the input points.
                    if(seen.contains(p[0]+"_"+q[1]) && seen.contains(q[0]+"_"+p[1])) {
                        min = Math.min(min, Math.abs((q[1] - p[1]) * (q[0] - p[0])));
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
