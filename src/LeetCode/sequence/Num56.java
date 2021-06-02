package LeetCode.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for(int i=0;i<intervals.length;i++){
            if(i==intervals.length-1){
                res.add(intervals[i]);
                continue;
            }
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0]=intervals[i][0];
                if(intervals[i][1]>intervals[i+1][1]){
                    intervals[i+1][1]=intervals[i][1];
                }
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a={{4,5},{1,4},{3,3},{0,1},{2,2}};
        Num56 num56=new Num56();
        int[][] t=num56.merge(a);
        for(int i=0;i<t.length;i++){
            System.out.println(t[i][0]+":"+t[i][1]);
        }
    }
}

/*
0  2  1  4  3  5
 */