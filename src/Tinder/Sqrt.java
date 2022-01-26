package Tinder;


//Input: x = 4
//Output: 2
public class Sqrt {

    public double mySqrt(int x, double p) {
        int tens = 1;
        while(p < 100){
            p *= 100;
            tens *= 10;
        }
        x *= tens*tens;


        if(x <= 1) return x;
        int l = 2, r = x/2;

        while(l <= r){

            int mid = (l+r)/2;
            int sqrt = x/mid;

            if(sqrt == mid){
                return mid/(double)tens;
            }

            if(sqrt < mid) r = mid -1;
            else l = mid +1;
        }
        return r/(double)tens;
    }


    public static void main(String[] args){
        Sqrt s = new Sqrt();
        System.out.print(s.mySqrt(5,0.001));
    }

}
