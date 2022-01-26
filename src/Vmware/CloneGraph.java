package Vmware;


import java.util.*;

//Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//Output: [[2,4],[1,3],[2,4],[1,3]]
public class CloneGraph {


    //dfs way
    // due to undirect graph, it will have a cycle, need a hashmap

    //O(N+M)
    public Node cloneGraph_dfs(Node node) {
        return deep(node, new HashMap<>());
    }

    Node deep(Node node, Map<Integer, Node> map){
        if(node == null) return null;


        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node copy = new Node(node.val);
        map.put(node.val, copy);

        for(Node n: node.neighbors){

            copy.neighbors.add(deep(n, map));

        }
        return copy;


    }



    //bfs way   O(N+M)
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




        class Node{
            int val;
            public List<Node> neighbors;
            public Node(int val){

            }
        }
}
