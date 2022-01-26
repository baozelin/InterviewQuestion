package CaptialOne;

public class Binary_Tree_Pruning {


    //Time Complexity: O(N), where NN is the number of nodes in the tree. We process each node once.
    //Space Complexity: O(N), the recursion call stack can be as large as the height HH of the tree.
    // In the worst case scenario, H=NH=N, when the tree is skewed.
    public TreeNode pruneTree(TreeNode root) {
        return check(root) ? root : null;
    }


    boolean check(TreeNode node){
        if(node == null) return false;

        boolean left = check(node.left);
        boolean right = check(node.right);

        //If the left subtree does not contain a 1, prune the subtree.
        if(!left) node.left = null;

        //// If the right subtree does not contain a 1, prune the subtree.
        if(!right) node.right =null;

        return node.val == 1 || left || right;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
