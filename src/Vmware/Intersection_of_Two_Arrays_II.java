package Vmware;

import java.util.ArrayList;
import java.util.Arrays;



//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
public class Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
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
