package Amazon;


import java.util.*;
import java.util.List;


//218
//Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
public class The_Skyline_Problem {


    // ideo:   build a list, <start height>, <end -height>
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> list = new ArrayList<>();
        if(buildings.length == 0 || buildings[0].length == 0) return list;
        List<int[]> height = new ArrayList<>();

        //build height,    index, height
        for(int i = 0; i < buildings.length; i++){
            height.add(new int[]{buildings[i][0], buildings[i][2]});  // start; positive
            height.add(new int[]{buildings[i][1], -buildings[i][2]});  // end; negative
        }

        // sort by index and
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return b[1] - a[1];
                else
                    return a[0] - b[0];
            }
        });

        //store max height
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        queue.offer(0);
        int cur = 0, pre = 0;
        for(int[] h : height){

            if(h[1] > 0){ //start
                queue.offer(h[1]);
            }
            else{ //end
                queue.remove(-h[1]);
            }

            cur = queue.peek();
            if(pre != cur){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(h[0]);
                tmp.add(cur);
                list.add(new ArrayList<>(tmp));
                pre = cur;
            }
        }
        return list;
    }
}
