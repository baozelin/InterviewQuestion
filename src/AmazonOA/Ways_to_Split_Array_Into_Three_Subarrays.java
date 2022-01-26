package AmazonOA;


//A split of an integer array is good if:
//
//The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
//The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.
//Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
public class Ways_to_Split_Array_Into_Three_Subarrays {

    //第一刀的切割位置是0到sum/3之间
//第二刀的最小值是：第一刀切出来得出的left*2
//第二刀的最大值是：第一刀且完之后，剩余部分的均分
//求出第一刀每种情况下的，第二刀的最小值和最大值。
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for(int i=1;i<n;i++){
            sums[i] = sums[i-1] + nums[i];
        }

        final int MOD = (int)(1e9+7);
        long ans = 0;

        //第一刀
        int t = sums[n-1]/3;

        //第二刀的范围
        for(int i=0;i<n && sums[i]<=t; i++){

            int left = lowerBound(i+1,n-1,sums, sums[i]*2);
            int right = upperBound(i+1, n-1, sums, sums[i] + (sums[n-1]-sums[i])/2);
            if(right >= left){
                ans += right-left+1;
            }
        }
        return (int)(ans%MOD);
    }

    public int lowerBound(int left,int right,int[] nums,int target){

        while(left < right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public int upperBound(int left,int right,int[] nums,int target){
        while(left < right){
            int mid = left + ((right-left)>>1);
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left-1;
    }
}
