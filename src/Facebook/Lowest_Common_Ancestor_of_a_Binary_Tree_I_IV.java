package Facebook;


import java.util.*;
import java.util.Deque;

//236//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
public class Lowest_Common_Ancestor_of_a_Binary_Tree_I_IV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // divide conqu
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        else
            return null;

    }



    // iteration+ parent node

        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

            // Stack for tree traversal
            Deque<TreeNode> stack = new ArrayDeque<>();

            // HashMap for parent pointers
            Map<TreeNode, TreeNode> parent = new HashMap<>();

            parent.put(root, null);
            stack.push(root);

            // Iterate until we find both the nodes p and q
            while (!parent.containsKey(p) || !parent.containsKey(q)) {

                TreeNode node = stack.pop();

                // While traversing the tree, keep saving the parent pointers.
                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }

            // Ancestors set() for node p.
            Set<TreeNode> ancestors = new HashSet<>();

            // Process all ancestors for node p using parent pointers.
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }

            // The first ancestor of q which appears in
            // p's ancestor set() is their lowest common ancestor.
            while (!ancestors.contains(q))
                q = parent.get(q);
            return q;
        }


    /**
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
     * Output: 2
     * Explanation: The lowest common ancestor of nodes 4 and 7 is node 2.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>(Arrays.asList(nodes));
        return dfs(root, set);
    }

    private TreeNode dfs(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }

        if (set.contains(root)) {
            return root;
        }

        TreeNode left = dfs(root.left, set), right = dfs(root.right, set);
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
