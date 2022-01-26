package Facebook;


//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
public class Diameter_of_Binary_Tree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return max;
    }

    int help(TreeNode root){
        if(root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);

        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}
