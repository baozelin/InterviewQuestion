package Ebay;

import java.util.*;

public class
Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();

        if(root == null)
            return ret;

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int index = 0;

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> list = new ArrayList();

            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            if(index % 2 == 1){
                Collections.reverse(list);

            }

            ret.add(new ArrayList(list));
            index++;
        }
        return ret;
    }
}
