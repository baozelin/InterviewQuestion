package Google;


import java.util.ArrayList;
import java.util.List;

//leetcode 152
// max time of subset
public class MaxProductOf_subset {

    List<List<Integer>> res = new ArrayList();
    int max = Integer.MIN_VALUE;

    public int combine(int[] arr) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            dfs(i, 1, arr);
        }
        return max;
    }


    void dfs(int i, int sum, int[] arr){
        if(i == arr.length){
            max = Math.max(sum, max);
        }

        for(int j = i; j < arr.length; j++){
            sum *= arr[i];
            dfs(j+1, sum, arr);
            sum /= arr[i];
        }
    }



    public static void main(String[] args){
        MaxProductOf_subset m = new MaxProductOf_subset();
        int[] test = {2,-1,5,7,-3, -4};
        System.out.println(m.combine(test));
    }
}
