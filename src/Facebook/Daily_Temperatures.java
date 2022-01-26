package Facebook;


import java.util.*;

//739
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
public class Daily_Temperatures {
    //stack
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int cur = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < cur){
                int pre = stack.pop();
                res[pre] = i - pre;
            }

            stack.push(i);
        }
        return res;
    }
}
