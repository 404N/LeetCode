package LeetCode.sequence;

import java.util.Arrays;

public class Num973 {
    public int[][] kClosest(int[][] points, int k) {
        int[] distinct = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distinct[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
        }
        points=quickSort(points,distinct,0,distinct.length-1,k);
        int[][] res= new int[k][2];
        for(int i=0;i<k;i++){
            res[i]=points[i];
        }
        return res;
    }

    private int[][] quickSort(int[][] points, int[] distinct, int start, int end, int k) {
        int key=distinct[start];
        int i=start,j=end;
        while(i<j){
            while(i<j&&distinct[i]<key){
                i++;
            }
            while(i<j&&distinct[j]>key){
                j--;
            }
            if(distinct[i]==distinct[j]&&i<j){
                i++;
            }else{
                int temp=distinct[i];
                distinct[i]=distinct[j];
                distinct[j]=temp;
                int tempX=points[i][0];
                int tempY=points[i][1];
                points[i][0]=points[j][0];
                points[i][1]=points[j][1];
                points[j][0]=tempX;
                points[j][1]=tempY;
            }
        }
        System.out.println(i+":"+j);
        if(i==j&&i==k){
            return points;
        }
        if(i-1>start&&start<=k&&i-1>=k){
            points=quickSort(points, distinct, start, i-1, k);
        }
        if(j+1<end&&end>=k&&j+1<=k){
            points=quickSort(points, distinct, j+1, end, k);
        }
        return points;
    }


    public static void main(String[] args) {
        Num973 num973=new Num973();
        int[][] p={{3,3},{5,-1},{-2,4},{1,1},{1,-1},{3,2}};
        System.out.println(Arrays.deepToString(num973.kClosest(p, 2)));
    }
}
