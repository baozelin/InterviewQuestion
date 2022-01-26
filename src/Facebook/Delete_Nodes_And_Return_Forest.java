package Facebook;

import java.util.*;



//1110:
//Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
//Output: [[1,2,null,4],[6],[7]]
public class Delete_Nodes_And_Return_Forest {


    //bfs
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        //fill set
        for(int i: to_delete){
            set.add(i);
        }

        if(root != null){
            res.add(root);
            queue.offer(root);
        }


        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            //need to delete: add sub tree to res
            if(set.contains(cur.val)){

                //if it in res, remove it
                res.remove(cur);
                //add sub tree
                if(cur.left != null) res.add(cur.left);
                if(cur.right != null) res.add(cur.right);
            }


            //add children to queue
            if(cur.left != null){
                queue.offer(cur.left);

                // delete node from tree
                if(set.contains(cur.left.val)) cur.left = null;

            }

            if(cur.right != null){
                queue.offer(cur.right);

                // delete node from tree
                if(set.contains(cur.right.val)) cur.right = null;

            }


        }
        return res;
    }
}
