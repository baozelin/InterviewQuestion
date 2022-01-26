package Vmware;

import java.util.*;

public class phone_interview {

    // https://www.wmware.com

// get, put, post
//post{
    //   url:
//}
// url --> request

// Warm up:
// Question:
// Let's say you are planning for a road trip with a car, the goal is to find the shortest time for you to get from point A to point B. 
// Given
// * location A
// * location B
// * a list of location pairs that tells you which two locations are connected.

// Let's Assume that it takes 1 unit of time to travel between a pair of connected locations

//Input: 1, 4, [[1,2], [1,3], [2,3], [3,4],  [1, 5]]




        //. 1,3,4.  2
//999999 > int
//. List[]. 0,,,4  index. 0, 1,    2.   3.   4,
//                  list    2,3.  3.1  1,2,4.  3
// pscode:
// int leve =0;

// hashset visited
//    queue add(start);
//    while
//.        int size
//.          for(size){
        //           loop.  next postion.  : !not set
        //.                   end case. next === target:
        //                        return level
        //.                 queue.add(npostion)
        //
        //
        //
//}
//

        public int solve(int start, int end, int[][] arr){
            if(arr.length == 0) return 0;

            HashSet<Integer> points = new HashSet<>();

            if(start == end) return 0;

            int max = 0;   //4
            for(int[] p: arr){
                points.add(p[0]);
                points.add(p[1]);
                max = Math.max(p[0], max);
                max = Math.max(p[1], max);
            }

            List<Integer>[] map = new List[max+1];

            if(!points.contains(end) || !points.contains(start)) return -1;


            // build data structure
            for(int i = 0; i < arr.length; i++){

                int[] cur = arr[i];
                if(map[cur[0]] == null){
                    map[cur[0]] = new ArrayList<>();
                }
                map[cur[0]].add(cur[1]);

                if(map[cur[1]] == null){
                    map[cur[1]] = new ArrayList<>();
                }
                map[cur[1]].add(cur[0]);
            }


            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> set = new HashSet<>();

            queue.add(start);
            set.add(start);

            //bfs
            int level = 0;
            while(!queue.isEmpty()){

                int size = queue.size();

                for(int j = 0; j < queue.size(); j++){    //  wrong : should change to  for(int j = 0; j < size; j++){

                    int num = queue.poll();
                    List<Integer> nextPoint = map[num];

                    for(int k = 0; k < nextPoint.size(); k++){
                        int next = nextPoint.get(k);

                        //end case
                        if(next == end){
                            return level+1;
                        }

                        if(!set.contains(next)){
                            queue.add(next);
                            set.add(next);
                        }
                    }
                }

                level++;
            }
            return -1;
        }



        // [1,1].    1.   1



        public static void main(String args[] ) throws Exception {
            phone_interview s = new phone_interview();
            int[][] test = new int[][]{{1,2}, {1,3}, {2,3}, {3,4},{1, 5}};
            int[][] test1 = new int[][]{{1,2}, {1,3}, {2,3}, {3,4}, {3,2}, {1, 5}};
            int[][] test2 = new int[][]{{1,2}, {2,3}, {1,3}, {3,5}, {1, 5}};
            int[][] test3 = new int[][]{{1,1}, {2,3}, {1,3}, {3,5}};

            System.out.println(s.solve(1, 5, test3));
        }



        // question 2
    //  LRU

    // question3 : product of latest K elements
    /*

# Design a data structure that supports the following 3 operations
# - a constructor that takes a parameter K
# - add(x) - inserts the number x
# - get() - returns the product of the last K elements inserted

*/
// k = 2
//.  datasturture:    1 ,2 ,3, 4.
// get()---> 3 * 4 = 12


//. idea !  linkedlist.  1 , 2, 3, 4.
//.   get():  loop in k:   O(k) ----> O(1)
//          return product
//.  add(x) : O(1)


//  int product
//  int index    <left. k...  right>
//  linkedlist
// 1, 2, 3, 4,
// data stucture

//.   every time: add new val
//.  case 1: list size < k. ---> product *= val

//.   k = 4, product = 24
//    index = 1
//.   1 ,2 ,3 , 4
//   add(4)
//

//.  add(5) ---> 24 / 1 * 5,   index++.
// get(). return 120

// add(6). ---> 120 / 2 * 6 = 360. , index++ (3)
//


//.  case 2: size > k.   ---> 1. product/list[left], 2. product *= val, left++;


//. space(O(length(list))) O(n).
// why linkedlist. --> queue
//  queue.      O(k).
//.



    class Solution {

        int k;
        int numZero;
        Queue<Integer> queue;
        int product;
        public Solution(int k){
            if(k == 0){
                this.product = 0;
            }
            this.k = k;
            queue = new LinkedList<>();
            product = 1;
            numZero = 0;
        }


        private void add(int x){
            if(this.k == 0){
                return;
            }

            if(queue.size() < k){
                if(x == 0){
                    numZero++;

                }
                else{
                    product *= x;

                }
                queue.add(x);
            }

            //size >= k
            else{
                int cur = queue.poll();  // 0
                if( cur == 0){
                    numZero--;
                }
                else{
                    product /= cur;
                }

                //add
                if(x == 0){
                    numZero++;
                }else{
                    //queue.add(x);
                    product *= x;
                }
                queue.add(x);
            }

            //System.out.println("num," + numZero);

        }

        private int get(){
            //System.out.println(numZero);
            if(numZero > 0)
                return 0;
            else
                return this.product;
        }

        // k 3
        //// 1, 2, 3, 4,

        /**
        public static void main(String args[] ) throws Exception {
            Solution s  = new Solution(3);
            s.add(1);
            s.add(2);
            System.out.println(s.get());
            s.add(3);

            System.out.println(s.get());  // 6
            s.add(0);
            System.out.println(s.get());   //0

            s.add(5);
            System.out.println(s.get());   //0

            s.add(2);
            System.out.println(s.get());  // 10

            s.add(3);
            System.out.println(s.get()); // 6
            s.add(4);
            System.out.println(s.get());  // 24
            // kkota@vmware.com
        }
         **/
    }


}
