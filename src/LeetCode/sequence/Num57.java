package LeetCode.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
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
}
