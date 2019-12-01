package Strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
}
