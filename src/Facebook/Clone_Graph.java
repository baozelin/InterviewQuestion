package Facebook;


//133. Clone Graph

import java.util.*;

public class Clone_Graph {


    //  bfs + hashmap<old node, new node>
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        HashMap<Node,Node> map = new HashMap();
        Queue<Node> q = new LinkedList();
        q.offer(node);
        map.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node n : cur.neighbors){
                if(!map.containsKey(n)){
                    q.offer(n);
                    map.put(n, new Node(n.val));
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);

    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
