package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class Num119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i < rowIndex+1; i++) {
            int temp=res.get(0);
            for (int j = 1; j < i; j++) {
                int value=res.get(j);
                res.set(j,res.get(j) + temp);
                temp=value;
            }
            res.add(1);
        }
        return res;
    }
    public static void main(String[] args) {
        Num119 num119 = new Num119();
        System.out.println(num119.getRow(1));
    }
}
