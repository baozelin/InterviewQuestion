package Codesignal;

import java.util.LinkedList;
import java.util.Queue;

public class BTLevelorderIterator {

    TreeNode root;
    Queue<TreeNode> queue;

    public BTLevelorderIterator() {
        queue = new LinkedList<>();
    }

    public boolean hasNext()
    {
        return !queue.isEmpty();
    }

    public Object next()
    {
        TreeNode current = (TreeNode)queue.poll();
        Object result = current.val;
        if (current.left != null)
            queue.offer(current.left);
        if (current.right != null)
            queue.offer(current.right);
        return result;
    }
}
