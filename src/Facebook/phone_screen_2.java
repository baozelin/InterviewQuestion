package Facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class phone_screen_2 {

// Given a string S and a dictionary D, find out all possible ways to split S using words in D.  Add spaces in S so that each word in the string is a valid word in the dictionary.
// S = 'abcd' D = ['a', 'b', 'ab', 'cd'] -> ['a b cd', 'ab cd']


    /**
     abcd

     index, s, cur, res

     abcd; backtrack
     return res;


     dfs:
     corner:
     idex == len(s): res.add(cur)



     for start--- len(s): substring(start, i)

     string tmp = substring(start, i);
     if(tmp in D) {
     if( len(cur) == 0) {
     dfs(start+1, tmp, res);
     }
     dfs(start+1, cur+ " "+ tmp, res);
     }



     **/

//// S = 'abcd' D = ['a', 'b', 'ab', 'cd'] -> ['a b cd', 'ab cd']


    public List<String> solve(String s, HashSet<String> map){

        List<String> res = new ArrayList<>();
        if(s.length() == 0) return res;

        dfs(s, 0, "", map, res);
        return res;
    }

// a b cd, ab cd
// cur: ab cd
// tmp : cd
// idx: 2

//abdd   -- ab
// abcd   n^2
//O( n + e) (len(s) +
// O(N!)

    void dfs(String s, int idx, String cur, HashSet<String> map, List<String> res){

        // end
        if(idx == s.length()){
            res.add(cur);
        }
        //loop
        for(int i = idx+1; i <= s.length(); i++){
            String tmp = s.substring(idx, i);
            // exist
            System.out.println(tmp);
            if(map.contains(tmp)){
                // first word
                if(cur.length() == 0){
                    dfs(s, i, tmp, map, res);
                }

                else{
                    dfs(s, i, cur+ " " + tmp, map, res);
                }
            }

        }
    }


    public static void main(String[] args){
        phone_screen_2 p = new phone_screen_2();
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("cd");
        set.add("ab");

        System.out.print(p.solve("abcd", set));
    }



// Find Kth largest value in unordered array.

//   input = [3,6,2,18,29,4,5] K = 1
//
// priorityQueue, maxheap  N, len(K)  O(n) * logk
// (logn) * n

// corner right, kth, left

    public int solve(int[] arr, int k){

        if(arr.length == 0) return -1;

        return quick(arr, 0, arr.length-1, arr.length-k);


    }



    int quick(int[] nums, int start, int end, int k){
        if(start >= end) return nums[k];

        int left =start, right = end;

        int mid = (left + right)/2;

        while(left <= right){

            // find greater
            while(left <= right && nums[left] <  nums[mid]){
                left++;
            }

            //find smaller
            while(left <= right && nums[right] >  nums[mid]){
                right--;
            }

            //swap

            if(left <= right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++;
                right--;
            }


        }

        if(k < right){
            return quick(nums, start, right, k);
        }

        if(k > left){

            return quick(nums, left, end, k);
        }

        //right, kth, left,
        return nums[k];

    }









}
