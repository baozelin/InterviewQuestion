package Facebook;


//983
//You have planned some train traveling one year in advance. The days of the year in which you will travel are given as
// an integer array days. Each day is an integer from 1 to 365.
//
//Train tickets are sold in three different ways:
//
//a 1-day pass is sold for costs[0] dollars,
//a 7-day pass is sold for costs[1] dollars, and
//a 30-day pass is sold for costs[2] dollars.
//The passes allow that many days of consecutive travel.
//
//For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
public class Minimum_Cost_For_Tickets {

    /**
     *   // 类似coin change
        new dp[lastday+1]
       dp[i] = max(dp[i-1] + p of 1 , dp[i-7] + p of 7, dp[i-30] + p of 30)

     */
    public int mincostTickets(int[] days, int[] costs) {

        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay + 1];
        dp[0] = 0;
        boolean[] travels = new boolean[lastDay+1];

        //which day is traveling
        for(int day : days){
            travels[day] = true;

        }

        for(int i = 1; i <= lastDay; i++){
            //not travel day
            if(!travels[i]){
                dp[i] = dp[i-1];

            }

            // travel day
            else
            {

                dp[i] = dp[i-1] + costs[0]; // 1 day
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-7)] + costs[1]); //7 days
                dp[i] = Math.min(dp[i], dp[Math.max(0, i-30)] + costs[2]); // 30 days

            }
        }
        return dp[lastDay];

    }
}
