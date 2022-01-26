package Uber;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 773
// Input: board = [[1,2,3],[4,0,5]]
//Output: 1
public class Sliding_Puzzle {

    public static int slidingPuzzle(int[][] board) {
        //initiate
        int row = board.length;
        int col = board[0].length;
        int level = 0;
        String target = "";
        String start = "";
        HashSet<String> set = new HashSet();
        Queue<String> q = new LinkedList();
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        /* build target and start string */
        for(int i = 0; i < row*col; i++){
            target += i;
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                start += board[i][j];
            }
        }

        q.offer(start);
        set.add(start);

        //loop queue
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(target)){

                    return level;
                }
                int index = cur.indexOf('0');
                int r = index/col;
                int c = index%col;

                for(int[] dir: dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if(x >= row || x < 0|| y < 0|| y >= col) continue;
                    int newIndex = x*col + y;
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(index, cur.charAt(newIndex));
                    sb.setCharAt(newIndex, cur.charAt(index));
                    String next = sb.toString();

                    if(set.contains(next)) continue;
                    set.add(next);
                    q.offer(next);
                }
            }
            level++;

        }
        return -1;
    }


    public static void main(String[] args){
        int[][] test = new int[][]{{1,6,3},{8,7,2},{4,0,5}};
        System.out.print(slidingPuzzle(test));
    }
}
