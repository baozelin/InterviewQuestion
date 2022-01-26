package LinkedIn;


//50
//Pow(x,n)
//Input: x = 2.00000, n = 10
//Output: 1024.00000

public class pow {
    public double myPow(double x, int n) {
        if(n < 0)
            return 1/pow(x,-n);
        else
            return pow(x,n);
    }


    double pow(double x, int n){
        if(n == 0) return 1.0;
        double tmp = pow(x,n/2);
        if(n % 2 == 0)
            return tmp * tmp;
        else
            return tmp * tmp * x;
    }



    public double myPow2(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;

    }

}
