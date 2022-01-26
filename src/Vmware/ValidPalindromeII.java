package Vmware;


//Input: s = "aba"
//Output: true
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {

        int left = 0, right = s.length()-1, count = 0;

        //delete left
        while(left < right){

            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                count++;
                left++;
            }
        }

        if(count < 2){
            return true;
        }

        count = 0;left = 0; right = s.length()-1;

        //delete left
        while(left < right){

            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                count++;
                right--;
            }
        }

        if(count < 2){
            return true;
        }

        return false;
    }
}
