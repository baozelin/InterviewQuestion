package Ebay;


//80. Remove Duplicates from Sorted Array II

public class Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int length = 0;
        int i = 0;

        while(i < nums.length){

            int count = 1;

            if(i+1 < nums.length && nums[i] == nums[i+1]){
                while(i+1 < nums.length && nums[i] == nums[i+1]){
                    if(count < 2){
                        count++;
                        nums[length] = nums[i];
                        length++;
                    }
                    i++;
                }
            }else{
                nums[length] = nums[i];
                length++;
                i++;
            }
        }
        return length;
    }



    //way2:

    public int removeDuplicates2(int[] nums) {
        int j = 1, count =1;

        //loop
        for(int i = 1; i < nums.length; i++){

            if(nums[i] == nums[i-1]){
                count++;
            }else{
                count = 1;
            }

            if(count <= 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
