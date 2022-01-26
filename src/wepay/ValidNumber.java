package wepay;


//["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
// while the
// following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
public class ValidNumber {

   // 一个edge cases，对于5.返回false
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for(int i= 0; i < s.length(); i++){
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
                if(i+1 >= s.length() || !Character.isDigit(s.charAt(i+1))) return false;
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
