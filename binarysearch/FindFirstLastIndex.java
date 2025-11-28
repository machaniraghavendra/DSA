package binarysearch;

import java.util.Arrays;

public class FindFirstLastIndex {
     public static void main(String[] args) {
//          int[] arr = {5, 7, 7, 8, 8, 10};
          int[] arr = {8, 8, 8, 8, 8, 8};
          int target = 8;
          System.out.println(Arrays.toString(getFirstLastIndex(arr, target)));
     }

     private static int[] getFirstLastIndex(int[] arr, int target) {
          int[] result = new int[]{-1, -1};
          if (arr.length == 0) return result;
          int firstIndex = getFirstLastIndex(arr, target, true);
          int lastIndex = getFirstLastIndex(arr, target, false);
          result[0] = firstIndex;
          result[1] = lastIndex;
          return result;
     }

     private static int getFirstLastIndex(int[] arr, int target, boolean first) {
          int low = 0, high = arr.length - 1;
          int index = -1;
          while (low <= high) {
               int mid = low + (high - low) / 2;
               if (arr[mid] == target) {
                    index = mid;
                    if (first) {
                         high = mid - 1;
                    } else {
                         low = mid + 1;
                    }
               } else if (arr[mid] < target) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }
          return index;
     }

//     private static int getFirstIndex(int[] arr, int target) {
//          int low = 0, index = -1, high = arr.length - 1;
//          while (low <= high) {
//               int mid = low + (high - low) / 2;
//               if (arr[mid] == target) {
//                    index = mid;
//
//               } else if (arr[mid] < target) {
//                    low = mid + 1;
//               } else {
//                    high = mid - 1;
//               }
//          }
//          return index;
//     }
}
