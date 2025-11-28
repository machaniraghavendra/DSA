package arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
     public static void main(String[] args) {
          int lower = 0, upper = 14;
          int[] arr = {3, 6, 10, 12};
          //4->5, 7->9, 11
//          System.out.println(Arrays.toString(findMissingRanges(arr, lower, upper)));
          System.out.println(findMissingRanges(arr, lower, upper));
     }

     private static List<String> findMissingRanges(int[] arr, int lower, int upper) {
          List<String> result = new ArrayList<>();
          int left = 0;
          int min = 0;
          int max = 0;

          if (arr[left] > lower) {
               result.add(lower + "->" + (arr[left] - 1));
          }

          for (int right = 1; right < arr.length; right++) {
               if (arr[right] - arr[left] != 1) {
                    min = arr[left] + 1;
                    max = arr[right] - 1;
                    if (min == max) {
                         result.add(String.valueOf(min));
                    } else {
                         result.add(min + "->" + max);
                    }
               }
               left++;
          }
          if (arr[arr.length - 1] != upper - 1) {
               result.add(arr[arr.length - 1] + 1 + "->" + upper);
          }
          return result;
     }
}
