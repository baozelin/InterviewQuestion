package LinkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Closest_Binary_Search_Tree_Value_II {

    /**
     *  inorder + sort(abs(i - target))
     *  Time complexity: O(NlogN). O(N) to build inorder traversal and then \mathcal{O}(N \log N)O(NlogN) to sort it.
     *
     * Space complexity: O(N) to store list nums of NN elements.
     */
    List<Integer> list = new ArrayList();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorder(root);
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1:1;
            }
        });

        return list.subList(0, k);
    }

    //inorder
    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
