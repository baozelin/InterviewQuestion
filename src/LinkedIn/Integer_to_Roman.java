package LinkedIn;


//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
public class Integer_to_Roman {
    public String intToRoman(int num) {
        String res = "";
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};

        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                res += romans[i];
                num -= nums[i];
            }
        }
        return res;

    }
}
