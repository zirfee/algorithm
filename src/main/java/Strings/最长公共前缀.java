package Strings;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if(len ==0) return "";
        if (len==1) return strs[0];
        String[] sA = new String[1];
        sA[0]=strs[0];
        for(int i=1;i<len;i++){
        String s0 =  twoCommonPrefix(sA[0],strs[i]);
           if(s0=="") return "";
           sA[0]=s0;
      }
      return sA[0];
    }

    public String twoCommonPrefix(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<len;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else {
                break;
            }
        }
        return new String(sb);
    }
}
