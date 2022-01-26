package Ebay;


//138. Copy List with Random Pointer


// build a new node next to it
// copy connect
//disconnect
public class Copy_List_with_Random_Pointer {


    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode h = head;

        //traversal list, copy node and put it after that node
        while(h != null){
            RandomListNode tmp = new RandomListNode(h.label);
            RandomListNode next = h.next;
            h.next = tmp;
            tmp.next = next;
            h = next;
        }

        //traversal + random
        h = head;
        while(h != null){
            if(h.random != null){
                RandomListNode rad = h.random;
                h.next.random = rad.next;
            }
            h = h.next.next;
        }

        //disconnect list
        h = head;
        RandomListNode newhead = head.next;
        while(h!=null){
            RandomListNode copy = h.next;
            h.next = copy.next;
            h = h.next;
            copy.next = h != null ? h.next : null;

        }
        return newhead;
    }


    class RandomListNode{
        RandomListNode next;
        RandomListNode random;
        int label;
        public RandomListNode(int x){

        }
    }
}

