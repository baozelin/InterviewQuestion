package LinkedIn;

import java.util.*;

public class Max_Stack {

     Stack<Integer> stack;
     Stack<Integer> maxStack;

     public Max_Stack() {
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
