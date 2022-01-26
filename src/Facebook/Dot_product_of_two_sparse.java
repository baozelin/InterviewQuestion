package Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dot_product_of_two_sparse {



    //1.
    class SparseVector {
        HashMap<Integer, Integer> map;

        SparseVector(int[] nums) {
            map = new HashMap();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    map.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {

            int sum = 0;
            for(Integer index: this.map.keySet()){

                if(vec.map.containsKey(index)){
                    sum += this.map.get(index) * vec.map.get(index);
                }
            }
            return sum;
        }
    }


    //facebook: 面试官不希望使用hashmap记录 index ->val, 然后取2个hashmap中共有的key取出来做点乘。这样会浪费空间来存hashvalue
    class SparseVector2 {

        List<int[]> list = new ArrayList();
        SparseVector2(int[] nums) {


            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    list.add(new int[]{i,nums[i]});
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector2 vec) {
            int res = 0;
            List<int[]> passList = vec.list;
            int idx = 0, passidx = 0;

            while(idx < list.size() && passidx < passList.size()){
                int[] current = list.get(idx);
                int[] passArr = passList.get(passidx);

                if(current[0] == passArr[0]){
                    res += current[1] * passArr[1];
                    idx++;
                    passidx++;
                }
                else if(current[0] < passArr[0]){

                    idx++;
                }else{

                    passidx++;
                }
            }


            return res;
        }
    }
}
