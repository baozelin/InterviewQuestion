package LinkedIn;


import java.util.Arrays;

//698. Partition to K Equal Sum Subsets
//Input: nums = [4,3,2,3,5,2,1], k = 4
//Output: true
//Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
public class Partition_to_K_Equal_Sum_Subsets {


    //backtrack
    //O(N * N!)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        //can not be divided
        if(sum % k != 0) return false;
        int target = sum/k;
        Arrays.sort(nums);

        //if a number > target
        if(nums[nums.length-1] > target) return false;

        int[] groups = new int[k];
        return dfs(groups, 0, target, nums);
    }

    boolean dfs(int[] groups, int index, int target, int[] nums){
        if(index >= nums.length) return true;

        int v = nums[index];
        for(int i = 0; i < groups.length; i++){
            if(groups[i] + v <= target){
                groups[i] += v;
                if(dfs(groups, index+1, target, nums)) return true;
                groups[i] -= v;
            }

            if(groups[i] == 0) break;
        }
        return false;
    }
}
