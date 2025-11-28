package arrays;

import java.util.Collections;
import java.util.stream.Collectors;

public class LargestNumberInKSwaps {
     public static void main(String[] args) {
//          String s = "1234567";
//          int k = 4;
          //7654321
//          String s = "3435335";
//          int k = 3;
          //5543333
          String s = "1034";
          int k = 8;
          //4301
          System.out.println(findMaximumNum(s, k));
     }

     public static String findMaximumNum(String s, int k) {
          int n = s.length();
          if (k == n || k > n) {
               return s.chars().mapToObj(c -> (char) c)
                    .sorted(Collections.reverseOrder())
                    .map(String::valueOf).collect(Collectors.joining());
          }
          char[] arr = s.toCharArray();
          for (int i = 0; i < k; i++) {
               int maxElement = Integer.MIN_VALUE;
               int pointer = 0;
               for (int j = i + 1; j < n; j++) {
                    maxElement = Math.max(maxElement, arr[j]);
                    if (arr[i] < maxElement && arr[j] >= maxElement) {
                         pointer = j;
                    }
               }
               if (arr[i] < maxElement) {
                    char temp = arr[i];
                    arr[i] = arr[pointer];
                    arr[pointer] = temp;
               }
          }
          return new String(arr);
     }
}
