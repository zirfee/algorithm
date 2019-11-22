package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长不重复字符串 {
      /*  public int lengthOfLongestSubstring(String s) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    if (isUnique(s, i, j)) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            return max;
        }


        //判断下标（i,j）内字符串是否重复
        public Boolean isUnique(String s, int i,int j){
            Set<Character> hashSet = new HashSet();
            for(int a=i;a<j;a++){
                if(hashSet.contains(s.charAt(a))){
                    return false;
                }
                hashSet.add(s.charAt(a));
            }
            return true;
        }*/
        //滑动窗口优化算法
       public int optimistic(String s){
            Map<Character,Integer> map = new HashMap();
           int max =0;
           for(int i=0,j=0;j<s.length();j++){
               if(map.containsKey(s.charAt(j))){
                   i=Math.max(map.get(s.charAt(j))+1,i);
               }
               max=Math.max(j-i+1,max);
               map.put(s.charAt(j),j);
           }
           return max;
       }

}



























