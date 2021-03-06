package CaptialOne;

//204
//
public class Count_prime {

    public int countPrimes(int n) {

        int[] mask = new int[n];
        int count = 0;

        for(int i = 2; i < n; i++){

            if(mask[i] == 0){

                count++;

                for(int j = 2; i * j < n; j++){
                    mask[i*j] = 1;
                }

            }

        }
        return count;

    }
}
