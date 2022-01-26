package Google;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Input: root = [1,null,2,3]
//Output: [1,3,2]
public class BinaryTreeInorderTraversal {

    //Time complexity : O(n).
    // The time complexity is O(n) because the recursive function is T(n) = 2 T(n/2)+1.
    //Space complexity : The worst case space required is O(n),
    // and in the average case it's O(log n) where nn is number of nodes.
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        help(root);
        return list;
    }

    public void help(TreeNode root){
        if(root.left != null) help(root.left);
        list.add(root.val);

        if(root.right != null) help(root.right);
    }



    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }


    //Time complexity : O(n).
    //Space complexity : O(n).
    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;

    }
}



