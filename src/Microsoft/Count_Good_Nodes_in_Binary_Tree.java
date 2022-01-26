package Microsoft;


//1448
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.


public class Count_Good_Nodes_in_Binary_Tree {

    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }


    void dfs(TreeNode node, int max){
        if(max <= node.val){
            res++;
        }

        if(node.right != null){
            dfs(node.right, Math.max(max, node.val));
        }

        if(node.left != null){
            dfs(node.left, Math.max(max, node.val));
        }
    }
}
