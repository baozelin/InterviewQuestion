package wepay;


//509
public class Fibonacci_Number {

    public int fib(int N) {

        if(N == 0) return 0;
        if(N == 1) return 1;

        int[] list = new int[N+1];
        list[0] = 0;
        list[1] = 1;

        for(int i = 2; i < N+1; i++){
            list[i] = list[i-1]+list[i-2];
        }

        return list[N];
    }
}
