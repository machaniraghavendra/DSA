package arrays;

import java.util.*;

public class ThreeSum {
     public static void main(String[] args) {
          int[] arr = new int[]{-1, -2, 3, -3, 0, 4, -4, 5, 6, 1, -1, -2, 3};
          var result = printThreeSumArrays(arr, 3);
          for (int[] ants : result) {
               System.out.println(Arrays.toString(ants));
          }
     }

     private static Set<int[]> printThreeSumArrays(int[] arr, int n) {
          Set<int[]> result = new HashSet<>();
          int sum = 0;
          for (int i = 0; i < n; i++) {
               sum += arr[i];
               if (sum == 0) {
                    result.add(getSmallArray(arr, 0, n));
               }
          }
          for (int i = n; i < arr.length; i++) {
               sum += arr[i] - arr[i - n];
               if (sum == 0) {
                    result.add(getSmallArray(arr, i - n + 1, n));
               }
          }

          return result;
     }

     private static int[] getSmallArray(int[] arr, int startPos, int lengthOfNewArray) {
          int[] result = new int[lengthOfNewArray];
          System.arraycopy(arr, startPos, result, 0, lengthOfNewArray);
          return result;
     }
}
