package Vmware;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;




public class VO {

    // LRU + hashmap + double linkedlist

        //
        int size;
        Node head;
        Node end;
        HashMap<Integer, Node> map;

        public VO(int size){
            this.size = size;
            map = new HashMap<>();
        }

        // add new element to cache
        public void put(int key, int val){

            // not full
            if(map.size() < size){
                Node newNode = new Node(key, val);

                // exist before
                if(map.containsKey(key)){
                    Node old = map.get(key);
                    remove(old);
                    setHead(newNode);
                    map.put(key, newNode);
                }
                // no exist
                else{
                    map.put(key, newNode);
                    setHead(newNode);
                }
            }
            //full. 1.
            else{
                Node newNode = new Node(key, val);
                // key exist before
                if(map.containsKey(key)){
                    Node old = map.get(key);
                    remove(old);
                    setHead(newNode);
                    map.put(key, newNode);
                }

                // not exist, add new , remove end
                else{
                    setHead(newNode);
                    int oldkey = end.key;
                    map.remove(oldkey);
                    remove(end);
                    setHead(newNode);
                    map.put(key, newNode);
                }
            }
        }


        // get value from cache if it exist
        public int get(int key){

            // not exist
            if(!map.containsKey(key)){
                return -1;
            }
            // exist
            else{
                Node cur = map.get(key);
                //set it to head
                // remove it
                setHead(cur);
                remove(cur);
                return cur.val;

            }
        }

        private void setHead(Node node){
            node.next = head;
            node.pre = null;


            if(head != null){
                head.pre = node;
            }
            // updata end
            if(end == null){
                end = head;
            }

            // updata head
            head = node;
        }

        //. remove node from linkedlist
        private void remove(Node node){

            // pre
            if(node.pre != null){
                node.pre.next = node.next;
            }
            // null
            else{
                head = node.next;
            }

            // next
            if(node.next != null){
                node.next.pre = node.pre;
            }

            else{
                end = node.pre;
            }
        }








// put 1, a
// put 2, b
// put 3, c
// get 2

//
        // Capacity: 2
        // Ops:
        // [SET 1,2], [SET 2,3], [SET 1,5], [SET 4,5], [SET 6,7], [GET 4], [GET 1]


        public static void main(String[] args) {
            VO cache = new VO(2);
            cache.put(1, 2);
            cache.put(2, 3);
            cache.put(1, 5);
            cache.put(4, 5);
            cache.put(6, 7);

            System.out.println(cache.get(4));
            System.out.println(cache.get(1));

            for(int key: cache.map.keySet()){
                System.out.println(cache.map.get(key).key + "," + cache.map.get(key).val);
            }


            Node cur = cache.head;
            while( cur != null){
                System.out.println(cur.key);
                cur = cur.next;
            }


        }


        // DOuBLIE LINKEDlist
        class Node{
            int val;
            int key;
            Node pre;
            Node next;

            public Node(int key, int value){
                this.key = key;
                this.val = value;
            }

        }

    }


// LRU.   data struction
//. String
//.   cache. 1, 2, 3, 4 , 5.   size is full
//.   behavoir:    3,1 , 2 , 4, 5
//.       2.  6:    6 3, 1, 2, 4


// put 1, a
// put 2, b
// put 3, c
// get 2

//. head.,,    end()
// node{1}<-> node<2> -->.  //. fast in modify
// hashmap<Integer, Node> map;   // fast in search
// Linkedlist<Node>.
//

/**
 cache:
 int size:


 **/


/**
 //.  Node{

 int val;
 Node pre;
 Node next;

 //}

 **/



