package Pony.ai;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;
        int[] buys = new int[prices.length];
        int[] sells = new int[prices.length];

        sells[0] = 0;
        buys[0] = -prices[0];

        for(int i = 1; i < prices.length; i++){

            sells[i] = Math.max(sells[i-1], buys[i-1] + prices[i]);

            if(i < 2){
                buys[i] = Math.max(buys[i-1], -prices[i]);
            }
            else{

                buys[i] = Math.max(buys[i-1], sells[i-2] - prices[i]);
            }
        }

        return sells[prices.length-1];
    }
}
