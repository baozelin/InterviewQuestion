package Uber;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median_of_Stream_of_Integers {
    private Queue<Integer> minHeap, maxHeap;


    //A min-heap that contains the larger half of the elements, with the minimum element at the root
    //A max-heap that contains the smaller half of the elements, with the maximum element at the root
    Median_of_Stream_of_Integers(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    }

    void add(int num){
        if(!minHeap.isEmpty() && num < minHeap.peek()){
            maxHeap.offer(num);

            if(maxHeap.size() > minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }
        }
        else{
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size()+1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    double getMedian() {
        int median;
        if (minHeap.size() < maxHeap.size()) {
            median = maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }

}
