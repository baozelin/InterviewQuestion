package Facebook;

public class Trapping_raining_water {
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
