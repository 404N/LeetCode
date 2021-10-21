package LeetCode.stack;

import java.util.Stack;

public class Num20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n %2== 1) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(getInt(s.charAt(0)));
        for (int i = 1; i < n; i++) {
            if (getInt(s.charAt(i)) > 0) {
                stack.push(getInt(s.charAt(i)));
            } else {
                if (stack.empty()) {
                    return false;
                } else if (stack.peek() + getInt(s.charAt(i)) == 0) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static public Integer getInt(char c) {
        if (c == '(') {
            return 1;
        } else if (c == '[') {
            return 2;
        } else if (c == '{') {
            return 3;
        } else if (c == ')') {
            return -1;
        } else if (c == ']') {
            return -2;
        } else if (c == '}') {
            return -3;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "(])";
        Num20 num20=new Num20();
        System.out.println(num20.isValid(s));
    }
}
