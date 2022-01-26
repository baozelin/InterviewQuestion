package Ebay;


//1060
//Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an
// integer k, return the kth missing number starting from the leftmost number of the array.
public class
Missing_Element_in_Sorted_Array {

    public int missingElement(int[] nums, int k) {

        int n=nums.length,diff=0;
        for(int i=1;i< n;i++)
        {
            diff = nums[i] - nums[i-1] - 1;
            if(diff >= k) return nums[i-1] + k;
            k -= diff;
        }
        return nums[n-1] + k;

    }



    //binary search

    //return how miss number
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }
    //binary search
    public int missingElement2(int[] nums, int k) {

        int n = nums.length;

        //if kth > the last element of array
        if(k > missing(n-1, nums)){
            return nums[n-1] + k - missing(n-1, nums);
        }

        int left = 0, right = n-1, mid;

        while(left < right){

            mid = (left + right)/2;
            if(missing(mid, nums) < k) left = mid+1;
            else right = mid;
        }

        return nums[left - 1] + k - missing(left - 1, nums);
    }
}
