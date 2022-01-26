package Google;


//Input: root = [1,2,3]
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
public class SumRoottoLeafNumbers {

    int total = 0;
    public int sumNumbers(TreeNode root) {

        if(root == null) return -1;
        dfs(root, 0);
        return total;
    }

    void dfs(TreeNode root, int val){
        if(root == null) return;
        val = val*10 + root.val;

        if(root.left == null && root.right == null){
            total += val;
        }
        if(root.left != null)
            dfs(root.left, val);

        if(root.right != null)
            dfs(root.right, val);

        //val = (val-root.val)/10;
    }
}
