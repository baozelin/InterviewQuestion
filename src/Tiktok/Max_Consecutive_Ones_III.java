package Tiktok;



//1004
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
public class Max_Consecutive_Ones_III {


    public int longestOnes(int[] nums, int k) {
        if(nums == null) return 0;

        int left = 0, zero = 0, max = 0;

        for(int right = 0; right < nums.length; right++){

            if(nums[right] == 0){
                zero++;
            }

            while(zero > k){
                if(nums[left] == 0){
                    left++;
                    zero--;
                }

                else{
                    left++;
                }
            }

            max = Math.max(max, right - left +1);
        }

        return max;
    }
}
