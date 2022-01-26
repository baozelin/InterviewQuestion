package Facebook;


//41
//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//You must implement an algorithm that runs in O(n) time and uses constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [1,2,0]
//Output: 3

//
public class First_Missing_Positive {


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < len; i++) {
            while (nums[i] != i+1) {
                if (nums[i] > nums.length || nums[i] <= 0 || nums[i] == nums[nums[i]-1])
                    break;

                //swap
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

}
