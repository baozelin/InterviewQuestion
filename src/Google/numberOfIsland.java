package Google;

public class numberOfIsland {


    //Time complexity : O(M \times N)O(M×N) where MM is the number of rows and NN is the number of columns
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m, n,visit);
                }
            }
        }
        return count;
    }

    //dfs
    private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visit){
        if( i < 0 || i >= m || j < 0 || j >= n ) return;
        visit[i][j] = true;

        //i-1, j
        if(i-1 >= 0 && !visit[i-1][j] && grid[i-1][j] == '1'){
            dfs(grid, i-1, j, m, n,visit);
        }
        //i+1
        if(i+1 < m && !visit[i+1][j] && grid[i+1][j] == '1'){
            dfs(grid, i+1, j, m, n, visit);
        }
        //i, j-1
        if(j-1 >= 0 && !visit[i][j-1] && grid[i][j-1] == '1'){
            dfs(grid, i, j-1, m, n, visit);
        }

        //i j+1
        if(j+1 <n && !visit[i][j+1] && grid[i][j+1] == '1'){
            dfs(grid, i, j+1, m, n,visit);
        }


    }
}
