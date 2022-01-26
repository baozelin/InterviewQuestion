package Amazon;


import java.util.*;

//211
//trie
public class Design_Add_and_Search_Words_Data_Structure {


    //trie

    private Node root = new Node();
    public Design_Add_and_Search_Words_Data_Structure() {

    }

    public void addWord(String word) {
        Node cur = root;

        for(char c: word.toCharArray()){
            if(!cur.child.containsKey(c)){
                cur.child.put(c, new Node());
            }
            cur = cur.child.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    boolean dfs(Node root, String word, int index){

        //base case
        if(root == null) return false;
        if(index == word.length()){
            return root.isEnd;
        }

        char c  = word.charAt(index);
        if(c != '.'){
            if(root.child.containsKey(c)){
                return dfs(root.child.get(c), word, index+1);
            }


        }else{
            for(char key : root.child.keySet()){
                if(dfs(root.child.get(key), word, index+1)) return true;
            }

        }
        return false;


    }


    class Node{
        boolean isEnd;
        HashMap<Character, Node> child;
        //public Node[] next = new Node[26];

        public Node() {
            this.isEnd = false;
            child = new HashMap();
        }
    }
}
