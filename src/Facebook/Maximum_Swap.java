package Facebook;


//670. Maximum Swap
//You are given an integer num. You can swap two digits at most once to get the maximum valued number.

//Input: num = 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
public class Maximum_Swap {

    public int maximumSwap(int num) {

        char[] digits = (""+num).toCharArray();
        int[] bucket = new int[10];

        //fill bucket
        for(int i = 0; i < digits.length; i++){
            bucket[digits[i] - '0'] = i;
        }

        for(int i = 0; i < digits.length; i++){
            for(int k = 9; k > digits[i]-'0'; k--){
                //exist behind i
                if(bucket[k] > i){
                    char tmp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }

}
