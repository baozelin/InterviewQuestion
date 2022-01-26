package Google;



//有一辆电车和电池容量最大值为k，每天可以选择呆在原地回复一个unit的电，或者消耗一个unit的电行驶当天的距离。
// 每天能行驶的距离不同，用一个array表示每天可以开的距离[d1, d2, d3....]。求哪些天move可以让电车行驶的最远。
public class electricalcarUnity {

    //感觉和我最近做的871像？不过这题比871应该简单一点吧… 粗略写了一下
    // dfs + memo：stay=dfs(day+1, gas+1, dist) go=dfs(day+1, gas-1, dist+milesperday[day]) 只有gas>0 才能走go。
    // 最后return max(stay, go)；day的临界值是milesperday list的长度
    public int car(int[]milesperday){
        return dfs(0,milesperday.length, 1,0,milesperday);
    }

    int dfs(int day, int len, int gas, int dist, int[] miles){
        if(day >= len){
            return dist;
        }
        int stay = dfs(day+1, len,gas+1, dist, miles);

        int go = 0;
        if(gas > 0) {
            go = dfs(day+1, len, gas-1, dist + miles[day], miles);
        }
        return Math.max(stay, go);
    }



    public static void main(String[] args){
        electricalcarUnity e = new electricalcarUnity();

        int[] test = {1,2,3,4,5};
        System.out.println(e.car(test));
    }
}
