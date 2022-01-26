package Amazon;

public class Delete_Node_in_a_BST {

    //logn
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;

        //go right
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }

        //go left
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }

        //find key
        else{

            //one child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            //get min of right subtreee
            TreeNode cur = root.right;
            while(cur.left != null){
                cur = cur.left;
            }

            root.val = cur.val;
            root.right = deleteNode(root.right, cur.val);
        }

        return root;
    }
}
