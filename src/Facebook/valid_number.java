package Facebook;

public class valid_number {

    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;


        for(int i = 0; i < s.length(); i++){

            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                seenDigit = true;
            }
            else if(cur == '+' || cur == '-'){

                if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }
            else if(cur == 'e' || cur == 'E'){
                if(!seenDigit || seenE){
                    return false;
                }
                seenE = true;
                seenDigit = false;
            }
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
