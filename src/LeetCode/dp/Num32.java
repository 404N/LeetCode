package LeetCode.dp;

import java.util.Stack;

public class Num32 {
    public int longestValidParentheses(String s) {
        int len=s.length();
        int max=0;
        int[] mark=new int[len];
        for(int i=1;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    if(i-2>=0){
                        mark[i]=mark[i-2]+2;
                    }else{
                        mark[i]=2;
                    }
                }else if(s.charAt(i-1)==')'&&i-mark[i-1]-1>=0&&s.charAt(i-mark[i-1]-1)=='('){
                    if(i-mark[i-1]-2>=0){
                        mark[i]=mark[i-1]+mark[i-mark[i-1]-2]+2;
                    }else{
                        mark[i]=mark[i-1]+2;
                    }
                }
            }
            if(mark[i]>max){
                max=mark[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s="(()(()))))";
        String s1="(()";
        String s2="))()";
        String s3="()(()";
        String s4="((()))((";
        Num32 num32=new Num32();
        System.out.println(num32.longestValidParentheses(s4));
    }


}
