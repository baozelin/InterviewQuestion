package wepay;


import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 226
public class Invert_Binary_Tree {


    //divide-conquar bottom-to-top
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode cur = new TreeNode(root.val);
        cur.left = right;
        cur.right = left;

        return cur;
    }


    //bfs top-to-bottom
    public TreeNode invertTree_bfs(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if(cur.left != null){
                queue.offer(cur.left);
            }

            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
