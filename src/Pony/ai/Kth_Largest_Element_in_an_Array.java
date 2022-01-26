package Pony.ai;

public class Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;

        return quick(nums, 0, nums.length-1, nums.length - k);
    }

    int quick(int[] nums, int start, int end, int k){

        if(start >= end)
            return nums[k];

        int left = start, right = end;
        int pivot = nums[(left + right)/2];

        while(left <= right){

            while(left <= right && nums[left] < pivot)
                left++;

            while(left <= right && nums[right] > pivot)
                right--;

            if(left <= right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;

            }


        }

        if(k <= right){
            return quick(nums, start, right, k);
        }

        if(k >= left){
            return quick(nums, left, end, k);
        }

        return nums[k];
    }
}
