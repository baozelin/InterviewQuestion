package Flexport;

import java.util.ArrayList;
import java.util.List;

//board 8*8
//每一步黑棋只能走左下和右下，白棋只能走左上和右上

//           x x x x x x
//
//           o o o o o o
public class Game_of_check {

    char[][] board = new char[8][8];   // 'x', 'o', ' '

    public List<List<int[]>> getAllNextStep(char[][] board, char state){
        List<List<int[]>> res  = new ArrayList<>();

        int[][] direct = new int[][]{{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(int i = 0 ; i <board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int offset = 0;
                if(state == 'x'){
                    offset = 0;

                }else{
                    offset = 2;
                }

                for(int k = 0; k < 2; k++){

                    int nextX = direct[k+offset][0] + i;
                    int nextY = direct[k+offset][1] + j;

                    if(nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board.length || board[nextX][nextY] != ' '){
                        continue;
                    }

                    List<int[]> tmp = new ArrayList<>();
                    tmp.add(new int[]{i, j});
                    tmp.add(new int[]{nextX, nextY});
                    res.add(new ArrayList<>(tmp));
                }
            }
        }
        return res;
    }

    //followup
    //然后第二个follow-up是现在有一个新的棋子，叫国王，国王可以走任何方向，然后lz又加了个condition.

    public void moveTo(){

    }



}
