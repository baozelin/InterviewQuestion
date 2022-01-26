package Facebook;

import java.util.*;
import java.util.Random;


//398
//["Solution", "pick", "pick", "pick"]
//[[[1, 2, 3, 3, 3]], [3], [1], [3]]
//Output
//[null, 4, 0, 2]
public class Random_Pick_Index {

    private int[] nums;

    private Random rand;

    public Random_Pick_Index(int[] nums) {
        // Do not allocate extra space for the nums array
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (this.nums[i] == target) {
                indices.add(i);
            }
        }
        int l = indices.size();
        // pick an index at random
        int randomIndex = indices.get(rand.nextInt(l));
        return randomIndex;
    }
}
