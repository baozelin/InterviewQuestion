package Expedia;


//724. Find Pivot Index

//Input: nums = [1,7,3,6,5,6]
//Output: 3
//Explanation:
//The pivot index is 3.
//Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//Right sum = nums[4] + nums[5] = 5 + 6 = 11

//prefix sum
public class Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for(int x: nums) sum+=x;

        for(int i = 0; i < nums.length; i++){
            if(leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
