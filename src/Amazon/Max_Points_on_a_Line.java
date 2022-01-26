package Amazon;


import java.util.HashMap;

public class Max_Points_on_a_Line {

    public int maxPoints(int[][] points) {

        if(points==null || points.length==0){
            return 0;
        }
        if(points.length<=2){
            return points.length;
        }
        int max=1;
        for(int i=0;i<points.length;i++){
            HashMap<Float,Integer> hm = new HashMap<Float,Integer>();
            int same=0;
            int localmax=1;
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                if(points[i][0]==points[j][0] && points[i][1]==points[j][1]){
                    same++;
                    continue;
                }
                float slope=((float)(points[i][1]-points[j][1]))/(points[i][0]-points[j][0]);
                if(hm.containsKey(slope))
                    hm.put(slope,hm.get(slope)+1);
                else
                    hm.put(slope,2);
            }
            for(Integer value:hm.values())
                localmax = Math.max(localmax,value);
            localmax+=same;
            max = Math.max(max,localmax);
        }
        return max;
    }

}
