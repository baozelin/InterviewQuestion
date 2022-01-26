package Google;

import java.util.LinkedList;
import java.util.Queue;

public class FindDistanceinaBinaryTree {

        public int findDistance(TreeNode root, int p, int q) {
            if (root == null || p == q) {
                return 0;
            }

            TreeNode ancestor = findLCA(root, p, q);
            int a = bfs(ancestor, p);
            int b = bfs(ancestor, q);
            return a + b;
        }

        private int bfs(TreeNode node, int v) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            int level = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.val == v) {
                        return level;
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                level++;
            }
            return level;
        }

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
