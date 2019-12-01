package Strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {
    @Test
    public void t(){
        z字变换 z = new z字变换();
        System.out.println(z.convert("PAYPALISHIRING",3));
    }
   @Test
   public void t1(){
       字符串里取整数 z= new 字符串里取整数();
        System.out.println(z.myAtoi(" -42"));

   }
   @Test
   public void tt(){
       Set<String> set = new HashSet<>();
       set.add("1");
       set.stream().forEach(System.out::println);
   }
   @Test
   public void  t2(){
        new 回文数字().isPalindrome(121);
   }
   @Test
   public void t3(){
       Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
       Matcher m = p.matcher("java-JAVA-JaVa");
      System.out.println( m.replaceAll("替换"));
   }
}
