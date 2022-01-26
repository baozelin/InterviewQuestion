package Facebook;


import java.util.HashMap;
import java.util.Map;

//523
//Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose
// elements sum up to a multiple of k, or false otherwise.
//
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
//Input: nums = [23,2,4,6,7], k = 6
//Output: true
//Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
public class Continuous_Subarray_Sum {


    public boolean checkSubarraySum(int[] nums, int k) {

        // 注意
        // 23, 2, 6, 4 ,7
        // 0 23, 25, 31, 35, 42
        int[] presum = new int[nums.length+1];
        presum[0] = 0;  // 刚好整除

        for(int i = 1; i < presum.length; i++){
            presum[i] = presum[i-1] + nums[i-1];
        }

        // (preSum[j + 1] - preSum[i]) % k == 0，即 preSum[j + 1] % k == preSum[i] % k，结合这一特点，可通过寻找 preSum 数组中是否存在对 k 取模后余数相同的值，判断该子区间是否存在。
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= nums.length; i++){
            int m = presum[i] % k;

            if(map.containsKey(m)){
                if(i - map.get(m) > 1)   // at least two
                    return true;
            }else{
                map.put(m, i);
            }
        }

        return false;
    }
}
