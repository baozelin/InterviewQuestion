package LinkedIn;

import java.util.*;

public class Max_stack_dll {

    //O(logN)

    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList dll;

    public Max_stack_dll() {
        map = new TreeMap();
        dll = new DoubleLinkedList();
    }

    public void push(int x) {

        Node  node = dll.add(x);
        if(!map.containsKey(x))
            map.put(x, new ArrayList<>());

        map.get(x).add(node);

    }

    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size()-1);
        if(list.isEmpty()) map.remove(val);
        return val;
    }

    public int top() {
        return dll.peek();
    }

    //O(1)
    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size()-1);
        dll.remove(node);
        if(list.isEmpty()){
            map.remove(max);
        }
        return max;
    }

}
class DoubleLinkedList {
    Node head, tail;

    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }


    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = tail.prev.next;

        return x;
    }


    public Node remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public int pop() {
        return remove(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }





}

class Node {
    int val;
    Node prev, next;
    public Node(int v) {val = v;}
}


