package Uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){

            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });


        int index = 0;
        List<int[]> list = new ArrayList<>();

        while(index < intervals.length){

            int left = intervals[index][0];
            int right = intervals[index][1];
            while(index+1 < intervals.length && right >= intervals[index+1][0]){
                right = Math.max(right, intervals[index+1][1] );
                index++;
            }

            list.add(new int[]{left, right});
            index++;

        }



        int[][] ret = new int[list.size()][2];
        for(int i=0; i < list.size(); i++){
            ret[i][0] = list.get(i)[0];
            ret[i][1] = list.get(i)[1];
        }

        return ret;
    }
}
