package LinkedIn;


//678. Valid Parenthesis String
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
public class Valid_Parenthesis_String {

    // range of ( ,  问题在 * 能为 （ or )
    public boolean checkValidString(String s) {
        char[] str = s.toCharArray();
        int minleft = 0, maxleft = 0;

        for(int i = 0; i < str.length; i++){
            char cur = str[i];

            if(cur == '('){   //all min, max ++1
                minleft++;
                maxleft++;
            }
            else if(cur == ')'){ // all -1
                minleft = Math.max(minleft-1, 0);
                maxleft--;

                if(maxleft < 0){ // ) more than (
                    return false;
                }
            }

            // * can be ( or )
            else{
                maxleft++;
                minleft = Math.max(minleft-1, 0);
            }
        }
        return minleft == 0;
    }
}
