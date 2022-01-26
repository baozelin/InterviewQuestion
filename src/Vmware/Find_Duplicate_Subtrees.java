package Vmware;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//652
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
public class Find_Duplicate_Subtrees {
    //preorder
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();

        preorder(root, map, res);
        return res;
    }

    String preorder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res){

        if(root == null) return "#";

        String key = root.val + "," + preorder(root.left, map, res) + preorder(root.right, map, res);

        // add res
        if(map.containsKey(key) && map.get(key) == 1){
            res.add(root);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);


        return key;
    }
}
