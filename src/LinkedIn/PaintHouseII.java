package LinkedIn;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int min1 = 0; //当前这个house涂完最小的cost
        int min2 = 0; //当前这个house涂完第二小的cost
        int lastColor = -1; //上个house选择的颜色
        for(int i = 0; i<costs.length; i++){
            int curMin1 = Integer.MAX_VALUE; //选择到当前颜色时的最小cost
            int curMin2 = Integer.MAX_VALUE; //选择到当前颜色时的第二小cost
            int curColor = -1;
            for(int k = 0; k<costs[i].length; k++){
                int newCost = costs[i][k] + (k == lastColor ? min2 : min1);
                if(newCost < curMin1){
                    curMin2 = curMin1;
                    curMin1 = newCost;
                    curColor = k;
                }else if(newCost < curMin2){
                    curMin2 = newCost;
                }
            }
            min1 = curMin1;
            min2 = curMin2;
            lastColor = curColor;
        }
        return min1;
    }
}
