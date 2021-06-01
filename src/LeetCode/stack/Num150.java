package LeetCode.stack;

import java.util.Stack;

public class Num150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int len=tokens.length;
        for(int i=0;i<len;i++){
            if("+".equals(tokens[i])){
                Integer a=stack.pop();
                Integer b=stack.pop();
                stack.push(a+b);
            }else if("-".equals(tokens[i])){
                Integer a=stack.pop();
                Integer b=stack.pop();
                stack.push(b-a);
            }else if("*".equals(tokens[i])){
                Integer a=stack.pop();
                Integer b=stack.pop();
                stack.push(a*b);
            }else if("/".equals(tokens[i])){
                Integer a=stack.pop();
                Integer b=stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Num150 num150=new Num150();
        String[] s={"2","1","-","3","*"};
        System.out.println(num150.evalRPN(s));
    }
}
