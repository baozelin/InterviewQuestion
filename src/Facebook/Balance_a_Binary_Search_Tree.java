package Facebook;


import java.util.*;

//1382
public class Balance_a_Binary_Search_Tree {


    List<TreeNode> list = new ArrayList<>();
    // inorder  + build bst
    public TreeNode balanceBST(TreeNode root) {

        inorder(root);
        return build(0, list.size()-1);
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    TreeNode build(int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode cur = list.get(mid);
        cur.left = build(start, mid-1);
        cur.right = build(mid+1, end);
        return cur;
    }
}
