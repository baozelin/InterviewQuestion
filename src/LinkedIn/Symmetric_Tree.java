package LinkedIn;

public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return sym(root.left, root.right);
    }

    boolean sym(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        if(n1.val != n2.val) return false;

        boolean left = sym(n1.left, n2.right);
        boolean right = sym(n1.right, n2.left);

        return left && right;
    }
}
