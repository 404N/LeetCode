package LeetCode.str;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 */
public class Num6 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length()+(2*numRows - 2); j += 2*numRows - 2) {
                if(i==0){
                    if(j<s.length()){
                        temp.append(s.charAt(j));
                    }
                }else if(i==numRows-1){
                    if(j+numRows-1<s.length()){
                        temp.append(s.charAt(j+numRows-1));
                    }
                }else{
                    if(j-i>=0&&j-i<s.length()){
                        temp.append(s.charAt(j-i));
                    }
                    if(j+i<s.length()){
                        temp.append(s.charAt(j+i));
                    }
                }
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Num6().convert("PAYPALISHIRING", 3));
    }

}
