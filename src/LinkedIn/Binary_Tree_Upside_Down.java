package LinkedIn;


//156. Binary Tree Upside Down

//Given the root of a binary tree, turn the tree upside down and return the new root.
//
//You can turn a binary tree upside down with the following steps:
//
//The original left child becomes the new root.
//The original root becomes the new right child.
//The original right child becomes the new left child.
public class Binary_Tree_Upside_Down {

    // recursion
    //O(n)
    //O(n)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }

        // newRoot == most left node
        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        //remove old connect
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
