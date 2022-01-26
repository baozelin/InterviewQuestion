package Facebook;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
public class Binary_Tree_Right_Side_View {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if( i == size-1){
                    res.add(cur.val);
                }

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }

        return res;

    }
}
