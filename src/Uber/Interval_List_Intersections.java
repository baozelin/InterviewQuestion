package Uber;




//986. Interval List Intersections

import java.util.*;

//Input: firstList = [], secondList = [[4,8],[10,12]]
//Output: []
//交集
public class Interval_List_Intersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> list = new ArrayList();

        int i = 0, j = 0;

        while(i < firstList.length && j < secondList.length){

            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if(low <= high){
                list.add(new int[]{low, high});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else
                j++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
