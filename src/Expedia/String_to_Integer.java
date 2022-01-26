package Expedia;


//8. String to Integer (atoi)
public class String_to_Integer {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0 ) return 0;
        //remove space
        str = str.trim();
        //positive?
        boolean positive = true;
        int i = 0;

        if (str.charAt(0) == '+') {
            i++;
        }else if(str.charAt(0) == '-'){
            i++;
            positive = false;
        }

        //read number
        double tmp = 0;
        for( ; i < str.length(); i++){
            int num = str.charAt(i) - '0';

            if (num < 0 || num > 9) break;
            //handle max or min
            if(positive){
                tmp = tmp*10 + num;
                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            else{
                tmp = tmp*10 - num;
                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        int ret = (int)tmp;
        return ret;
    }
}
