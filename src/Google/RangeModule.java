package Google;

import java.util.LinkedList;
import java.util.List;


//leetcode 715
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//Output
//[null, null, null, true, false, true]
public class RangeModule {

    List<int[]> range;
    public RangeModule() {
        range = new LinkedList<>();
    }

    public void addRange(int left, int right) {
        List<int[]> tmp = new LinkedList();
        boolean insert = false;
        for(int[] r: range){

            // [] < range
            if(right < r[0] && !insert){
                tmp.add(new int[]{left, right});
                insert = true;
            }

            //not in this range
            if(r[0] > right || r[1] < left){
                tmp.add(r);
            }
            else{
                left = Math.min(left, r[0]);
                right = Math.max(right, r[1]);
            }
        }
        if(!insert){
            tmp.add(new int[]{left, right});
        }
        range = tmp;
    }

    public boolean queryRange(int left, int right) {
        int l = 0;
        int r = range.size()-1;

        while(l <= r){
            int mid = (l+r)/2;
            int[] p = range.get(mid);
            if(right < p[0]){
                r = mid-1;
            }else if(p[1] < left){
                l = mid+1;
            }else{
                return p[0] <= left && p[1] >= right;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        List<int[]> tmp = new LinkedList();
        for(int[] r:range){

            //not in this range
            if(r[0] > right || r[1] < left){
                tmp.add(r);
            }else{
                if(r[0] < left){
                    tmp.add(new int[]{r[0], left});
                }
                if(r[1] > right){
                    tmp.add(new int[]{right, r[1]});
                }
            }
        }
        range = tmp;
    }
}
