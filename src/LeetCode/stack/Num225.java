package LeetCode.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num225 {
    public Num225() {

    }
    Queue<Integer> list=new LinkedList<>();
    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
        int n=list.size();
        for(int i=0;i<n-1;i++){
            list.add(list.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.poll();
    }

    /** Get the top element. */
    public int top() {
        return list.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size()==0;
    }
}

/*
 1  2  3  4  5  6  7
 1
 2  1
 3  2  1

 */
