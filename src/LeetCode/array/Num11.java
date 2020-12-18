package LeetCode.array;

public class Num11 {
    static public int maxArea(int[] height) {
        int max=0;
        int n=height.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int area=Math.min(height[i],height[j])*(j-i);
                if(max<area){
                    max=area;
                }
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int n=height.length;
        int x=n-1;
        int y=0;
        int max=(n-1)*Math.min(height[n-1],height[0]);
        while(y<x){
            if(height[x]>height[y]){
                y++;
            }else{
                x--;
            }
            int area=Math.min(height[x],height[y])*(x-y);
            if(max<area){
                max=area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
