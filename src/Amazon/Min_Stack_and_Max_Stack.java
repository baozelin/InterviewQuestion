package Amazon;

public class Min_Stack_and_Max_Stack {

    // min stack   --using two stack
    //  create stack with O(1) push, pop and min.
    /**
     class MinStack {

     private Stack<Integer> stack = new Stack<>();
     private Stack<Integer> minStack = new Stack<>();


     public MinStack() { }


     public void push(int x) {
     stack.push(x);
     if (minStack.isEmpty() || x <= minStack.peek()) {
     minStack.push(x);
     }
     }


     public void pop() {
     if (stack.peek().equals(minStack.peek())) {
     minStack.pop();
     }
     stack.pop();
     }


     public int top() {
     return stack.peek();
     }


     public int getMin() {
     return minStack.peek();
     }
     }

     */


    // max stack
    /**
     class MaxStack {

     Stack<Integer> stack;
     Stack<Integer> maxStack;


    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
     */
}
