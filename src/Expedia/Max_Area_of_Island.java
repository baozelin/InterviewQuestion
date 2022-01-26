package Expedia;


//695
public class Max_Area_of_Island {

    //dfs
    // O(r*c)
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
}
