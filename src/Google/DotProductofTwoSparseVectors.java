package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//面经：
//input是两个int[]，一个array表示所有点的x，一个array表示所有点的y，让求这些点的点积和。
// 我说可以两个指针对应两个array的相同index，从左往右扫一遍计算点积并累加。然后小哥说这俩array可能非常稀疏而且需要频繁的query怎么优化。
//我说可以放cache里面。小哥说哦不止频繁query还频繁改动，我说那就建2个hashmap，把2个array所有非0项存成<index, value>，然后遍历比较短的那个map，比如xmap，如果ymap中存在相同的index那就算个点积，如果不存在就忽略。写了code。
//小哥又问如果某位置（index）的x或y要改成新值，如何更新dot product sum。答就是如果给的某点x值，
//if 原xmap没有这个index（也就是原array中此处x值为0），在xmap添上这个<index, value>
//if ymap没这个index，end
//if ymap有这个index，点积和加上这一对
//if 原xmap有这个index，
//if ymap没这个index，只需改xmap中的值
//if ymap有这个index，dot product sum 减旧点积 + 改值以后新点积

public class DotProductofTwoSparseVectors {

    /**
     *
     * hashmap way
    HashMap<Integer, Integer> map;
    DotProductofTwoSparseVectors(int[] nums) {
        map = new HashMap();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                map.put(i,nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductofTwoSparseVectors vec) {
        int res = 0;
        for(Integer key : this.map.keySet()){
            if(vec.map.containsKey(key)){
                res += this.map.get(key) * vec.map.get(key);
            }
        }
        return res;
    }


    **/


    List<int[]> list = new ArrayList();
    DotProductofTwoSparseVectors(int[] nums) {


        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                list.add(new int[]{i,nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductofTwoSparseVectors vec) {
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
