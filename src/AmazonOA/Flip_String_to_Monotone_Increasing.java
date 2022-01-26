package AmazonOA;


//Input: s = "00110"
//Output: 1
//Explanation: We flip the last digit to get 00111.
public class Flip_String_to_Monotone_Increasing {


    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int flip =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                one++;
            else
                flip++;
            flip = Math.min(one,flip);
        }
        return flip;

    }


}
