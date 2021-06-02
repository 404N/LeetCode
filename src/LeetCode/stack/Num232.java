package LeetCode.stack;

import java.util.Stack;

public class Num232 {
    public Num232() {

    }
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack.isEmpty()){
                stack2.push(stack.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack.isEmpty()){
                stack2.push(stack.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty()&&stack.isEmpty();
    }

    public static void main(String[] args) {
        Num232 num232=new Num232();
        num232.push(1);
        num232.push(2);
        System.out.println(num232.pop());
        System.out.println(num232.pop());
    }
}

/*
 1  2  3  4  5  6  7
 1
 2  1
 3  2  1

 */
