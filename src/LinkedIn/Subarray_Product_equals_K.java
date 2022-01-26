package LinkedIn;

public class Subarray_Product_equals_K {

    // presum
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int[]  sum = new int[nums.length +1];
        sum[0] = 1;

        //fill sum
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] * nums[i-1];

        }

        //sum[j] - sum[i] == k
        for(int i = 1; i < nums.length; i++){
            for(int j = i+1; j <= nums.length; j++){
                if(sum[j] / sum[i] == k){
                    System.out.println(j +","+i);
                    count++;
                }
            }
        }
        return count;
    }
}
