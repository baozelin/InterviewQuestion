package LinkedIn;


//61
//Given the head of a linked list, rotate the list to the right by k places.
public class Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode cur = head;
        int n;

        for(n = 1; cur.next != null; n++){
            cur = cur.next;
        }

        cur.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode newTail = head;
        for(int i = 0; i < n - k % n - 1; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next =null;

        return newHead;
    }

}
