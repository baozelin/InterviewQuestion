package LinkedIn;

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;

            if(nums[mid] <= nums[right]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid -1;
                }
            }


            if(nums[left] <= nums[mid]){
                if(nums[mid] >= target && nums[left] <= target){
                    right = mid -1;

                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
