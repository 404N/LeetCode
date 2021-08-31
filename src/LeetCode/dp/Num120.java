package LeetCode.dp;

import java.util.ArrayList;
import java.util.List;

public class Num120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                }else{
                    if(triangle.get(i - 1).get(j) < triangle.get(i - 1).get(j - 1)){
                        triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                    }else{
                        triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                    }
                }
            }
        }
        int min=triangle.get(len-1).get(0);
        for(int i=0;i<triangle.get(len-1).size();i++){
            if(min>triangle.get(len-1).get(i)){
                min=triangle.get(len-1).get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Num120 num120=new Num120();
        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4=new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> res=new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        System.out.println(num120.minimumTotal(res));
    }
}
