package AmazonOA;


import java.util.PriorityQueue;

//1167
//Input: sticks = [2,4,3]
//Output: 14
//Explanation: You start with sticks = [2,4,3].
//1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
//2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
//There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
public class Minimum_Cost_to_Connect_Sticks {


    public int connectSticks(int[] sticks) {

        int totalCost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all sticks to the min heap.
        for (int stick : sticks) {
            pq.add(stick);
        }

        // combine two of the smallest sticks until we are left with just one.
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();

            int cost = stick1 + stick2;
            totalCost += cost;

            pq.add(stick1 + stick2);
        }

        return totalCost;
    }
}
