package Uber;

import java.util.Stack;

public class Basic_calculator_I_II_III {




    public int calculate_II(String s) {

        Stack<Integer> stack = new Stack();
        char op = '+';
        int num = 0;

        char[] list = s.toCharArray();

        for(int i = 0; i < list.length; i++){

            char tmp = list[i];

            if(Character.isDigit(tmp)){
                num = num * 10 + (list[i] - '0');

            }

            if((!Character.isDigit(tmp) && tmp != ' ') || i == list.length-1 ){

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
                    stack.push(stack.pop()/ num);
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


    //   s = "2*(5+5*2)/3+(6/2+8)"
    public int calculate_III(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;

        char op = '+';

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //count number
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }


            /**
             *  add part  --> to calcuate number
             */
            // op + ()
            if(!Character.isDigit(c) && c != ' ' || i == s.length() -1){

                if(c == '('){
                    int j = i;

                    int count = 0;
                    while(i < s.length()){

                        if(s.charAt(i) == '('){

                            count++;
                        }
                        else if(s.charAt(i) == ')'){
                            count--;
                        }

                        // find ( )
                        if(count == 0){
                            break;
                        }
                        i++;
                    }

                    number = calculate_III(s.substring(j+1, i));
                    // i = j+1;
                }
                if(op == '+') {
                    stack.push(number);
                } else if(op == '-') {
                    stack.push(-number);
                } else if(op == '*') {
                    stack.push(stack.pop() * number);
                } else if(op == '/') {
                    stack.push(stack.pop() / number);
                }
                op = c;
                number = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

    }


    /**  224
     *   basic calculator  only (, ) ,+ - " "
     */

    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;

        char op = '+';

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);
            //count number
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }


            /**
             *  add part  --> to calcuate number
             */
            // op + ()
            if(!Character.isDigit(c) && c != ' ' || i == s.length() -1){

                if(c == '('){
                    int j = i;

                    int count = 0;
                    while(i < s.length()){

                        if(s.charAt(i) == '('){

                            count++;
                        }
                        else if(s.charAt(i) == ')'){
                            count--;
                        }

                        // find ( )
                        if(count == 0){
                            break;
                        }
                        i++;
                    }

                    number = calculate(s.substring(j+1, i));
                    // i = j+1;
                }
                if(op == '+') {
                    stack.push(number);
                } else if(op == '-') {
                    stack.push(-number);
                }
                op = c;
                number = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
