package Amazon;

import java.util.*;

//47
public class Valid_Sudoku {


    //O(n^2)
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i< board.length;i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0;j<board[0].length;j++){               //1. check row by row
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for(int j = 0;j< board[0].length;j++){
            Set<Character> set = new HashSet<>();
            for(int i = 0;i< board.length;i++){                 //2. check column by column
                if(board[i][j] =='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        for(int i = 0;i<9;i ++){
            Set<Character> set = new HashSet<>();
            for(int j = 0;j<9;j++){                             //3. check each 3*3 subbox
                int m = i/3*3 + j/3;
                int n = i%3*3 + j%3;
                if(board[m][n] == '.') continue;
                if(set.contains(board[m][n])) return false;
                set.add(board[m][n]);
            }
        }
        return true;
    }
}
