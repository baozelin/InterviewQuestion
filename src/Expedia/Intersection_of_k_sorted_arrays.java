package Expedia;

import java.util.*;
import java.util.Arrays;

public class Intersection_of_k_sorted_arrays {

    //k array
    // O(n*k)

    //[[1,3,5,7], [1,1,3,5,7],[1,4,7,9], [1,7],[1,2,3,7]]
    public static int[] intersectKth(int[][] nums) {
        int[] tmp = nums[1];
        for(int i = 1; i < nums.length ;i++){
            tmp = intersect(tmp, nums[i]);
        }
        return tmp;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer>  result = new ArrayList<>();
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

    //[[1,3,5,7], [1,1,3,5,7],[1,4,7,9], [1,7],[1,2,3,7]]
    public static void main(String[] args){
        int[][] test = new int[][]{{1,3,5,7}, {1,1,3,5,7},{1,4,7,9},{1,7},{1,2,3,7}};

        int[] res = intersectKth(test);
        System.out.println(res.length);

        for(int i : res){
            System.out.println(i);
        }
    }


    //leetcode 2 array
    public int[] intersect_lc(int[] nums1, int[] nums2) {
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
