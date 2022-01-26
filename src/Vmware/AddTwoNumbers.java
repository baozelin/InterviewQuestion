package Vmware;

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        if(l1 == null && l2 == null){
            return head;
        }

        int sum = 0, carry = 0;
        ListNode cur = head;

        //both not eempty
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while(l1 != null){
            sum = l1.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }

        while(l2 != null){
            sum = l2.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }

        if(carry != 0){
            cur.next = new ListNode(1);
        }

        return head.next;
    }


}
