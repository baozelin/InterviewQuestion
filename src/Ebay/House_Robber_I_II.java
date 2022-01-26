package Ebay;

public class House_Robber_I_II {

    // House robber 1
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


    //house robber 2:
    // circle

    //因为房子是环形排列的，所以第一个房子和最后一个房子是相邻关系。
    //
    //于是我们就在House Robber的基础上稍加修改即可：
    //
    //打劫范围为第一间房子到倒数第二间房子
    //打劫范围为第二件房子到最后一间房子
    //选择两者中较大者即是答案！

    public int rob2(int[] nums) {
        if(nums.length ==1) return nums[0];

        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }


    int rob(int[] nums, int begin, int end){
        int pre1 = 0;
        int pre2 = 0;
        int cur = 0;
        for(int i=begin; i<end; i++)
        {
            cur = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
