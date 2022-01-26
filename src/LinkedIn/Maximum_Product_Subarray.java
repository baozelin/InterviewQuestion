package LinkedIn;

// idea: two arrays store max, and min
public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int[] min_dp = new int[nums.length];
        int[] max_dp = new int[nums.length];
        int max = nums[0];

        min_dp[0] = nums[0];
        max_dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            min_dp[i] = Math.min(
                    Math.min(min_dp[i-1] * nums[i], max_dp[i-1]*nums[i]), nums[i]
            );

            max_dp[i] = Math.max(
                    Math.max(min_dp[i-1] * nums[i], max_dp[i-1]*nums[i]), nums[i]
            );

            max = Math.max(max, max_dp[i]);

        }
        return max;
    }
}
