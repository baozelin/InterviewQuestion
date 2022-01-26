package Ebay;


//92
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
public class Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null) return head;

        ListNode node = new ListNode(0); // set a head
        node.next = head;
        ListNode prev = node;
        ListNode leftn = head;

        while(left > 1){
            prev = leftn;
            leftn = leftn.next;
            left--;
        }

        ListNode rightn = head;

        while(right > 1){
            rightn = rightn.next;
            right--;
        }

        reverse(prev, rightn.next);   //find left-1 and right+1
        return node.next;
    }


    void reverse(ListNode left, ListNode right){
        ListNode prev = left;
        ListNode cur = left.next;
        ListNode next = cur.next;

        while(next != right){

            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }

    }
}
