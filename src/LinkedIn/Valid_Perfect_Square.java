package LinkedIn;

public class Valid_Perfect_Square {

    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;

        long l = 0, r = num/2;

        while(l <= r){

            long mid = (l+r)/2;
            long val = mid*mid;

            if(val == num) return true;

            else if(val > num){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return false;
    }

}
