package Vmware;

//124
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
public class Binary_Tree_Maximum_Path_Sum {

    //recursion
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        getmax(root);
        return max;
    }

    int getmax(TreeNode root){

        int lmax =0, rmax =0;
        int value = root.val;

        if(root.left != null) lmax = getmax(root.left);
        if(root.right != null) rmax = getmax(root.right);

        //update max
        if(lmax > 0)  value = value + lmax;
        if(rmax > 0)  value = value + rmax;
        max = Math.max(value, max);


        int curmax = Math.max(root.val, Math.max(lmax+root.val, rmax+root.val));
        return curmax;
    }
}
