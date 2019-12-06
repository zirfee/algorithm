package Strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {
    @Test
    public void  z字变换(){
        z字变换 z = new z字变换();
        System.out.println(z.convert("PAYPALISHIRING",3));
    }
   @Test
   public void  字符串里取整数(){
       字符串里取整数 z= new 字符串里取整数();
        System.out.println(z.myAtoi(" -42"));

   }
   @Test
   public void  回文数字(){
        new 回文数字().isPalindrome(121);
   }
   @Test
   public void t3(){
       Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
       Matcher m = p.matcher("java-JAVA-JaVa");
      System.out.println( m.replaceAll("替换"));
   }
   @Test
   public void 最多水容器(){
        int[] se={1,8,6,2,5,4,8,3,7};
       System.out.println( new 最多水容器().maxArea(se));
    }
}
