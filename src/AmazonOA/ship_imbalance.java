package AmazonOA;

public class ship_imbalance {

    //ship imbalance
    public static int findImbalance(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            int max = weights[i];
            int min = weights[i];
            for (int j = i; j < weights.length; j++) {
                max = Math.max(max, weights[j]);
                min = Math.min(min, weights[j]);
                sum += (max - min);
            }
        }
        return sum;
    }
}
