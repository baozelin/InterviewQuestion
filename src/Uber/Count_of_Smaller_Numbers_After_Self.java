package Uber;


import java.util.*;

//315
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
public class Count_of_Smaller_Numbers_After_Self {


    //算法复杂度 O(n^2)，因为插入排序会移动位置
    // binary + insert
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = nums.length -1; i >= 0; i--){
            res.add(0, insert(list, nums[i]));
        }
        return res;
    }


    //return position
    int insert(List<Integer> list, int num){

        if(list.size() == 0){
            list.add(num);
            return 0;
        }

        int left = 0, right = list.size()-1;
        while(left <= right){

            int mid = (left + right)/2;
            if(list.get(mid) < num){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        list.add(left, num);
        return left;
    }

}
