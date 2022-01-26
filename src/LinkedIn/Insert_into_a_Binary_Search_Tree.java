package LinkedIn;


//701 Insert into a Binary Search Tree

public class Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }

        if(val <= root.val){
            root.left = insertIntoBST(root.left, val);
        }

        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
