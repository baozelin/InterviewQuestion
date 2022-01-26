package AmazonOA;

import java.util.*;


//Get the sum of min and max diff for all subarrays
//
//[2,4,3,5]
//
//wrong: sum = (4 - 2) + (4 - 3) + (5 - 3) + (3 - 2) + (5 - 4) + (5 - 2) = 10
//
//sum = (4 - 2) + (4 - 3) + (5 - 3) + (4 - 2) + (5 - 3) + (5 - 2) = 12
//
//O(n2) exceeds time limit
public class Sum_of_Subarray_Minimums {



    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = (int) 1e9 + 7;
        int currentStackValue = 0;

        // int[]{value, count}
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int currentCount = 1;
            int currentValue = arr[i];

            while (!stack.isEmpty() && stack.peek()[0] >= currentValue) {
                int[] popped = stack.pop();
                currentStackValue -= popped[1] * popped[0];
                currentCount += popped[1]; // assign all previous count to current
            }
            stack.push(new int[]{currentValue, currentCount});
            currentStackValue += currentValue * currentCount;
            sum = (sum + currentStackValue) % mod;
        }
        return sum;
    }


        public static void WriteMaxValueOfSubArray(int[] arr)
        {
            int sum = 0;
            int[] nextLargest = arr;
            Arrays.sort(nextLargest);
            Integer[] previousLart = new Integer[arr.length];
            for(int i = 0; i < arr.length;i++){
                previousLart[i] = arr[i];
            }


            //nextLargest = nextLargest.OrderBy(x => x).ToList();
            Arrays.sort(previousLart, new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return b -a;
            }
        });
            //previousLart = previousLart.OrderByDescending(x => x).ToList();
            for(int i = 0; i < arr.length; i++)
            {
                int numSubarrays = (nextLargest[i] - i+1) * (i-previousLart[i]+1);
                sum += numSubarrays;
            }

           System.out.print(sum);
        }




    public static void main(String[] args){

       WriteMaxValueOfSubArray(new int[]{2,4,3,5});

    }

}
