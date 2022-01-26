package LinkedIn;


//Input: x = 4
//Output: 2
public class Sqrt {

    public int mySqrt(int x) {
        if(x <= 1) return x;
        int l = 2, r = x/2;

        while(l <= r){
            int mid = (l+r)/2;
            int sqrt = x/mid;

            if(sqrt == mid) return mid;

            if(sqrt < mid) r = mid -1;
            else l = mid +1;
        }
        return r;
    }

}
