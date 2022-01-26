package LinkedIn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Find_K_Pairs_with_Smallest_Sums {

    // min heap
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, new Comparator<List<Integer>>(){

            public int compare(List<Integer> l1, List<Integer> l2){
                int tmp1 = l1.get(0)+l1.get(1);
                int tmp2 = l2.get(0)+l2.get(1);

                return tmp1 - tmp2;
            }

        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                queue.offer(temp);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        while (count < k && !queue.isEmpty()) {
            list.add(queue.poll());
            count++;
        }
        return list;
    }


    // max heap improve
    public List<List<Integer>> kSmallestPairs_maxheap(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (l1, l2) -> (l2.get(0) + l2.get(1) - l1.get(0) - l1.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (queue.size() < k) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]);
                    temp.add(nums2[j]);
                    queue.offer(temp);
                    continue;
                }
                List<Integer> last = queue.peek();
                if (last.get(0) + last.get(1) <= nums1[i] + nums2[j]) {
                    break;
                } else {
                    queue.poll();
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]);
                    temp.add(nums2[j]);
                    queue.offer(temp);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while (queue.size() > 0) {
            list.add(0, queue.poll());
        }
        return list;
    }


}
