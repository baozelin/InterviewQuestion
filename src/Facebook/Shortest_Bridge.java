package Facebook;

import java.util.LinkedList;
import java.util.Queue;

//934
//// In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
//
//Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
//
//Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
// dfs + bfs
public class Shortest_Bridge {

    int[] xdir={-1,0,1,0};
    int[] ydir={0,-1,0,1};


    public int shortestBridge(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited= new boolean[grid.length][grid[0].length];

        //Find
        a: for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, visited, i, j, q);
                    break a;
                }
            }
        }
        int ret = bfs(grid, visited, q);
        return ret;
    }




    public void dfs(int[][] grid, boolean[][] visited, int x, int y, Queue<int[]> q){
        visited[x][y]=true;
        q.add(new int[]{x, y});

        for(int d = 0;d < 4;d++){
            int r= x + xdir[d];
            int c= y + ydir[d];
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){

                if(visited[r][c]==false){
                    dfs(grid, visited, r,c,q);
                }
            }
        }


    }
    public int bfs(int[][] grid, boolean[][] visited, Queue<int[]> q){

        int level = -1;

        while(!q.isEmpty()){
            int size= q.size();
            level++;

            while(size-->0){
                int[] cur= q.poll();

                visited[cur[0]][cur[1]]=true;

                for(int d = 0; d < 4; d++){
                    int r= cur[0] + xdir[d];
                    int c= cur[1] + ydir[d];

                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length){

                        if(visited[r][c]==false){
                            if(grid[r][c]==1){
                                return level;
                            }

                            q.add(new int[]{r,c});
                            visited[r][c]=true;
                        }
                    }

                }

            }

        }

        return level;
    }

}
