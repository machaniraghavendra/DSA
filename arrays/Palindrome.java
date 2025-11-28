package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {

     public static void main(String[] args) {
//          System.out.println(longestPalindrome("babad"));

          checkWait();

     }

     private static void checkWait() {
          List<String> stringList = Arrays.asList("RAGHU","RAGHU1");

          System.out.println(stringList);
     }

     public static String longestPalindrome(String s) {
          if (s == null || s.isEmpty()) return "";

          int start = 0, end = 0;

          for (int i = 0; i < s.length(); i++) {
               int len1 = expandAroundCenter(s, i, i);       // Odd length
               int len2 = expandAroundCenter(s, i, i + 1);   // Even length
               int len = Math.max(len1, len2);

               if (len > (end - start)) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
               }
          }

          return s.substring(start, end + 1);
     }

     private static int expandAroundCenter(String s, int left, int right) {
          while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
               left--;
               right++;
          }
          return right - left - 1;  // Actual length
     }
}
