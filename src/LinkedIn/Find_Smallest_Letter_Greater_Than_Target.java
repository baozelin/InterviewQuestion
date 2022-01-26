package LinkedIn;


//744
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
public class Find_Smallest_Letter_Greater_Than_Target {


    //binary search
    public char nextGreatestLetter(char[] letters, char target) {

        int lo = 0, hi = letters.length-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(letters[mid] <= target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return letters[lo % letters.length];
    }
}
