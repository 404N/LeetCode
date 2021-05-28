package LeetCode.stack;


public class Num42 {
//    public int trap(int[] height) {
//        if(height.length<=1){
//            return 0;
//        }
//        int n=height.length;
//        int water=0;
//        int start=0;
//        int end=0;
//        int temp=height[0];
//        boolean lock=true;
//        int status=0;
//        int sCount=0;
//        //0未开始状态，1下坡状态，2上坡状态
//        for(int i=1;i<n;i++){
//            if(lock){
//                if(height[i]<temp){
//                    start=i-1;
//                    status=1;
//                    lock=false;
//                }
//            }else{
//                if(status==1){
//                    if(height[i]>temp){
//                        sCount++;
//                        status=2;
//                    }
//                }else{
//                    if(height[i]<temp){
//                        sCount++;
//                        status=1;
//                        if(temp>=height[start]){
//                            sCount=0;
//                            water+=countWater(start,end,height);
//                            start=i-1;
//                        }
//                    }
//                }
//            }
//            temp=height[i];
//            end++;
//        }
//        while(end-1>0&&height[end]<height[end-1]){
//            end--;
//        }
//        if(sCount>0){
//            water+=countWater(start,end,height);
//        }
//        return water;
//    }

    public int trap(int[] height) {
        int len=height.length;
        if(len<=0){
            return 0;
        }
        int water=0;
        int start=0;
        int end=len-1;
        //掐头
        while(start+1<len&&height[start]<=height[start+1]){
            start++;
        }
        //去尾
        while(end-1>=0&&height[end]<=height[end-1]){
            end--;
        }
        if(start==len-1){
            return 0;
        }
        //mark标记数组
        int[] leftMark=new int[end-start+1];
        int[] rightMark=new int[end-start+1];
        leftMark[0]=height[start];
        rightMark[end-start]=height[end];
        for(int i=start+1;i<=end;i++){
            leftMark[i-start]=Math.max(leftMark[i-1-start],height[i]);
        }
        for(int i=end-1;i>=start;i--){
            rightMark[i-start]=Math.max(rightMark[i+1-start],height[i]);
        }
        for(int i=0;i<end-start+1;i++){
            water+=Math.min(leftMark[i],rightMark[i])-height[i+start];
        }
        return water;
    }

    public int countWater(int start,int end,int[] height){
        int count=0;
        int min=height[start];
        if(height[start]>height[end]){
            min=height[end];
        }
        for(int i=start+1;i<end;i++){
            if(height[i]<min){
                count+=(min-height[i]);
            }
        }
        System.out.println(start+"|||"+end);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        Num42 num42=new Num42();
        int[] a={0,3,4,4,6,6};
        System.out.println(num42.trap(a));
    }
}

/*
         9   6   8   8   5   6  3
 */
