package Vmware;


import java.util.HashSet;
import java.util.Set;

//219
//Input: nums = [1,2,3,1], k = 3
//Output: true
public class Contains_Duplicate_II {


    //set to window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
