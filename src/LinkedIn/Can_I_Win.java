package LinkedIn;

import java.util.*;

public class Can_I_Win {

    //记录 state 用 string of array[maxChoosableInteger+1]
    // recursin
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        //base case
        //两种特殊情况，一是目标比最大值小，二是把所有可能取值加起来都没有目标大
        if (desiredTotal <= maxChoosableInteger)
            return true;
        if (maxChoosableInteger * (maxChoosableInteger+1)/2 < desiredTotal)
            return false;

        //map存的是如果以当前目标为开始值，先手能不能赢，map不是存的哪些数字用过，是存的初始值状态
        Map<String, Boolean> map = new HashMap<>();

        //为了处理方便，这里下标从1开始，正好和数字对应
        int[] state = new int[maxChoosableInteger+1];
        return dp(map, state,desiredTotal, maxChoosableInteger);
    }


    boolean dp(Map<String, Boolean> map, int[] state, int total, int max){

        String str = Arrays.toString(state);

        //为了节省时间，如果前边有这种状态，那么直接从map中取出来
        if(map.containsKey(str)){
            return map.get(str);
        }

        //loop
        for(int i = 1; i <= max; i++){
            if(state[i] == 0){
                //记录这个数用过了
                state[i] = 1;

                //判断当前这个目标能不能赢，如果能，如果是最外层，说明能赢，直接返回。如果不是最外层，则判断的上一步走的对不对，赢了就是走错了
                if(total <= i || !dp(map, state, total-i,max)){

                    //记录下如果初始值是这个状态的话，先手是可以胜利的
                    map.put(str,true);

                    //返回之前一定把当前这个数重置，因为上一次的时候这个数还没用，还原上次的初始值状态，数字用的情况代表着当时的目标状态
                    state[i] = 0;
                    return true;
                }

                //能进行到这里说明如果走当前这一步，说明会输，不走这一步继续尝试，所以重置状态
                state[i] = 0;
            }
        }

        //走到这里说明遍历完了都没返回成功，说明必输，记录状态返回
        map.put(str,false);
        return false;
    }
}
