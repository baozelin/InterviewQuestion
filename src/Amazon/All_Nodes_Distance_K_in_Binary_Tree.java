package Amazon;


import java.util.*;

//863
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
public class All_Nodes_Distance_K_in_Binary_Tree {

    //use dfs to find parent, and then use bfs
    Map<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        parents = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                if(dist == k){
                    List<Integer> res = new ArrayList<>();
                    if(!q.isEmpty()){
                        for(TreeNode n : q){
                            res.add(n.val);
                        }
                    }
                    return res;
                }
                TreeNode node = q.poll();

                //go left
                if(node.left != null && !seen.contains(node.left)){
                    seen.add(node.left);
                    q.offer(node.left);
                }
                //go right
                if(node.right != null && !seen.contains(node.right)){
                    seen.add(node.right);
                    q.offer(node.right);
                }
                //go up
                TreeNode parent = parents.get(node);
                if(parent != null && !seen.contains(parent)){
                    seen.add(parent);
                    q.offer(parent);
                }
            }
            dist++;
        }
        return new ArrayList<Integer>();
    }


    void dfs(TreeNode cur, TreeNode parent){
        if(cur != null){
            parents.put(cur, parent);
            dfs(cur.left, cur);
            dfs(cur.right, cur);
        }
    }
}
