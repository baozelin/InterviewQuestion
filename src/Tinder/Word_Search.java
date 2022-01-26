package Tinder;


//79
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true
public class Word_Search {

    //dfs
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        boolean[][] visit = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 1, word, visit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, int pos, String word, boolean[][] visit){

        if(pos == word.length())  return true;

        char c = word.charAt(pos);
        visit[i][j] = true;

        if(i -1 >= 0 && board[i-1][j] == c && !visit[i-1][j])
            if(dfs(board, i-1, j, pos+1, word, visit)) return true;

        if(j -1 >= 0 && board[i][j-1] == c && !visit[i][j-1])
            if(dfs(board, i, j-1, pos+1, word,visit)) return true;

        if(i+1 < board.length && board[i+1][j] == c && !visit[i+1][j])
            if(dfs(board, i+1, j, pos+1, word,visit)) return true;

        if(j+1 < board[0].length && board[i][j+1] == c && !visit[i][j+1])
            if(dfs(board, i, j+1, pos+1, word,visit)) return true;

        visit[i][j] = false;
        return false;
    }

    //followup 可以多次，那就删除visit[][]
}
