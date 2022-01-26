package Facebook;


//1091 Shortest Path in Binary Matrix

import java.util.*;


// bfs
public class Shortest_Path_in_Binary_Matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node node = q.remove();
            int size = node.size + 1;

            if (!isValid(node.row, node.col, grid)) {
                continue;
            }

            if (!visited.add(node.row+","+node.col)) {
                continue;
            }
            if (node.row == grid.length-1 && node.col == grid[0].length-1) {
                return size;
            }
            q.add(new Node(node.row-1, node.col, size));
            q.add(new Node(node.row+1, node.col, size));
            q.add(new Node(node.row, node.col+1, size));
            q.add(new Node(node.row, node.col-1, size));
            q.add(new Node(node.row-1, node.col-1, size));
            q.add(new Node(node.row-1, node.col+1, size));
            q.add(new Node(node.row+1, node.col-1, size));
            q.add(new Node(node.row+1, node.col+1, size));
        }
        return -1;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
    }

    class Node {
        int row;
        int col;
        int size;
        private Node(int r, int c, int s) {
            row = r;
            col = c;
            size = s;
        }
    }

}
