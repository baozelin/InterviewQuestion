package LinkedIn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_BinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serHelper(root, str);
        return str.toString();
    }

    void serHelper(TreeNode root, StringBuilder str){

        if(root == null){
            str.append("null,");

        }else{

            str.append(root.val + ",");
            serHelper(root.left, str);
            serHelper(root.right, str);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList();
        q.addAll(Arrays.asList(data.split(",")));
        return desHelper(q);
    }

    TreeNode desHelper(Queue<String> q){
        String str = q.poll();

        if(str.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = desHelper(q);
        root.right = desHelper(q);

        return root;
    }
}
