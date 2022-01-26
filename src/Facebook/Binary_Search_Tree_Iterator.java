package Facebook;

import java.util.Stack;

public class Binary_Search_Tree_Iterator {

    //stack + inorder
    Stack<TreeNode> stack;

    public Binary_Search_Tree_Iterator(TreeNode root) {
        this.stack = new Stack<>();
        inorder(root);
    }

    void inorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = this.stack.pop();
        if (node.right != null) {
            inorder(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
