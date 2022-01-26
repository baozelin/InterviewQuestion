package Google;

public class MaxareaofIsland_onepass {


    private static final int[][] OFFSETS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int countIsland(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] visited = new int[m][n]; //0:not visited, 1:vistied and valid, -1:visited and invalid, can reuse the input matrix by 0/1, 2, -1 correspondingly
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if (input[row][col] == 1 && visited[row][col] == 0) {
                maxArea = Math.max(maxArea, dfs(input, row, col, m, n, visited));
            }
        }
        }
        return maxArea;
    }
    private static int dfs(int[][] input, int row, int col, int m, int n, int[][] visited) {
        int count = 0;
        boolean[] zeroNeighbors = new boolean[OFFSETS.length];

        visited[row][col] = 1; //mark as visited first and change to -1 later if needed (to prevent revisiting)

        if (input[row][col] == 0) { // cell value 0, need to traverse all 0 neighbors and until meeting border or all 1's
            for (int i = 0; i < OFFSETS.length; i++) {
                int[] offset = OFFSETS[i];
                int newRow = row + offset[0];
                int newCol = col + offset[1];
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol] == -1) {
                    visited[row][col] = -1;
                    return 0;
                }
                //if (input[newRow][newCol] == 0) {
                //  zeroNeighbors = true;
                //}
                if (visited[newRow][newCol] == 1) { //visited previously then don't count double

                    continue;

                }
                count += dfs(input, newRow, newCol, m, n, visited);
                if (visited[newRow][newCol] == -1) { //the DFS recursive call marked this neighbor invalid
                    visited[row][col] = -1;

                    return 0;

                }

            }

        }
        for (int i = 0; i < OFFSETS.length; i++) { // traverse all neighbors for cell value 1 or traverse the non-zero neighbors for cell value 0

            //if (zeroNeighbors) {
              //  continue;
            //}

            int[] offset = OFFSETS[ i ];

            int newRow = row + offset[0];

            int newCol = col + offset[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol] != 0) {

                continue;

            }



            count += dfs(input, newRow, newCol, m, n, visited);
        }

        return count + 1; //+1 to count this cell itself

    }
}
