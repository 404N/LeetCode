package LeetCode.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int len=intervals.length;
        int start=0;
        int end=len;
        for(int i=0;i<len;i++){
            if(intervals[i][1]<newInterval[0]){
                res.add(intervals[i]);
                start++;
            }else{
                int temp=i;
                while(temp<len&&newInterval[1]>=intervals[temp][0]){
                    temp++;
                }
                end=temp;
                break;
            }
        }
        for(int i=start;i<end;i++){
            if(intervals[i][0]<=newInterval[0]){
                newInterval[0]=intervals[i][0];
            }
            if(intervals[i][1]>=newInterval[1]){
                newInterval[1]=intervals[i][1];
            }
        }
        res.add(newInterval);
        for(int i=end;i<len;i++){
            res.add(intervals[i]);
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a={{1,5}};
        int[] b={2,3};
        Num57 num57=new Num57();
        int[][] t=num57.insert(a,b);
        for(int i=0;i<t.length;i++){
            System.out.println(t[i][0]+":"+t[i][1]);
        }
    }
}
