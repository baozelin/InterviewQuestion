package Facebook;


//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
public class Find_First_and_Last_Position_of_Element_in_SortedArray {


    public int[] searchRange(int[] nums, int target) {



        int left = 0, right = nums.length-1;

        while(left <= right){

            int mid = (left + right)/2;
            if(nums[mid] == target){

                int first = mid;
                int last =mid;
                while(first-1 >=0 && nums[first] == nums[first-1]){
                    first = first-1;
                }

                while(last+1 < nums.length && nums[last] == nums[last+1]){
                    last = last+1;
                }

                return new int[]{first, last};

            }
            else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return new int[]{-1,-1};
    }






    //binary
        public int[] searchRange_2(int[] nums, int target) {

            int firstOccurrence = this.findBound(nums, target, true);

            if (firstOccurrence == -1) {
                return new int[]{-1, -1};
            }

            int lastOccurrence = this.findBound(nums, target, false);

            return new int[]{firstOccurrence, lastOccurrence};
        }

        private int findBound(int[] nums, int target, boolean isFirst) {
            int N = nums.length;
            int begin = 0, end = N - 1;

            while (begin <= end) {

                int mid = (begin + end) / 2;

                if (nums[mid] == target) {

                    if (isFirst) {

                        // This means we found our lower bound.
                        if (mid == begin || nums[mid - 1] != target) {
                            return mid;
                        }

                        // Search on the left side for the bound.
                        end = mid - 1;

                    } else {

                        // This means we found our upper bound.
                        if (mid == end || nums[mid + 1] != target) {
                            return mid;
                        }

                        // Search on the right side for the bound.
                        begin = mid + 1;
                    }

                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }

            return -1;
        }

}
