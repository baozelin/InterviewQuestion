package Facebook;


import java.util.*;

//109. Convert Sorted List to Binary Search Tree
public class Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null) return null;

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;

        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        return toBST(list, 0, list.size()-1);
    }

    TreeNode toBST(List<Integer> list, int start, int end){

        if(start <= end){
            int mid = (start + end)/2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = toBST(list, start, mid-1);
            node.right = toBST(list, mid+1, end);
            return node;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
