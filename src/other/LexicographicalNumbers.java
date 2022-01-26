package other;


//386

import java.util.ArrayList;
import java.util.List;

//Input: n = 13
//Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
public class LexicographicalNumbers {

    //O(n), space O(1)
    public List<Integer> solution(int n){

        List<Integer> res = new ArrayList<>();
        int cur = 1;

        //loop number
        for(int i = 0; i < n; i++){
            res.add(cur);

            //go next 1-->10
            if(cur*10 >= n){
                cur*=10;
            }else{

                //if cur > n, 14 > 13
                if(cur > n){
                    cur /= 10;
                }

                cur++;
                //do need to count 10,20 again
                while(cur % 10 == 0){
                    cur /= 10;
                }
            }
        }

        return res;

    }
    // 13
    // 1 10 11 12, 13, 2, 3,4,5,6,7,8,9

}
