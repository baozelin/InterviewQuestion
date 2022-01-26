package Facebook;


//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
public class Kth_Missing_Positive_Number {

    public int findKthPositive(int[] arr, int k) {

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + len;
    }
}
