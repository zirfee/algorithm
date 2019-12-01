package Strings;

public class 回文数字 {
    public boolean isPalindrome(int x) {
        int c =x;
        int result=0;
        while (x>0) {
            int para = x % 10;
            x /= 10;
            result = result * 10 + para;
        }
        if (result==c) return true; 
        return false;
    }
}
