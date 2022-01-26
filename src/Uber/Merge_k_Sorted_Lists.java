package Uber;

public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        int left =0, right = lists.length-1;

        while(left < right){
            int mid  = (left+right-1)/2;
            System.out.println(mid);

            for(int i = 0; i<= mid; i++){
                lists[i] = merge(lists[i], lists[right-i]);
            }
            right = (left+right)/2;
        }
        return lists[0];
    }


    ListNode merge(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;

        //System.out.println("ss");
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(a != null && b != null){

            if(a.val < b.val){
                cur.next = new ListNode(a.val);
                a = a.next;
            }else{
                cur.next = new ListNode(b.val);
                b = b.next;
            }
            cur = cur.next;
        }

        if(a != null)
            cur.next = a;

        if(b != null)
            cur.next = b;

        return head.next;
    }

    class ListNode{
        ListNode next;
        int val;

        public ListNode(int v){

        }
    }
}
