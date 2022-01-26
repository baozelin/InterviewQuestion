package Google;



//第三轮 国人大哥 给一个binary tree和两个node，找到并输出路径，路径用up，left，right表示
//     1
//   /  \
//  2    3
//  2 到 3 的路径时 “up,right”
//这题做过，但是当场脑子瓦特，感谢大哥人帅心善，给了hint
public class upleftright_binarytree {

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
        }

    }
}
