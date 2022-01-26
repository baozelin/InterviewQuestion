package LinkedIn;

public class Valid_Number {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;


        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            // number
            if(Character.isDigit(cur)){
                seenDigit = true;
            }

            // no digit before + execpt e
            else if(cur == '+' || cur == '-'){

                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }

            //check digit before or E
            else if(cur == 'e' || cur == 'E'){
                if(!seenDigit || seenE){
                    return false;
                }
                seenE = true;
                seenDigit = false;
            }

            // check dot before or E
            else if(cur == '.'){
                if(seenDot || seenE) return false;
                seenDot = true;
            }
            else{
                return false;
            }
        }
        return seenDigit;

    }

}
