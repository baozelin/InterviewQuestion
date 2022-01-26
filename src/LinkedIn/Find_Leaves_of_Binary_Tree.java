package LinkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//366
//Given the root of a binary tree, collect a tree's nodes as if you were doing this:
//
//Collect all the leaf nodes.
//Remove all the leaf nodes.
//Repeat until the tree is empty.

//dfs: height
public class Find_Leaves_of_Binary_Tree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        height(root, res);
        return res;
    }

    private int height(TreeNode root, List<List<Integer>> res){
        if(root == null){
            return -1;
        }

        int left = height(root.left, res);
        int right = height(root.right, res);
        int cur = 1+Math.max(left,right);
        if(res.size() == cur){
            res.add(new ArrayList<>());
        }
        res.get(cur).add(root.val);
        return cur;
    }


    /**
     *
     * way 2
     */
    List<int[]> list = new ArrayList();
    public List<List<Integer>> findLeaves2(TreeNode root) {
        int he= getHeight(root);
        //System.out.println(he);

        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        int n = list.size(), h =0, i = 0;
        List<List<Integer>> ret = new ArrayList<>();


        while(i < n){
            List<Integer> nums = new ArrayList<>();

            while(i < n && list.get(i)[0] == h){
                nums.add(list.get(i)[1]);
                i++;
            }

            ret.add(new ArrayList(nums));
            h++;
        }

        return ret;
    }




    private int getHeight(TreeNode root) {

        // return -1 for null nodes
        if (root == null) return -1;

        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // based on the height of the left and right children, obtain the height of the current (parent) node
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // collect the pair -> (height, val)
        this.list.add(new int[]{currHeight,root.val});

        // return the height of the current node
        return currHeight;
    }



}
