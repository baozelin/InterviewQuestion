package Google;


import java.util.ArrayList;
import java.util.List;

public class topicNumberofisland {

    //695  Max Area of Island
    boolean [][] visited;
    int max =0;
    public int maxAreaOfIsland(int[][] grid) {

        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max,dfs(grid, i, j));
            }
        }
        return max;

    }
    int dfs(int[][] grid, int i, int j){

        //cur += 1;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return 0;
        visited[i][j] = true;
        return 1 + dfs(grid, i+1,j) + dfs(grid,i-1,j) + dfs(grid,i,j-1) + dfs(grid,i,j+1);

    }


    // + + 130
    //让求最大的陆地面积，1表示陆地0表示水域。如果一圈陆地包围一片水域那么这块水域也算这个岛的面积。
// 这题做过，先给出了2pass做法。先遍历四条边界，以边界上的水域（0）开始dfs把与边界相连的水域标记为-1表示无效。
// 再全盘遍历，以1开始dfs无论01向四面扩展计数找岛的面积，然后global max记录最大岛面积。说完小哥说能不能1pass解决。
// 解法大概是全盘遍历，以1开始dfs无论01向四面扩展计数找岛的面积，如果触及边界上的水域就返回-1表示无效，然后把四面valid的面积累加。
// 写了code，自己fix了一个bug。小哥说this is the perfect solution im looking for,然后随便QA一下，完了还有10分钟就结束了。



    //1 1 1 1 0 1 0 0 0 0
    //1 0 1 0 1 1 1 1 0 0
    //1 1 1 0 1 1 1 1 0 0
    //0 0 0 0 1 0 0 0 0 0

    public int solve_2pass(int[][]board){

        if(board == null || board.length == 0) return -1;

        // two pass :step one, check edge 0
        List<int[]> list = new ArrayList();
        //build list
        for(int r = 0; r < board.length; r++){
            list.add(new int[]{r,0});
            list.add(new int[]{r,board[0].length-1});
        }

        for(int c = 0; c < board[0].length; c++){
            list.add(new int[]{0,c});
            list.add(new int[]{board.length-1,c});
        }
        //dfs list
        for(int[] p : list){
            dfs_check(board, p[0], p[1]);
        }

        //revisit board
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] == 0)
                    board[r][c] = 1;

            }
        }

        //step 2 count max island
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1)
                    max = Math.max(max,dfs_2(board, i, j));
            }
        }
        return max;

    }
    void dfs_check(int[][] board, int r, int c){
        if(board[r][c] != 0) return;
        board[r][c] = -1;
        if(r+1 < board.length)
            dfs_check(board, r+1, c);
        if(r-1 >= 0)
            dfs_check(board, r-1, c);
        if(c+1 < board[0].length)
            dfs_check(board, r, c+1);
        if(c-1 >= 0)
            dfs_check(board, r, c-1);
    }

    int dfs_2(int[][] grid, int i, int j){

        //cur += 1;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == -1)
            return 0;
        visited[i][j] = true;
        return 1 + dfs_2(grid, i+1,j) + dfs_2(grid,i-1,j) + dfs_2(grid,i,j-1) + dfs_2(grid,i,j+1);

    }








    public static void main(String[] args){
        //topicNumberofisland t = new topicNumberofisland();

        int[][] test1 = {{1,1,1,1,0,1,0,0,0},
                         {1,0,1,0,1,1,1,1,0,0},
                        { 1,1,1,0,1,1,1,1,0,0},
                         {0,0,1,0,1,0,0,0,0,0}};

        //System.out.println(t.solve_2pass(test1));
        String s = "1 2";
        System.out.print(s.split(" ")[1]);
    }
}
