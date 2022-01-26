package Facebook;

import java.util.ArrayList;
import java.util.List;

public class phone_interveiw {

    public List<List<Integer>> solve(int[] array) {
        List<List<Integer>> res = new ArrayList<>();

        //empty
        if (array.length == 0) return res;
        // loop

        // 1 ,2 ,3
        //for(int i = 0; i < array.length; i++){
        List<Integer> list = new ArrayList();
        dfs(array, list, res);
        //}
        return res;

    }


// dfs O( N + edge)   n!
// 1 2 3
// curlist 321
//res 123, 132, 213, 231, 312, 321

    void dfs(int[] array, List<Integer> curlist, List<List<Integer>> res) {
        if (curlist.size() == array.length) {
            res.add(curlist);
        }

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            if (!curlist.contains(num)) {
                curlist.add(num);
                dfs(array, curlist, res);
                //back
                curlist.remove(curlist.size() - 1);
            }
        }


    }


    /**
    //round 2

    Given an
    integer array, you
    are initially
    positioned at
    the first
    index of
    the array.
    Each element
    in the
    array represents
    your maximum
    hop length
    at that
    position.
            Determine if
    you are
    able to
    hop out
    of the
    array

    Input:nums =[2,3,1,1,4,3,1]
            ^
    Output:true


    //  [3,3,1,0,4,1]  --.true
    Input:nums =[3,2,1,0,4]
            ^
    Output:false


    Input:nums =[3,0,4,0,0,0,1,5]

    Output:true


    //[3,0,4,0,0,0,1,5] -> false

    /**
     * arr[0] = true;
     * <p>
     * arr[]   :   t, t, t, t, t ,t ,t ,t ,t  return true
     * loop 0 --> size:
     * e = 3  -> loop j 0--> e  //step  arr[e+i] = t
     * <p>
     * <p>
     * <p>
     * position 1;   arr[1]  false  return false
     **/
    //Input: nums = [3,2,1,0,4]

// arr[] true/false     [nums.length]
// loop:
//   int el  :3  --> arr[i+el] --> true
//   if(arr[i] == false) return false;
//   if( i + el >= nums.length) return true;

// return false


//[0,2,1,0,4]
    public boolean solve2(int[] nums) {
        if (nums.length == 0) return true;

        int max = 0;

        boolean[] arr = new boolean[nums.length];

        //fill first position
        arr[0] = true;


        // O(n)
        // O(n)
        // loop in nums
        for (int i = 0; i < nums.length; i++) {      // 0: t,

            // bad case, not reachable
            if (arr[i] == false) return false;


            int step = nums[i];  // 0

            // success to get end
            if (i + step >= nums.length) return true;

            // update arr based on step
            max = Math.max(max, i + step);

            if (i + step < max) continue;


            // i + step > max   max ---> step+i
            for (int position = max; position <= step + i; position++)   //   loop step O(k)

                arr[position] = true;

            max = Math.max(max, i + step);
        }



    return false;

    }

}




