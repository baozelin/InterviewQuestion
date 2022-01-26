package Tinder;


//42
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
public class Trapping_Rain_Water {

    public int trap(int[] height) {

        int left = 0, right = height.length-1, level = 1;

        int sum = 0;
        while(left <= right){

            while(left <= right && height[left] < level) left++;
            while(left <= right && height[right] < level) right--;


            sum += right - left +1;
            level++;
        }

        int x = 0;
        for(int c : height){
            x += c;
        }

        return sum - x;
    }
}
