package Google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Input: target = 1, startFuel = 1, stations = []
//Output: 0
//Explanation: We can reach the target without refueling.
public class MinimumNumberofRefuelingStops {

    //ideal  maxheap + gready
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        int currentGas = startFuel, currentPosition = 0, count =0;
        while(currentGas < target){
            while(currentPosition < stations.length && currentGas >= stations[currentPosition][0]){
                pq.add(stations[currentPosition++][1]);
            }
            if(pq.isEmpty()) return -1;
            currentGas += pq.poll();
            count++;
        }
        return count;

    }
}
