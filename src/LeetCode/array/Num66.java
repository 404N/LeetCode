package LeetCode.array;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Num66 {
    public int[] plusOne(int[] digits) {
        boolean isAdd=true;
        for(int i=digits.length-1;i>=0;i--){
            if(isAdd){
                if(digits[i]+1>=10){
                    isAdd=true;
                    digits[i]=(digits[i]+1)%10;
                }else{
                    digits[i]=digits[i]+1;
                    isAdd=false;
                }
            }else{
                break;
            }
        }
        if(isAdd){
            int[] digitsTemp=new int[digits.length+1];
            digitsTemp[0]=1;
            for(int i=1;i<digitsTemp.length;i++){
                digitsTemp[i]=digits[i-1];
            }
            return digitsTemp;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Num66().plusOne(new int[]{9, 9, 9})));
    }
}
