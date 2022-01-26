package Expedia;


import java.util.*;

//1197   knight moves
public class Minimum_Knight_Moves {


    // Time  O(max(x,y)^2)
    //bfs   + dirs
    public int minKnightMoves(int x, int y) {
        int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

        // use 2d array to visited, due to 0<x+y < 300
        boolean[][] visited = new boolean[605][605];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        int step = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int ox = cur[0];
                int oy = cur[1];

                if(ox == x && oy == y){
                    return step;
                }

                for(int[] dir : dirs){

                    int nx = ox+dir[0];
                    int ny = oy+dir[1];

                    if(!visited[nx+302][ny+302]){
                        queue.offer(new int[]{nx,ny});
                        visited[nx+302][ny+302] = true;
                    }
                }

            }
            step++;

        }
        return step;
    }
}
