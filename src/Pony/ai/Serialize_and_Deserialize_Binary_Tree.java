package Pony.ai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//297
public class Serialize_and_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serihelp(root, sb);
        return sb.toString();
    }

    //preorder
    void serihelp(TreeNode node, StringBuilder sb){
        if(node == null){
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

        String cur = q.poll();
        if(cur.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(cur));
        TreeNode left = dehelp(q);
        TreeNode right = dehelp(q);
        node.left = left;
        node.right = right;

        return node;
    }
}
