package Facebook;


import java.util.*;

//102 Binary Tree Level Order Traversal
public class Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList();

        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList();

        q.offer(root);

        while(!q.isEmpty()){


            int size = q.size();
            List<Integer> level = new ArrayList();

            for(int i = 0; i < size; i++){

                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }

            ret.add(new ArrayList(level));
        }

        return ret;

    }
}
