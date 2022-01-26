package wepay.oa;


//lintcode 968
public class Currency_recognition {

    public static boolean validCurrencyAmount(String currency) {
        //initiate
        char DOLLAR = 'D';
        char EURO = 'E';
        char YEN = 'Y';
        char NEGATIVE = '-';

        //remove '-' if find '-' at the begining
        if(currency.charAt(0) == NEGATIVE){
            currency = currency.substring(1);
        }
        //remove '(' and ')" if they can be found as a pair
        if(currency.charAt(0) == '(' && currency.charAt(currency.length()-1) == ')' ){
            currency = currency.substring(1, currency.length()-1);
        }
        // money symbols
        if(currency.charAt(0) == DOLLAR || currency.charAt(0) == EURO || currency.charAt(0) == YEN){
            System.out.print(currency);
            //wrong if Yen with '.'
            if(currency.charAt(0) == YEN && currency.contains(".")) return false;

            if(currency.length() > 3){
                //check a decimal point with cents
                if(currency.charAt(currency.length()-3) == '.'){

                    //wrong if cent part is not a number
                    if(!isNumber(currency.substring(currency.length()-2))){
                        return false;
                    }

                    //remove cent part
                    currency = currency.substring(0, currency.length()-3);
                }
            }
            //remove dollar symbol
            currency = currency.substring(1);
            //case: 0
            if(currency.length() == 0) return false;
            if(currency.equals("0")) return true;
            if(currency.charAt(0) == '0' && currency.length() > 1){
                return false;
            }
            System.out.print(currency);

            //contain thousand separators ','
            if(currency.contains(",")){
                for(int i = currency.length()-4; i >= 0; i -=4){
                    if(currency.charAt(i) != ',') return false;
                    else{
                        //remove ','
                        currency = currency.substring(0,i) + currency.substring(i+1);

                    }
                }
            }
            //check if rest currency is number or not
            return isNumber(currency);
        }else{
            return false;
        }
    }

    //check if input is number or not
    private static boolean isNumber(String substring) {
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) < '0' || substring.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

}
