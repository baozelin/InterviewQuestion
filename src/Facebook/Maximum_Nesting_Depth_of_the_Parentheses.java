package Facebook;



//1614

//Input: s = "(1+(2*3)+((8)/4))+1"
//Output: 3
public class Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count ++;
                max = Math.max(count, max);
            }
            else if(c == ')'){
                count --;
            }
        }
        return max;
    }
}
