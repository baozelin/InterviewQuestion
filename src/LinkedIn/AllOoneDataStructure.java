package LinkedIn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

//https://blog.csdn.net/qq_20304723/article/details/104444760

    public class AllOoneDataStructure {
        //Node结点用于存放相同count值的多个key，通过LinkedHashSet进行o(1)查找
        class Node{
            int count;
            HashSet<String> set;
            Node pre;
            Node next;
            public Node(int c){
                count = c;
                set = new HashSet<>();
            }
        }

        //DoubleLinkedList是一个存储Node结点的排序双向链表，Node按count升序排序
        class DoubleLinkedList{
            Node head;
            Node tail;

            public DoubleLinkedList(){
                head = new Node(-1);
                tail = new Node(-1);
                head.next = tail;
                tail.pre = head;
            }

            public void remove(Node node){
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            public void insert(Node left, Node right){
                right.next = left.next;
                right.pre = left;
                left.next = right;
                right.next.pre = right;
            }
        }

        class AllOne {

            //依靠HashMap可以获得每一个key对应的Node结点
            HashMap<String, Node> map;
            DoubleLinkedList list;

            /** Initialize your data structure here. */
            public AllOne() {
                map = new HashMap<>();
                list = new DoubleLinkedList();
            }

            //插入和递增操作：
            //如果当前key不存在，在队列中新建一个count值对应的node结点并将key插入。
            //如果当前key存在，将其从当前count的原结点中转移至count+1的新结点（新结点不存在则新建，原结点如果key集合为空则移出队列）。由于插入和递增操作仅一个单位，因此原结点和新结点必相邻。
            /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
            public void inc(String key) {
                int count = 1;
                Node left = list.head;

                if(map.containsKey(key)){
                    Node node = map.get(key);
                    node.set.remove(key);
                    count = node.count + 1;
                    if(node.set.isEmpty()){
                        left = node.pre;
                        list.remove(node);
                    }else {
                        left = node;
                    }
                }

                Node right = left.next;
                if(right.count != count){
                    right = new Node(count);
                    list.insert(left, right);
                }
                map.put(key, right);
                right.set.add(key);
            }

            //删除和递减操作：
            //如果key值为1，直接将其从count=1的node的集合与哈希表中移除（原结点如果key集合为空则移出队列）
            //如果key不为1，将key转移至count-1的新结点中（新结点不存在则新建）
            /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
            public void dec(String key) {
                if(!map.containsKey(key)){
                    return;
                }

                Node node = map.get(key);
                node.set.remove(key);
                if(node.set.isEmpty()){
                    list.remove(node);
                }
                map.remove(key);

                if(node.count != 1){
                    Node left = node.pre;
                    if(node.pre.count != node.count - 1){
                        left = new Node(node.count - 1);
                        list.insert(node.pre, left);
                    }
                    map.put(key, left);
                    left.set.add(key);
                }
            }

            //从队尾的Node中获取一个最大值
            /** Returns one of the keys with maximal value. */
            public String getMaxKey() {
                HashSet<String> set = list.tail.pre.set;
                return set.isEmpty() ? "" : set.iterator().next();
            }

            //从队首的Node中获取一个最小值
            /** Returns one of the keys with Minimal value. */
            public String getMinKey() {
                HashSet<String> set = list.head.next.set;
                return set.isEmpty() ? "" : set.iterator().next();
            }
        }
}
