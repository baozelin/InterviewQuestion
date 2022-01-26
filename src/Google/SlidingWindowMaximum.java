package Google;


import java.util.ArrayDeque;
import java.util.Deque;

//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        int[] windows = new int[len - k + 1];
        Deque<Integer> dq = new ArrayDeque();
        int windowIdx = 0;

        for(int i = 0; i < nums.length; i++){

            //full of window, poll first
            while(!dq.isEmpty() && i - dq.peekFirst()+1 > k){
                dq.pollFirst();
            }

            //element less than nums[i], pollLast
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            // full of window
            if(i+1 >= k){
                windows[windowIdx++] = nums[dq.peekFirst()];

            }
        }
        return windows;
    }


}
