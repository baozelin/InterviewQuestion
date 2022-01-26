package LinkedIn;

import java.util.PriorityQueue;

//Given a sorted integer array nums and three integers a, b and c, apply a quadratic function of the form
// f(x) = ax2 + bx + c to each element nums[i] in the array, and return the array in a sorted order.
//Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//Output: [3,9,15,33]


public class Sort_Transformed_Array {
    class Solution {
        public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {

            //two point    O(n)
            int l = 0, r = nums.length-1;
            int[] ret = new int[nums.length];

            int index = a > 0? nums.length-1:0;
            while(l <= r){

                int left = quad(nums[l], a, b, c);
                int right = quad(nums[r], a, b, c);

                if(a < 0){

                    if(left <= right){
                        ret[index++] = left;
                        l++;
                    }else{
                        ret[index++] = right;
                        r--;
                    }
                }

                // a > 0
                else{
                    if(left >= right){
                        ret[index--] = left;
                        l++;
                    }
                    else{
                        ret[index--] = right;
                        r--;
                    }

                }

            }

            return ret;
        }


        int quad(int x, int a, int b, int c){
            return a*x*x + b*x + c;
        }


        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i : nums){
                int tmp = (int)(Math.pow(i,2))*a+b*i+c;
                pq.offer(tmp);
            }

            int[] ans= new int[nums.length];
            int count = 0;
            while(!pq.isEmpty()){
                ans[count++] = pq.poll();
            }
            return ans;
        }
    }
}
