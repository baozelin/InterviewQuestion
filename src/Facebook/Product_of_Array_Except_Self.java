package Facebook;



//238
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
public class Product_of_Array_Except_Self {
    //  solution:   2 array L[从左开始的乘积] , R[从右开始的乘积]
    //     product[n] = L[n-1] * L[n+1];
    public int[] productExceptSelf(int[] nums) {

        int[] larr = new int[nums.length];
        int[] rarr = new int[nums.length];

        int[] products = new int[nums.length];

        //fill larr
        larr[0] = 1;
        for(int i = 1; i < nums.length; i++){
            larr[i] = larr[i-1] * nums[i-1];
        }

        rarr[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            rarr[i] = rarr[i+1] * nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){

            products[i] = larr[i] * rarr[i];

        }
        return products;
    }
}
