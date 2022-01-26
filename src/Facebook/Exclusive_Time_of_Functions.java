package Facebook;

import java.util.List;
import java.util.Stack;


//Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
//Output: [3,4]
public class Exclusive_Time_of_Functions {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ret = new int[n];
        Stack<Integer> stack = new Stack();   // id
        int pre = 0;

        for(int i = 0; i < logs.size(); i++){

            String[] line = logs.get(i).split(":");

            int id = Integer.parseInt(line[0]);
            String p = line[1];
            int time = Integer.parseInt(line[2]);

            if(p.equals("start")){
                if(!stack.isEmpty()){
                    ret[stack.peek()] += time - pre;
                }

                stack.push(id);
                pre = time;
            }
            else{

                id = stack.pop();
                ret[id] += time - pre + 1;
                pre = time + 1;
            }

        }
        return ret;
    }
}
