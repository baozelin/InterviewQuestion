package Facebook;

import java.util.Stack;

public class Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {


    //inorder + stack
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Stack<Node> stack = new Stack<>();
        Node head = new Node(0);
        Node prev = head;
        //Node cur = root;

        while(root != null || !stack.isEmpty()){

            //add left
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //build linkedlist
            Node cur = stack.pop();
            prev.right = cur;
            cur.left = prev;
            prev = cur;

            //go right
            root = cur.right;
        }

        //circle head with last
        head.right.left = prev;
        prev.right = head.right;

        return head.right;
    }



    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
