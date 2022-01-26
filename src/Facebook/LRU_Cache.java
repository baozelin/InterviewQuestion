package Facebook;

import java.util.HashMap;

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null, end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    void remove(Node n){
        //pre
        if(n.pre != null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        //next
        if(n.next != null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
    }


    void setHead(Node n){
        n.next = head;
        n.pre = null;

        //pre
        if(head != null){
            head.pre = n;
        }

        head = n;

        if(end == null){
            end = head;
        }
    }

    // get and move to head
    public int get(int key) {

        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        else{
            return -1;
        }
    }


    //
    public void put(int key, int value) {

        //update
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);

            // add new
        }else{
            Node node = new Node(key, value);
            if(map.size() >= capacity){
                map.remove(end.key); // clear map
                remove(end);
                setHead(node);
            }else{
                setHead(node);

            }

            map.put(key, node);
        }


    }



    class Node{
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}