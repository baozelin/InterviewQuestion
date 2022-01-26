package Codesignal;


import java.util.Comparator;
import java.util.PriorityQueue;

//第四题 路灯那题 给一个int[][] lamps  lamps[i][0] 代表了路灯i的坐标，  
// lamps[i][1] 代表了路灯i的照明半径，让你找出被罩到最多的坐标，如果有tie，就返回最小的那个
//
//[[-1, 3], [1, 2], [2, 3]]
//路灯0 的范围是 [-4, 2]
//路灯1 的范围是 [-1, 3]
//路灯3 的范围是 [-1, 5]
//所以[-1, 2] 这个范围三个灯都能照到， 返回最小的坐标就是-‍‌‍‌‌‌‍‍‍‍‍‍‍‍‌‌‌‌‍1
public class Lamps {


    public int solve(int[][] arr){

        // pair< position, isStart> 0 is, 1 not
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) return -1;
                else if(o1[0] > o2[0]) return 1;
                else{

                    return o1[1] - o2[1];
                }
            }
        });

        for(int[] cur: arr){

            pq.offer(new int[]{cur[0] - cur[1], 0});
            pq.offer(new int[]{cur[0] + cur[1], 1});

        }

        int count = 0;
        while(!pq.isEmpty()){

        }


        return -1;
    }
}
