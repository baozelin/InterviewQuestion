package Facebook;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//515
//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
public class Find_Largest_Value_in_Each_Tree_Row {

    // bfs
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);

                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ret.add(max);
        }

        return ret;
    }
}
