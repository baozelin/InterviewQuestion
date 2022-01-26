package Facebook;


import java.util.LinkedList;
import java.util.Queue;

//117
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
// be set to NULL.
public class Populating_Next_Right_Pointers_in_Each_Node_II {

    //bfs
    // 每层，poll 出后 指向 queue.peek()
    public Node connect(Node root) {
        if(root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){

            //level
            int size = queue.size();
            for(int i = 0; i < size; i++){

                Node node = queue.poll();

                //build right pointer
                if(i < size -1){
                    node.next = queue.peek();
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    class Node{
        Node left;
        Node right;
        Node next;
    }
}
