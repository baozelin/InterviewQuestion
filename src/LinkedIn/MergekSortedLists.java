package LinkedIn;


import java.util.Comparator;
import java.util.PriorityQueue;

//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
public class MergekSortedLists {

    //O(Nlogk)
    public ListNode mergeKLists1(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        }
        );

        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }


    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){}


    }


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

}
