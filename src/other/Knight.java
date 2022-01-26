package other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Knight {
/**
    On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
    A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

    Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
    The knight continues moving until it has made exactly k moves or has moved off the chessboard.
    Return the probability that the knight remains on the board after it has stopped moving.


            Input: n = 3, k = 2, row = 0, column = 0
    Output: 0.06250
    Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
    From each of those positions, there are also two moves that will keep the knight on the board.
    The total probability the knight stays on the board is 0.0625.

            1/16
            2/8 * ½


    M length of board row
    N length of board column
    check(n, n, nextx, nexty {
        if(next
        )
            Total move k    level
        Every to 8 move  level ///  8^k
        O(8 ^ k)
        8 * 8*8*8..
                Level1:  2 success move /  8(all in queue)
        Level2:  1 success move/ 8
        Queue.
                Return 2/8 * 1/8
// double pro = 0.0
//      queue:
//           level  in queue
//            pro *= sucees/ total(all possbile)
//
//
//return  pro

        0,0: 2/8 = 0.25

        2: 2/8 =0.25
        2/8*2/8 =0.0625
**/



    public double knightProbability(int n, int k, int row, int column) {

            Double pro = 1.0;
            // {x,y}
            Queue<int[]> queue = new LinkedList<>();
            HashSet<String> set = new HashSet<>();

            int[][] directions = new int[][]{{2, 1}, {1, 2}, {-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}, {2, -1}, {1, -2}};

            int level = 0;
            queue.add(new int[]{row, column});
            set.add(row + "," + column);

            while (!queue.isEmpty()) {

                int size = queue.size();

                int succee = 0;

                if (level > k) return pro;

                for (int i = 0; i < queue.size(); i++) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    //next level

                    for (int[] dir : directions) {
                        int nextx = x + dir[0];
                        int nexty = y + dir[1];

                        if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= n || set.contains(row + ',' + column))
                            continue;
                        else {

                            succee++;
                            queue.add(new int[]{nextx, nexty});
                            set.add(row + "," + column);


                        }
                    }
                }
                // level end
                if (level == 0) continue;
                pro *= (double) succee / size;
                level++;

            }
            return 0.0;


    }


    public static void main(String[] args){
        Knight k = new Knight();
        System.out.print(k.knightProbability(3,2,0,0));
    }

}
