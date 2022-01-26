package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder();
        serihelp(root, sb);
        return sb.toString();
    }

    void serihelp(TreeNode node, StringBuilder sb){
        if(node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val + ",");
        serihelp(node.left, sb);
        serihelp(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList();
        q.addAll(Arrays.asList(data.split(",")));
        return dehelp(q);
    }

    TreeNode dehelp(Queue<String> q){

        String str = q.poll();
        if(str.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left  = dehelp(q);
        root.right = dehelp(q);

        return root;
    }


}
