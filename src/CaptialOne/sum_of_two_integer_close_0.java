package CaptialOne;


import java.lang.reflect.Array;
import java.util.Arrays;

//Question - Given an array, find the sum of two integer closest to 0.
public class sum_of_two_integer_close_0 {

    public int sum(int[] arr){

        Arrays.sort(arr);
        int min_l, min_r;
        int min  = Integer.MAX_VALUE;
        int l = 0, r = arr.length-1;
        if(arr.length < 2) return -1;

        while(l <= r){
            int sum  = arr[l] + arr[r];
            if(Math.abs(sum) < Math.abs(min)){
                min = sum;
                min_l = l;
                min_r = r;
            }

            if(sum < 0) l++;
            else r--;
        }

        return min;
    }

    public static void main(String[] args){
        sum_of_two_integer_close_0 s = new sum_of_two_integer_close_0();
        System.out.print(s.sum(new int[]{-2,-5,-7,8,4,3,1}));
    }
}
