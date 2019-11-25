package Strings;

import java.util.ArrayList;
import java.util.List;

public class z字变换 {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        StringBuilder result = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>();
        int len=s.length();

        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }


        int which=1;
        int flag=-1;
       for(int i=0;i<len;i++){
           which+=flag;
           list.get(which).append(s.charAt(i));
           if(which==numRows-1 || which==0)  flag=-flag ;
       }


       for (StringBuilder builder : list){
               result.append(builder);
           }
        return new String(result);
    }
}
