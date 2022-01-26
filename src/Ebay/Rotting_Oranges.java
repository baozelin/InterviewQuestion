package Ebay;


import java.util.*;

//994
//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return
// -1.
public class Rotting_Oranges {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();


        int fresh = 0;
        int rows = grid.length, cols = grid[0].length;

        //find fresh, rotten
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){

                if(grid[r][c] == 2){
                    queue.offer(new int[]{r, c});
                }
                else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;

        int [][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = -1;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                //grid[cur[0]][cur[1]] = 2;   not here

                //next
                for(int[] dir: dirs){

                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1)
                        continue;

                    fresh--;
                    grid[x][y] = 2;  // should change here
                    queue.add(new int[]{x,y});
                }
            }
            level++;
        }

        return fresh == 0? level : -1;

    }
}
