package Google;

import java.util.Stack;

//946
public class ValidateStackSequences {


    //For each value, push it to the stack.
    //
    //Then, greedily pop values from the stack if they are the next values to pop.
    //
    //At the end, we check if we have popped all the values successfully.
    public boolean validateStackSequences(int[] pushed, int[] popped) {


        Stack<Integer> stack = new Stack();

        int idx = 0;
        for(int i :pushed){
            stack.push(i);

            while(!stack.isEmpty() && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }

        return idx == pushed.length;
    }

}
