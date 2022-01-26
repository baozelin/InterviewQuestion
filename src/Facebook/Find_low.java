package Facebook;

public class Find_low {

    //O(n)
    public int find(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }

    //logn
    public int find_binary(int[] nums) {
        int left = 0, right = nums.length -1;
        while(left < right){
            int mid = (left+right)/2;
            if(nums[mid] < nums[mid+1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }



    public static void main(String[] args){
        Find_low f = new Find_low();
        System.out.println(f.find(new int[]{4,3,1,3}));
        System.out.println(f.find_binary(new int[]{3,1}));
    }
}
