package Expedia;


//143. Reorder List
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
public class Reorder_List {

    //find middle
    // reverse second part
    // merge
    // O(n), O(1)
    public void reorderList(ListNode head) {

        if(head == null) return;

        ListNode slow = head, fast = head;

        //find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second part
        ListNode prev = null, cur = slow, next;
        while(cur != null){
            next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // head, prev
        //merge
        ListNode first = head, second = prev;
        while(second.next != null){
            next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
        }

    }
}
