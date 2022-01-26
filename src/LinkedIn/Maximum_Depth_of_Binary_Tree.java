package LinkedIn;

public class Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        else if(root.left == null && root.right == null) return 1;
        else if(root.left == null) return maxDepth(root.right) + 1;
        else if(root.right == null) return maxDepth(root.left) + 1;

        else{
            return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
        }

    }
}
