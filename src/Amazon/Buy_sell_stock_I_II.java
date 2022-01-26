package Amazon;

public class Buy_sell_stock_I_II {

    //keep min
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxvalue = 0;

        for(int i = 0; i < prices.length; i++){

            int num = prices[i];
            min = Math.min(num,min);
            maxvalue = Math.max(maxvalue, num - min);
        }

        return maxvalue;


    }

    public int maxProfit_II(int[] prices) {

        int max = 0;

        for(int i = 1; i < prices.length; i++){

            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }

        return max;

    }


    //Find the maximum profit you can achieve. You may complete at most two transactions
    public int maxProfit_iii(int[] prices) {

        if(prices.length < 0) return 0;

        int[] local = new int[3];
        int[] global = new int[3];

        for(int i= 1; i<prices.length;i++){

            int diff = prices[i] -prices[i-1];

            for(int j=2; j > 0; j--){


                local[j] = Math.max(global[j-1]+diff, local[j]+diff);

                //local[j] = Math.max(global[j-1], local[j]);

                global[j] = Math.max(local[j],global[j]);


            }

        }
        return global[2];
    }


    //Find the maximum profit you can achieve. You may complete at most k transactions.
    public int maxProfit_IIII(int k, int[] prices) {
        if(prices.length < 0 || k == 0) return 0;

        if(prices.length ==2) return prices[1] -prices[0] >0? prices[1] -prices[0]:0;

        int[] local = new int[k+1];
        int[] global = new int[k+1];

        for(int i= 1; i<prices.length;i++){

            int diff = prices[i] -prices[i-1];

            for(int j=k; j > 0; j--){


                local[j] = Math.max(global[j-1]+diff, local[j]+diff);

                //local[j] = Math.max(global[j-1], local[j]);

                global[j] = Math.max(local[j],global[j]);


            }

        }
        return global[k];


    }
}
