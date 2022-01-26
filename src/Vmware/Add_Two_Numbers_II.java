package Vmware;

import java.util.Stack;

public class Add_Two_Numbers_II {

    // + reverse
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0, carry = 0;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop() + stack2.pop() + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;

        }

        while(!stack1.isEmpty()){
            sum = stack1.pop() + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;
        }
        while(!stack2.isEmpty()){
            sum = stack2.pop() + carry;
            carry = sum /10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;
        }

        if(carry != 0){
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return reverse(head.next);
    }


    ListNode reverse(ListNode head){
        if(head == null) return null;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
