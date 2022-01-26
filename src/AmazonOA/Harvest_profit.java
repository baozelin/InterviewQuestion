package AmazonOA;



public class Harvest_profit {

    private static int solution(int[] profit, int k){
        int N = profit.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<N/k; i++){
            int curr = 0;
            int j = 0;
            int index = i;
            while(j<k){
                curr += profit[index] + profit[N/2+index];
                j++;
                index++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
