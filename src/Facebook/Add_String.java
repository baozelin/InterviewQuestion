package Facebook;

public class Add_String {



    public static String addStrings(String[] nums) {
        StringBuilder result = new StringBuilder();
        //String res = "";
        int carry = 0;
        int length = 0;

        //get max length
        for(String num: nums) {
             length = Math.max(num.length(), length);
        }

        //loop in length
        for(int i = 0; i < length; i++){

            int a;
            int sum = carry;
            for(String num : nums) {
                if (i > num.length() - 1) a = 0;
                else a = num.charAt(num.length() - 1 - i) - '0';
                sum = a + sum;
            }
            carry = sum / 10;
            result.append(sum % 10);
        }

        if(carry != 0) result.append(carry);
        result = result.reverse();

        return result.toString();
    }

    public static void main(String[] args) {
        String test[] = new String[]{"11", "123", "11"};
        System.out.println(addStrings(test));
    }
}
