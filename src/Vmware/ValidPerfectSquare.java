package Vmware;

public class ValidPerfectSquare {

    //binary search  Time complexity : O(logN)
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;

        long l = 0, r = num/2;
        while(l <= r){
            long mid = (l+r)/2;

            if(num == mid*mid){
                return true;
            }
            else if(mid*mid> num){
                r = mid-1;

            }else{
                l = mid+1;
            }
        }

        return false;
    }
}
