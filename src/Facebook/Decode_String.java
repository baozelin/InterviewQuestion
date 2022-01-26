package Facebook;


//394
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"

import java.util.Stack;

//two stack
public class Decode_String {
    public String decodeString(String s) {

        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + (c - '0');
            }

            else if(c == '['){
                count.push(k);
                string.push(sb);

                sb = new StringBuilder();
                k = 0;
            }

            else if(c == ']'){

                StringBuilder cur = string.pop();
                for (int currentK = count.pop(); currentK > 0; currentK--) {
                    cur.append(sb);
                }

                sb = cur;
            }

            else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
