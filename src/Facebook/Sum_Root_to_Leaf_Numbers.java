package Facebook;

public class Sum_Root_to_Leaf_Numbers {

    //dfs
    int total = 0;
    public int sumNumbers(TreeNode root) {

        if(root == null) return total;
        dfs(root, 0);
        return total;
    }


    void dfs(TreeNode root, int val){

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            total += val * 10 + root.val;
        }

        if(root.left != null){
            dfs(root.left,val * 10 + root.val );
        }
        if(root.right != null){
            dfs(root.right,val * 10 + root.val );
        }
    }
}
