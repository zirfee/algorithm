package Strings;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int len=s.length();
        String str="";
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrom(s,i,j)){
                    if(j-i+1>str.length()){
                        str=s.substring(i,j+1);
                    }
                }
            }
        }
         return str;
    }

    public Boolean isPalindrom(String s,int start,int end){
       while(start<=end) {
           if (s.charAt(start) != s.charAt(end)) return false;
           start++;
           end--;
       }
       return true;
    }

}
