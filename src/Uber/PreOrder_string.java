package Uber;


//
//第一轮，给一个二叉树，然后转换成PreOrder出带括号的string。比如(A(B)(C))。B和C是A的孩子
public class PreOrder_string {

    public String preorder(TreeNode root){

        if(root.left == null && root.right == null) return "(" + root.val+")";

        String right = "", left = "";
        if(root.right != null) right = preorder(root.right);
        if(root.left != null) left = preorder(root.left);

        String cur = "(" + root.val + left + right + ")";
        return cur;
    }


    public static void main(String[] args){
        PreOrder_string p = new PreOrder_string();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(p.preorder(root));
    }
}
