package Uber;

import java.io.*;

import java.util.HashSet;

public class Phone_screen {


// Counting Rides of UberPools
//
// A group of people want to take UberPools to get to the same destination. But only people who are connected are willing to take the same Pool ride.
// Lets’ define two people are connected if they know each other directly or indirectly. E.g., if 0 knows 1 and 1 knows 0, 0 and 1 are connected; or if 0 and 1 know each other, 1 and 2 know each other, 0, 1, 2 are all connected. Each person has a unique unsigned integer as the ID;
// Given a list of 2-element tuple, like (0, 1), meaning 0 and 1 are connected, return the number of rides they need to call. You can assume there's no limit to the # of passengers per ride for now.

// Example 1: (0, 1), (1, 3), (2, 4) -> 2
// Example 2: (0, 1), (1, 0), (2, 2) -> 2
// Example 3: (1, 2), (3, 4), (2, 3) -> 1

// 0, 1, 2, 3
// (0, 1), (1,2)

// arr:    0, 1, 2, 3
//         0, 0, 0, 3



    // Main class should be named 'Solution'



        //   input[[1,2],....]
        public int solve(int[][] input, int n){

            int[] parents = new int[n];

            //initate
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }

            //loop input
            for(int i = 0; i < input.length; i++){
                int[] cur = input[i];
                int num1 = cur[0];
                int num2 = cur[1];
                int parent1 = find(parents, num1);
                int parent2 = find(parents, num2);

                if(parent1 != parent2){
                    parents[parent1] = parent2;
                }
            }

            // (0, 1), (1,2)
            //// arr:    0, 1, 2, 3
//                   0, 0, 1, 3

            HashSet<Integer> set  =new HashSet<>();
            //loop in input

            for(int i = 0; i < n;i++){
                int p = find(parents, i);
                set.add(p);
            }

            return set.size();

        }
        // used to find parent
        private int find(int[] parents, int n){
            int p = parents[n];

            while(p != parents[p]){
                p = parents[p];
            }

            return p;
        }


        // Example 1: (0, 1), (1, 3), (2, 4) -> 2
        // Example 2: (0, 1), (1, 0), (2, 2) -> 2
        // Example 3: (1, 2), (3, 4), (2, 3) -> 1




    public static void main(String[] args) {
        System.out.println("Hello, World");
        Phone_screen s = new Phone_screen();
        int[][] test1 = new int[][]{{0,1},{1,3},{2,4}};
        int[][] test2 = new int[][]{{0,1},{1,0},{2,2}};
        int[][] test3 = new int[][]{{0,1},{0,2},{2,3},{2,4}};
        int[][] test4 = new int[][]{{1,0},{2,0}};
        System.out.println(s.solve(test2, 3));
    }

}
