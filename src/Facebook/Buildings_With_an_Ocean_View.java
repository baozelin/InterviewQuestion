package Facebook;


//1762
//Input: heights = [4,2,3,1]
//Output: [0,2,3]

import java.util.ArrayList;
import java.util.List;

public class Buildings_With_an_Ocean_View {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i = heights.length-1; i >= 0; i--){

            int cur = heights[i];
            if(cur > max){
                list.add(i);
                max = Math.max(cur, max);
            }
        }

        int[] ret = new int[list.size()];
        int k = 0;
        int i =list.size()-1;
        while(i >= 0){
            ret[k] = list.get(i);
            i--;
            k++;
        }
        return ret;
    }
}
