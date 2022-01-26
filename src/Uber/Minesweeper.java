package Uber;


//529
//Let's play the minesweeper game (Wikipedia, online game)!
//
//You are given an m x n char matrix board representing the game board where:
//
//'M' represents an unrevealed mine,
//'E' represents an unrevealed empty square,
//'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
//digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
//'X' represents a revealed mine.
//You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').
//
//Return the board after revealing this position according to the following rules:
//
//If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
//If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.
public class Minesweeper {

    int[][] dirs = new int[][]{{1,1}, {-1,1}, {1,-1},{-1,-1},{1,0},{0,1},{-1, 0}, {0, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {

        int rows= board.length;
        int cols = board[0].length;

        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        }

        else if(board[click[0]][click[1]] == 'E'){

            dfs(board, click[0], click[1], rows, cols);
        }
        return board;
    }

    void dfs(char[][] board, int i, int j, int rows, int cols){
        if(i<0||j<0||i>=rows||j>=cols||board[i][j]=='B')
            return;

        if(board[i][j] == 'E'){

            board[i][j] = count(board, i, j, rows, cols);

            if(board[i][j] == 'B'){


                for(int[] dir: dirs){

                    dfs(board, i+dir[0], j+dir[1], rows, cols);
                }
            }
        }
    }

    public char count(char[][]board,int i,int j,int rows,int columns)
    {
        //行是从0，rows-1;
        //列是从0，columns-1；
        int numbers=0;
        //该点上面有地雷(首先要在棋盘上：i-1>=0)
        if(i-1>=0&&board[i-1][j]=='M')numbers++;
        //该位置下面有地雷
        if(i+1<rows&&board[i+1][j]=='M')numbers++;
        //该位置左面有地雷
        if(j-1>=0&&board[i][j-1]=='M')numbers++;
        //该位置右面有地雷
        if(j+1<columns&&board[i][j+1]=='M')numbers++;
        //该位置左上有地雷
        if(i-1>=0&&j-1>=0&&board[i-1][j-1]=='M')numbers++;
        //该位置右下有地雷
        if(i+1<rows&&j+1<columns&&board[i+1][j+1]=='M')numbers++;
        //该位置左下有地雷
        if(i+1<rows&&j-1>=0&&board[i+1][j-1]=='M')numbers++;
        //该位置右上
        if(i-1>=0&&j+1<columns&&board[i-1][j+1]=='M')numbers++;
        //char型数组所以要返回char型的，如果四周都没有就返回B
        return (numbers==0)?'B':(char)(numbers+'0');

    }
}
