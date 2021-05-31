package LeetCode.stack;

import java.util.Stack;

public class Num84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = 0;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right=new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len-1; i >=0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        for(int i=0;i<len;i++){
            res=Math.max(res,(right[i]-left[i]-1)*heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Num84 num84 = new Num84();
        int[] height = {2,1,5,6,2,3};
        System.out.println(num84.largestRectangleArea(height));
    }
}

/*
    2   1   5   6   2   3

    2   2   5   10  6   8
 */