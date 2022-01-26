package Facebook;


//977
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
public class Squares_of_a_Sorted_Array {

    // two point,  O(n)
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;

        int left = 0, right = nums.length-1;
        int index = nums.length-1;
        while(left <= right){

            int square = 0;
            if(Math.abs(nums[left]) <= Math.abs(nums[right])){
                square = Math.abs(nums[right]);
                right--;
            }
            else{
                square = Math.abs(nums[left]);
                left++;
            }

            res[index--] = square*square;
        }
        return res;

    }
}
