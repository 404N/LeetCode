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

    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
