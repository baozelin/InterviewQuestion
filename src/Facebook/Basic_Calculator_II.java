package Facebook;

import java.util.Stack;

//227
//Input: s = "3+2*2"
//Output: 7
public class Basic_Calculator_II {

    // stack: number
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;

        char[] list = s.toCharArray();
        for(int i = 0; i < list.length; i++){
            char tmp = list[i];
            if(Character.isDigit(tmp)){
                num = num * 10 + (list[i] - '0');
            }
            // not number or space or is last index
            if((!Character.isDigit(tmp) && tmp != ' ') || i == list.length-1){
                if(op == '+'){
                    stack.push(num);
                }
                if(op == '-'){
                    stack.push(-num);
                }
                if(op == '*'){
                    stack.push(stack.pop() * num);
                }
                if(op == '/'){
                    stack.push(stack.pop() / num);
                }
                op = tmp;
                num = 0;
            }
        }

        int ret = 0;
        while(!stack.isEmpty()){
            ret += stack.pop();
        }

        return ret;

    }
}
