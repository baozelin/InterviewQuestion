package Facebook;

import java.util.HashSet;


//1650
public class Lowest_Common_Ancestor_of_a_Binary_Tree_III {
    // hashset to store parent node
    //space O(n)
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set = new HashSet<>();
        set.add(p);
        Node cur = p;

        while(cur.parent != null){

            cur = cur.parent;
            set.add(cur);
        }

        cur = q;
        while(!set.contains(cur)){
            cur = cur.parent;
        }

        return cur;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };


    /**
     *  space O(1)
     *
     */
    //先求一下两个节点离树根的距离，然后让距离远的那个向上走若干步使得两个节点离树根距离相等，
    // 接着两个节点都向上齐头并进，直到相遇，
    // 相遇点就是LCA
    public Node lowestCommonAncestor2(Node p, Node q) {
        int h1 = getHeight(p);
        int h2 = getHeight(q);


        if(h1 > h2){
            int i = 0;
            while(i < h1-h2){
                p = p.parent;
                i++;
            }
        }else{
            int i = 0;

            while(i < h2 - h1){
                q = q.parent;
                i++;
            }
        }

        while (p != q && p != null && q != null) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }


    int getHeight(Node node){
        int h = 0;
        while(node != null){
            h++;
            node = node.parent;
        }
        return h;
    }
}
