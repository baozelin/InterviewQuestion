package CaptialOne;

//374
public class Guess_Number_Higher_or_Lower {

    //binary
    public int guessNumber(int n) {
        int left = 1, right = n;

        while(left <= right){

            int mid = left+ (right -left)/2;

            int res = guess(mid);
            if(res== 0) return mid;

            if(res < 0){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    int guess(int n){
        return -1;
    }


}
