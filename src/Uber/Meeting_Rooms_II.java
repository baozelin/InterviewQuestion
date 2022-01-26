package Uber;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){

            public int compare(int[] a, int[] b){
                if(a[0] < b[0]) return -1;
                else if(a[0] > b[0]) return 1;
                else{
                    return b[1] - a[1];
                }
            }
        });

        for(int[] interval: intervals){
            pq.add(new int[]{interval[0], 0});
            pq.add(new int[]{interval[1], 1});
        }


        int count = 0;

        while(!pq.isEmpty()){
            int[] cur  = pq.poll();

            if(cur[1] == 0){
                count++;
                max = Math.max(max, count);
            }else
                count--;
        }

        return max;
    }
}
