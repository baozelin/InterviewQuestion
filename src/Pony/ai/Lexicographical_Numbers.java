package Pony.ai;

import java.util.ArrayList;
import java.util.List;

//386
//Input: n = 13
//Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
public class Lexicographical_Numbers {

    //dfs
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= 9; i++){

            if(i > n) break;
            dfs(list, i, n);
        }
        return list;

    }

    public void dfs(List<Integer> list, int i, int n){
        list.add(i);

        for(int k = 0; k <= 9; k++){
            if(i*10 + k > n) break;
            dfs(list, i*10+k, n);
        }
    }

}
