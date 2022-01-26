package CaptialOne;

public class Odd_Even_Linked_List {

    public ListNode oddEvenList2(ListNode head) {
        int i = 0;

        ListNode evenhead = new ListNode(0);
        ListNode oddhead = new ListNode(0);

        ListNode evencur = evenhead;
        ListNode oddcur = oddhead;

        while(head != null){
            if(i % 2 == 0){
                evencur.next = new ListNode(head.val);
                evencur = evencur.next;
            }else{
                oddcur.next = new ListNode(head.val);
                oddcur = oddcur.next;
            }
            head = head.next;
            i++;
        }

        evencur.next = oddhead.next;
        return evenhead.next;
    }

    // index : 1, 2, 3, 4, 5
    //modify original list
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;

        ListNode odd =head;
        ListNode even = odd.next;
        ListNode evenhead = even;

        while(odd.next != null && odd.next.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }


    class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
