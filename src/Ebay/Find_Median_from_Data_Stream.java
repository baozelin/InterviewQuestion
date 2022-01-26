package Ebay;

import java.util.ArrayList;
import java.util.List;

public class Find_Median_from_Data_Stream {
    // O(n) + O(log n)
    //重点在于如何高效插入数据。这里采用的是二分法，相当于插入排序
    List<Integer> numlist  = new ArrayList<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        int left = 0;
        int right = numlist.size()-1;

        while(left<=right){
            int mid = (left+right)/2;
            int val = numlist.get(mid);

            if(val == num){
                numlist.add(mid,num);
                return;
            }else if(val < num){
                if(mid+1 < numlist.size() &&  numlist.get(mid+1)> num){
                    numlist.add(mid+1,num);
                    return;
                }
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        numlist.add(left,num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = numlist.size();
        if(size%2 == 1){//odd
            return numlist.get((size-1)/2);
        }
        return (numlist.get(size/2-1)+numlist.get(size/2))/2.0;
    }


    /**
     * O(logn)
     //
     A max-heap to store the smaller half of the input numbers
     A min-heap to store the larger half of the input numbers

     PriorityQueue<Integer> max_pq;
     PriorityQueue<Integer> min_pq;


     public MedianFinder_2() {
     this.min_pq = new PriorityQueue();
     this.max_pq = new PriorityQueue(10, new Comparator<Integer>(){
     public int compare(Integer a, Integer b){
     return b - a;
     }
     });

     }

     public void addNum(int num) {
     max_pq.offer(num);  // main pq
     min_pq.offer(max_pq.poll());

     if(max_pq.size() < min_pq.size()){
     max_pq.offer(min_pq.poll());
     }
     }

     public double findMedian() {
     if(max_pq.size() > min_pq.size()){
     return max_pq.peek();
     }
     else
     return (max_pq.peek() + min_pq.peek()) / 2.0;

     }

     **/
}