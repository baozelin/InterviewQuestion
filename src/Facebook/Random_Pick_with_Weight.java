package Facebook;


//528 Random Pick with Weight
// prefix sum: left 0, right total sum
public class Random_Pick_with_Weight {
    int[] prefixSums;
    int total = 0;
    public Random_Pick_with_Weight(int[] w) {
        prefixSums = new int[w.length];
        int sum = 0;

        for(int i = 0; i < w.length; i++){
            sum += w[i];
            prefixSums[i] = sum;
        }
        total = sum;

    }

    public int pickIndex() {
        double target = total * Math.random(); // 0 <= x < 1

        for(int i = 0; i < prefixSums.length; i++){
            if(prefixSums[i] > target)
                return i;
        }
        return -1;
    }

    public int pickIndex_binary() {
        double target = total * Math.random();
        //int i = 0;
        int low = 0, high = this.prefixSums.length-1;

        // to find number less than target
        while (low <= high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid -1;
        }
        return low;
    }



}
