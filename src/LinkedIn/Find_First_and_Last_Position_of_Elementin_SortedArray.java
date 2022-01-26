package LinkedIn;


//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
public class Find_First_and_Last_Position_of_Elementin_SortedArray {


    public int[] searchRange(int[] nums, int target) {
        int f = findfirst(nums, target);
        int l = findlast(nums, target);

        return new int[]{f, l};
    }

    int findfirst(int[] nums, int target){

        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){

                while(mid-1 >= 0 && nums[mid] == nums[mid-1]){
                    mid = mid -1;
                }
                return mid;
            }

            else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

    int findlast(int[] nums, int target){

        int left = 0, right = nums.length-1;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){

                while(mid +1 < nums.length && nums[mid] == nums[mid+1]){
                    mid = mid+1;
                }
                return mid;
            }

            else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}
