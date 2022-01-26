package Facebook;

//928
//Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//Output: 32
//Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
public class Range_Sum_of_BST {

    int ans = 0;
    int count = 0;
    public int rangeSumBST_average(TreeNode root, int low, int high) {
        dfs(root,low, high);
        return ans/count;
    }

    void dfs(TreeNode node, int low, int high){
        if(node != null){
            if(low <= node.val && node.val <= high){
                ans += node.val;
                count++;
            }
            if(low < node.val){
                dfs(node.left, low, high);
            }
            if(node.val < high){
                dfs(node.right, low ,high);
            }
        }
    }
}
