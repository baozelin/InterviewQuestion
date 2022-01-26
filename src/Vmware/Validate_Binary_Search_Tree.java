package Vmware;

import java.util.Stack;

public class Validate_Binary_Search_Tree {


    int pre = -99;
    public boolean isValidBST(TreeNode root){
        return inorder(root);
    }


    boolean inorder(TreeNode root){

        if(root == null) return true;
        if(!inorder(root.left)) return false;

        if(pre != -99 && pre >= root.val){
            return false;
        }
        pre = root.val;
        return inorder(root.right);

    }

    //inorder stack
    public boolean isValidBST_stack(TreeNode root){
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(root!= null && !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(pre != null && pre.val >= root.val) return false;

            pre = root;
            root = root.right;
        }
        return true;
    }
}
