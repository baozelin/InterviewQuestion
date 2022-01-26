package Facebook;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxvalue = 0;

        for(int i = 0; i < prices.length; i++){

            int num = prices[i];
            min = Math.min(num, min);
            maxvalue = Math.max(maxvalue, num - min);
        }

        return maxvalue;


    }
}
