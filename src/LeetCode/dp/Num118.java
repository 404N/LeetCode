package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class Num118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Num118 num118 = new Num118();
        System.out.println(num118.generate(8));
    }
}
