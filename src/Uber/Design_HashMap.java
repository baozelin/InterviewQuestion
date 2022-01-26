package Uber;

public class Design_HashMap {
    private ListNode[] map = null;

    public Design_HashMap() {
        map = new ListNode[100000];
    }

    public void put(int key, int value) {
        int hashValue = key % 100000;
        ListNode entry = new ListNode(key, value);
        if(map[hashValue]==null)
            map[hashValue]=entry;
        else{
            ListNode collision = map[hashValue];
            while(collision.next!=null && collision.key != key){
                collision=collision.next;
            }
            if(collision.key == key) collision.value = value;
            else
                collision.next=entry;
        }
    }

    public int get(int key) {
        int hashValue = key % 100000;
        ListNode present = map[hashValue];

        while(present != null && present.key!=key) present=present.next;

        if(present == null) return -1;
        return present.value;
    }

    public void remove(int key) {
        int hashValue =  key % 100000;
        ListNode present = map[hashValue];
        ListNode previous = null;
        // System.out.println(previous+"reached"+present);

        while(present != null && present.key!=key) {
            previous=present;
            present=present.next;
        }

        if(previous == null &&  present != null)
            map[hashValue] = null;
        else if(previous != null &&  present != null)
            previous.next = present.next;
        else if(previous != null &&  present == null)
            previous.next = present;

    }

    class ListNode{
        int key, value;
        ListNode next=null;

        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
