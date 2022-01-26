package Facebook;



//31
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
//The replacement must be in place and use only constant extra memory.
//Input: nums = [1,2,3]
//Output: [1,3,2]
public class Next_Permutation {

    // from end to begin, keep decreasing, swap, reverse
    //eg, 1 5 8   <4>  7 6 <5> 2 1   ->  swap 4, 5-->  1 5 8 5 < 7 6 4 2 1> reverse ->   1 5 8 5 1 2 4 6 7

    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;

        int i = nums.length-2;
        // keep keep decreasing, find first small  nums[i-1] < nums[i]
        while(i >= 0 && nums[i] >= nums[i+1]) i--;

        //from end find first > this num
        if(i >= 0){

            int j = i+1;
            while(j < nums.length && nums[j] > nums[i])
                j++;

            swap(nums, i, j-1);    // 注意 i 和 j-1换

        }



        // increasing order
        i++;
        int k = nums.length-1;
        while(i <= k){
            swap(nums, i, k);
            i++;
            k--;
        }
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
