package Uber;

import java.util.*;

public class Word_search_I_II {

    /**
     *
     * word search I backtrack
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     */
    public boolean word_search_I(char[][] board, String word) {
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


    boolean dfs(char[][] board, int row, int col, int pos, String word, boolean[][] visit){

        if(pos == word.length())  return true;

        char c = word.charAt(pos);

        visit[row][col] = true;

        int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || visit[newRow][newCol] || board[newRow][newCol] != c) {
                continue;
            }

            if(dfs(board, newRow, newCol, pos+1, word, visit)) return true;
        }
        visit[row][col] = false;

        return false;
    }



    /**
     *  Word_search II   trie + backtrack
     *
     * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
     * words = ["oath","pea","eat","rain"]
     * Output: ["eat","oath"]
     */

    class Node{
        HashMap<Character, Node> children = new HashMap<>();
        String word = null;
        public Node(){};
    }

    char[][] _board = null;
    ArrayList<String> res = new ArrayList<String>();
    public List<String> findWords_II(char[][] board, String[] words) {

        //build Trie
        Node root = new Node();
        for(String word : words){

            Node node = root;
            for(char c : word.toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }else{

                    Node newNode = new Node();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            //end of a word
            node.word = word;
        }

        _board = board;


        //backtracking
        for(int r = 0; r < board.length; r++){
            for(int c =0; c < board[0].length; c++){
                if(root.children.containsKey(board[r][c])){
                    backtrack(r, c, root);
                }
            }
        }
        return res;
    }

    void backtrack(int row, int col, Node parent){

        char c = _board[row][col];
        Node cur = parent.children.get(c);

        //check if there is any match
        if(cur.word != null){
            if(!res.contains(cur.word))
                res.add(cur.word);
            // cur.word = null;
        }

        _board[row][col] = '#';
        int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= _board.length || newCol < 0 || newCol >= _board[0].length) {
                continue;
            }

            if(cur.children.containsKey(_board[newRow][newCol])){
                backtrack(newRow, newCol, cur);
            }
        }

        _board[row][col] = c;


    }
}
