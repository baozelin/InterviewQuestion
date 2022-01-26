package Facebook;


import java.util.*;

//480
//Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
public class Sliding_Window_Median {


    //O(2⋅nlogk)+O(n−k)≈O(nlogk)
    ////minHeap存大于median的数
    //maxHeap存小于median的数

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->(b.compareTo(a)));


    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length -k +1;
        if(n <= 0) return new double[0];

        double[] res = new double[n];

        for(int i = 0; i <= nums.length; i++){

            if(i >= k){
                res[i-k] = getMedian();
                remove(nums[i-k]);
            }

            if(i < nums.length){
                add(nums[i]);
            }
        }

        return res;
    }


    void add(int num){

        if(num < getMedian()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        //保证minHeap总比maxHeap的size相等或多一个元素
        if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()-1) maxHeap.offer(minHeap.poll());
    }

    void remove(int num){

        if(num < getMedian()) {
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }

        //保证minHeap总比maxHeap的size相等或多一个元素
        if (maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()-1) maxHeap.offer(minHeap.poll());
    }

    double getMedian(){

        if(maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
        if(maxHeap.size() == minHeap.size()){
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;

        }else{
            return (double) minHeap.peek();
        }
    }


}
