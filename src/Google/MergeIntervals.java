package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i+1 < intervals.length && right >= intervals[i+1][0]){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left, right});
        }

        int[][] ret = new int[list.size()][2];
        for(int i = 0; i< list.size(); i++){
            ret[i][0] = list.get(i)[0];
            ret[i][1] = list.get(i)[1];
        }

        return ret;

    }
}
