package Facebook;


import java.util.*;

//1530
//Input: root = [1,2,3,null,4], distance = 3
//Output: 1
//Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
public class Number_of_Good_Leaf_Nodes_Pairs {


    //graph + dfs
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    Set<TreeNode> leafs = new HashSet<>();
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        build(root, null);

        for(TreeNode leaf: leafs){
            dfs(leaf, distance, new HashSet<>());
        }

        return count/2;
    }

    void dfs(TreeNode leaf, int d, Set<TreeNode> visited){
        if(d <= 0) return;
        visited.add(leaf);

        for(TreeNode next: graph.get(leaf)){

            if(visited.contains(next)) continue;

            if(leafs.contains(next)) count++;

            dfs(next, d-1, visited);
        }
    }


    //build graph
    void build(TreeNode node, TreeNode parent){
        if(node == null) return;

        build(node.left, node);
        build(node.right, node);

        graph.putIfAbsent(node,new ArrayList<>());
        if(parent != null){
            graph.putIfAbsent(parent,new ArrayList<>());
            graph.get(parent).add(node);
            graph.get(node).add(parent);
        }

        //leaf
        if(node.left == null && node.right == null)
            leafs.add(node);
    }

}
