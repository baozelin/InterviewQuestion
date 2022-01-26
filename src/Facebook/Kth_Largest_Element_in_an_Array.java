package Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }});

        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        while(k-1 > 0){
            pq.poll();
            k--;
        }
        return pq.peek();
    }




    public int findKthLargest_quick(int[] nums, int k){
        if(nums.length == 0) return -1;
        return quick(nums, 0, nums.length-1, nums.length - k);
    }

    int quick(int[] nums, int start, int end, int k){

        if(start >= end) return nums[k];

        int left = start, right = end;
        int pivot = nums[(left+right)/2];

        while(left <= right){

            while(left <= right && nums[left] < pivot)
                left++;

            while(left <= right && nums[right] > pivot)
                right--;

            if(left <= right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if(k <= right){
            return quick(nums, start, right, k);
        }
        if(k >= left){
            return quick(nums, left, end, k);
        }

        // right, k, left
        return nums[k];
    }
}
