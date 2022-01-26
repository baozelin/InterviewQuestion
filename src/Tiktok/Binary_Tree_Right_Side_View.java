package Tiktok;


import java.util.*;

//199
//
public class
Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){


                TreeNode cur = queue.poll();
                if( i == size-1){
                    res.add(cur.val);
                }

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }

        return res;

    }










    // tiktok:    要求dfs
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideView_dfs(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}
