package Facebook;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] windows = new int[nums.length-k+1];

        //index
        Deque<Integer> dq = new ArrayDeque();

        int index = 0;

        for(int i = 0; i < nums.length; i++){

            while(!dq.isEmpty() && i - dq.peekFirst()+1 > k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }


            dq.offerLast(i);

            if(i+1 >= k)
                windows[index++] = nums[dq.peekFirst()];
        }

        return windows;


    }
}


