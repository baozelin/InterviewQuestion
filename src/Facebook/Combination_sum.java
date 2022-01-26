package Facebook;

import java.util.*;

public class Combination_sum {

    // O(n^(t/m+1)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if(candidates.length <= 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target, 0, res);
        return res;
    }


    void dfs(int[] arr, int start, List<Integer> list, int target, int sum, List<List<Integer>> res ){

        if(sum == target){
            res.add(new ArrayList<>(list));
        }

        for(int i = start; i < arr.length; i++){

            int cur = arr[i];
            if(cur + sum > target) break;

            list.add(cur);
            dfs(arr, i, list, target, sum+cur, res);
            list.remove(list.size()-1);
        }
    }
}
