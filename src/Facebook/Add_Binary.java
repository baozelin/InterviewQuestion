package Facebook;

public class Add_Binary {
    public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0) return null;
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;

        String res = "";

        int i = 0;
        int carry = 0;

        while(i < a.length() && i < b.length() ){
            int tmp = (a.charAt(a.length()-1-i)-'0') + (b.charAt(b.length()-1-i)-'0' + carry);
            carry = tmp/2;
            res = tmp%2 + res;
            i++;
        }

        while(i < a.length()) {
            int tmp = (a.charAt(a.length()-1-i)-'0') + carry;
            carry = tmp/2;
            res = tmp%2 + res;
            i++;
        }

        while(i < b.length()) {
            int tmp = (b.charAt(b.length()-1-i)-'0') + carry;
            carry = tmp/2;
            res = tmp%2 + res;
            i++;
        }

        if(carry == 0){
            return res;

        }else{
            return('1'+ res);
        }

    }
}
