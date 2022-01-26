package other;


//Input: root = [1,2,3,4,5,6]
//Output: true

import java.util.LinkedList;
import java.util.Queue;

//Input: root = [1,2,3,4,5,null,7]
//Output: false
public class CheckCompletenessofaBinaryTree {


    public boolean isCompleteTree(TreeNode root) {

        //bfs
        Queue<TreeNode> q = new LinkedList();
        //Queue<TreeNode> list = new LinkedList();
        q.offer(root);
        //list.offer(root);

        while(q.peek() != null){

            TreeNode node = q.poll();

            q.offer(node.left);
            //list.offer(node.left);
            q.offer(node.right);
            //list.offer(node.right);



        }

        //System.out.println(list.size());

        while(!q.isEmpty() && q.peek() == null){
            q.poll();
        }

        return q.isEmpty();
    }


}
