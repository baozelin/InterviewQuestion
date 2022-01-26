package Facebook;


// find max sum of subtree
public class Max_subtree {

    int max = Integer.MIN_VALUE;
    int findLargestSubtreeSum(TreeNode root)
    {
        if (root == null)
            return 0;
        find(root);

        return max;
    }

    int find(TreeNode root){

        if (root == null) return 0;
        int currSum = root.val + find(root.left) + find(root.right);
        max = Math.max(max, currSum);

        return currSum;
    }

}
