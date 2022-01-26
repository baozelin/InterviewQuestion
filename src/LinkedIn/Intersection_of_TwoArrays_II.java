package LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection_of_TwoArrays_II {

    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList result = new ArrayList();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            if (nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = (int) result.get(i);
        }
        return res;
    }
}
