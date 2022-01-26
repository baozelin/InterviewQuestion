package Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_preorder_postorder {

    public List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur  = root;

        while(cur != null || !stack.isEmpty()){

            //add left
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur =cur.right;

        }
        return list;
    }


    public List<Integer> preorder(TreeNode root){
        Stack <TreeNode> stack = new Stack<>();
        List <Integer> list = new ArrayList<>();

        if(root == null) return list;

        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null){
                stack.add(cur.right);
            }

            if(cur.left != null){
                stack.add(cur.left);
            }
        }
        return list;
    }


}
