package Facebook;


import java.util.Comparator;
import java.util.PriorityQueue;

//973
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
public class K_Closest_Points_to_Origin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue(k, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return getDis(b) - getDis(a);
            }
        });

        for(int i = 0; i < points.length; i++){
            pq.offer(new int[]{points[i][0], points[i][1]});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int index = 0;
        while (!pq.isEmpty()){
            int[] tmp = pq.poll();

            ret[index][0] = tmp[0];
            ret[index][1] = tmp[1];
            index++;
        }
        return ret;
    }




    int getDis(int[] a){
        return  (a[0] - 0) * (a[0] - 0) + (a[1] - 0) * (a[1] - 0);
    }
}
