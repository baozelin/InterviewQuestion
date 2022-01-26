package other;

public class CountCompleteTreeNodes {

    public int countNodes1(TreeNode root) {

        if(root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }



    //https://blog.csdn.net/qq_42411921/article/details/111661696
    public int countNodes(TreeNode root) {



        if(root == null) return 0;
        int x = 1, y = 1;
        TreeNode left = root, right = root;

        while(left.left != null){
            x++;
            left = left.left;
        }

        while(right.right != null){
            y++;
            right = right.right;
        }

        if(x == y) return (1<<x)-1;
        return countNodes(root.left) + countNodes(root.right) + 1;





    }
}
