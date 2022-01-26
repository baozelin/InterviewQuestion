package LinkedIn;

import java.util.*;

// traversal + hashset
public class Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }


    boolean find(TreeNode root, int k, Set<Integer> set){


        if(root == null) return false;

        if(set.contains(k - root.val)){
            return true;
        }

        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
