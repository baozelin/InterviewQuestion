package Facebook;


import java.util.HashMap;

//560. Subarray Sum Equals K
public class Subarray_Sum_Equals_K {

    // presum
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int[]  sum = new int[nums.length +1];
        sum[0] = 0;

        //fill sum
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];

        }

        //sum[j] - sum[i] == k
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= nums.length; j++){
                if(sum[j] - sum[i] == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraySum_2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
