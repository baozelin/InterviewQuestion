package Uber;


import java.util.*;

//208
class Implement_Tire {
    Node head;

    public Implement_Tire() {
        this.head = new Node();
    }

    public void insert(String word) {

        Node cur = head;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.child.containsKey(c)){
                cur.child.put(c, new Node(c));
            }
            cur = cur.child.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        if(head.child.size() == 0) return false;

        Node cur = head;
        for(int i = 0; i < word.length(); i++){

            char c = word.charAt(i);

            if(!cur.child.containsKey(c)){
                return false;
            }

            cur = cur.child.get(c);
        }
        return cur.end == true? true:false;
    }

    public boolean startsWith(String prefix) {
        if(head.child.size() == 0) return false;
        Node cur = head;

        for(int i = 0; i < prefix.length(); i++){

            char c = prefix.charAt(i);
            if(!cur.child.containsKey(c)){
                return false;
            }
            cur = cur.child.get(c);
        }
        return true;
    }

}

class Node{
    boolean end;
    char val;
    HashMap<Character,Node> child = new HashMap<>();

    public Node(char v){
        this.end = false;
        this.val = v;
    }

    public Node(){}
}