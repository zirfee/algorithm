package Strings;

public class 最多水容器 {
    public int maxArea(int[] height) {
       int len = height.length;
       int start=0;
       int end=len-1;

       int max=0;
       while(start<end){
           if(height[start]<height[end]){
               max=Math.max(max,height[start]*(end-start));
               start++;
           }else {
               max=Math.max(max,height[end]*(end-start));
               end--;
           }
       }
     return max;
    }
}
