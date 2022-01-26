package CaptialOne;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {

        if(head == null) return null;
        Node h = head;

        //copy node, put it after that node
        while(h != null){
            Node tmp = new Node(h.val);
            Node next = h.next;
            h.next = tmp;
            tmp.next = next;
            h = next;
        }

        // set random
        h = head;
        while(h != null){
            if(h.random != null){
                Node rad = h.random;
                h.next.random = rad.next;
            }
            h = h.next.next;
        }

        //disconnect
        h = head;
        Node newhead = head.next;
        while(h!=null){
            Node copy = h.next;
            h.next = copy.next;
            h = h.next;
            copy.next = h != null ? h.next : null;
        }
        return newhead;
    }

}


    class Node {
      int val;
        Node next, random;
        Node(int x) { this.val = x; }

}
