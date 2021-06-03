package DropboxOA;

public class gameoflife {

    public void gameOfLife(int[][] board) {

        // dead -> dead 0
        // live -> live 1
        // live -> dead 2
        // dead -> live 3

        if(board == null || board.length == 0)
            return;

        int m = board.length; // rows
        int n = board[0].length; // columns

        // first iteration: mark states for each cell
        for(int i=0; i<m; i++) // rows
        {
            for(int j=0; j<n; j++) // columns
            {
                int cnt = 0;
                // count cell's live neighbors 3x3 matrix and set boundary
                for(int x= Math.max(0, i-1); x<= Math.min(m-1, i+1); x++)
                {
                    for(int y= Math.max(0, j-1); y<= Math.min(n-1, j+1); y++)
                    {
                        if(x == i && y == j) // skip itself
                            continue;
                        // only state 1 and 2: cell are live for previous state
                        if(board[x][y] == 1 || board[x][y] == 2)
                            cnt++;
                    }
                }

                if(board[i][j] == 0 && cnt == 3) // current is dead cell
                    board[i][j] = 3; // dead -> live
                else if(board[i][j] == 1 && (cnt < 2 || cnt > 3)) // current live cell
                    board[i][j] = 2; // live -> dead
            }
        }

        // second iteration: convert state back to dead or live
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board[i][j] %= 2;
    }
}
