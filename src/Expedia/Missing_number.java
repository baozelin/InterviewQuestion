package Expedia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//268 Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

//Input: nums = [3,0,1]
//Output: 2
public class Missing_number {



    //sort
    public int missingNumber2(int[] nums) {
        int size = nums.length+1;

        Arrays.sort(nums);

        for(int i = 0 ; i < size; i++){

            if(i >= nums.length) return i;
            if(i != nums[i]) return i;
        }
        return -1;
    }

    // hashset
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}
