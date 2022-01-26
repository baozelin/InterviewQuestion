package Vmware;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


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
                    queue.add(x);
                }
            }

            //size >= k
            else{
                int cur = queue.poll();  // 0
                if( cur == 0){
                    numZero -= 1;
                }
                else{
                    product /= cur;
                }

                //add
                if(x == 0){
                    numZero++;
                }else{
                    queue.add(x);
                    product *= x;
                }
            }

            System.out.println(numZero);

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
    }

