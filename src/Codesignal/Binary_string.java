package Codesignal;



//二进制数string，两种query,  '+'是把那个二进制数加一，'?'是在返回list中加入二进制字符串中'‍‌‍‌‌‌‍‍‍‍‍‍‍‍‌‌‌‌‍1'的个数


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给一个二进制数不过是string形式，和一串query，如果query“？”就输出当前二进制数里几个1，如果是“-‍‌‍‌‌‌‍‍‍‍‍‍‍‍‌‌‌‌‍”就给这个二进制数减一。
//样例数据："1100", ["?", "-", "?", "-", "?"]
//样例输出：[2,3,2]
public class Binary_string {


    public List<Integer> solve(String num, char[] ans){

        //int ones = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            stack.add(c - '0');
        }

        List<Integer> res = new ArrayList<>();
        for(char c : ans){
            if(c == '?'){
                int count = 0;
                Stack<Integer> tmp = new Stack<>();
                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    if(cur == 1){
                        count++;

                    }
                    tmp.add(cur);
                }

                while(!tmp.isEmpty()){
                    stack.add(tmp.pop());
                }

                res.add(count);
            }

            else{
                Stack<Integer> tmp = new Stack<>();
                while(!stack.isEmpty() && stack.peek() == 0){
                    stack.pop();
                    tmp.add(1);
                }

                if(!stack.isEmpty() && stack.peek() == 1){
                    stack.pop();
                    tmp.add(0);
                }

                while(!tmp.isEmpty()){
                    stack.add(tmp.pop());
                }
                /**
                while(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }
                 **/
            }
        }
        return res;
    }

    public static void main(String[] args){
        Binary_string b = new Binary_string();
        List<Integer> list = b.solve("1100",new char[]{'?', '-', '?', '-', '?'});
        //List<Integer> list = b.solve("1100",new char[]{'?','-','?'});
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
