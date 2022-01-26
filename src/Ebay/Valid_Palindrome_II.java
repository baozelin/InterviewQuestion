package Ebay;




//680. Valid Palindrome II
//Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//Input: s = "aba"
//Output: true

    public class Valid_Palindrome_II {

        public boolean validPalindrome(String s) {
            int left = 0, right = s.length()-1, count = 0;

            //delete left
            while(left < right){

                if(s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }
                else{
                    if(count > 1) break;
                    count++;
                    left++;
                }
            }

            if(count < 2){
                return true;
            }

            count = 0;left = 0; right = s.length()-1;

            //delete right
            while(left < right){

                if(s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }
                else{
                    if(count > 1) break;
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
