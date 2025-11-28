package arrays;

public class CheckPalindromeWithoutConvertingToString {
     public static void main(String[] args) {
          int n = 10501;
          System.out.println(isPalindrome(105501));
     }

     private static boolean isPalindrome(int num) {
          if (num < 0) return false;
          if (num < 10) return true;
          int length = String.valueOf(num).length();
          int divisor = (int) Math.pow(10, length - 1);
          while (num > 0) {
               int leftDigit = num / divisor;
               int rightDigit = num % 10;
               if (leftDigit != rightDigit) return false;
               num = (num % divisor) / 10;
               divisor = divisor / 100;
          }
          return true;
     }
}
