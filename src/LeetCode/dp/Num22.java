package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class Num22 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        getAll(new char[2*n],0,0,0,res);
        return res;
    }

    private void getAll(char[] chars, int index, int leftCnt, int rightCnt, List<String> res) {
        if(index==chars.length){
            res.add(String.valueOf(chars));
        }
        if(leftCnt<chars.length/2){
            chars[index]='(';
            getAll(chars,index+1,leftCnt+1,rightCnt,res);
        }
        if(rightCnt<leftCnt){
            chars[index]=')';
            getAll(chars,index+1,leftCnt,rightCnt+1,res);
        }
    }

    public static void main(String[] args) {
        Num22 num22=new Num22();
        System.out.println(num22.generateParenthesis(5));
    }
}
