package Google;

import LinkedIn.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        Queue<Node> queue = new LinkedList();
        TreeMap<Integer, List> map = new TreeMap();

        if(root != null)
            queue.offer(new Node(root,0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(!map.containsKey(cur.v)){
                map.put(cur.v, new ArrayList());
            }
            map.get(cur.v).add(cur.node.val);

            if(cur.node.left != null){
                queue.offer(new Node(cur.node.left, cur.v-1));
            }
            if(cur.node.right != null){
                queue.offer(new Node(cur.node.right, cur.v+1));
            }
        }

        for(int key: map.keySet()){
            List<Integer> tmp = map.get(key);
            list.add(new ArrayList(tmp));
        }

        return list;
    }


    class Node{

        TreeNode node;
        int v;

        public Node(TreeNode n, int v){
            this.node = n;
            this.v = v;
        }
    }


}
