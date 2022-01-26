package LinkedIn;

import java.util.ArrayList;
import java.util.List;

//Numbers can be regarded as the product of their factors.
//
//For example, 8 = 2 x 2 x 2 = 2 x 4.
//Given an integer n, return all possible combinations of its factors. You may return the answer in any order.
//Time Complexity: Exponential.
//
//Space: log(target).
public class Factor_Combinations {
    List<List<Integer>> ret = new ArrayList();

    public List<List<Integer>> getFactors(int n) {
        if(n <= 1) return ret;
        List<Integer> list = new ArrayList();
        dfs(n, 2, list);
        return ret;

    }


    void dfs(int n, int k, List<Integer> list){
        if(n == 1 && list.size() > 1 ){
            ret.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = k; i <= n; i++){
            if(n % i == 0){
                list.add(i);
                dfs(n/i, i, list);
                list.remove(list.size()-1);
            }
        }
    }




}
