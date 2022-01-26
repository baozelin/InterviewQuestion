package Ebay;

import java.util.Arrays;


//628. Maximum Product of Three Numbers
public class Maximum_Product_of_Three_Numbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
