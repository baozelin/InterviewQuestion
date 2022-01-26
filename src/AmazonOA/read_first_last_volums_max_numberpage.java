package AmazonOA;


// 1-4-3-2
// 7
public class read_first_last_volums_max_numberpage {
    //第一题先用快慢指针分两半，然后把后半段reverse，然后再两个list相加


    static int max(ListNode head){


        if(head == null) return -1;

        // write your code here
        ListNode slow = head, fast = head;
        while(fast != null && fast. next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        //reverse
        mid = reverseList(mid);
        //System.out.print(mid.val);
        //System.out.print(mid.next.val);

        int res = 0;
        while(mid != null && head != null){
            System.out.print(head.val);
            System.out.print(mid.val);

            res = Math.max(mid.val+head.val, res);
            mid = mid.next;
            head = head.next;
        }

        return res;

    }

    static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while(next != null && cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }



    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int v){
            this.val = v;
        }
    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        System.out.println(max(head));
    }

}
