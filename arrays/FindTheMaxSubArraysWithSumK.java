package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheMaxSubArraysWithSumK {
     public static void main(String[] args) {
          int[] arr1 = {7, 3, 2, 5, 3, 8, 2, 0, 1, 10};
          int k = 10;
          var result = getMaxSubArraysWithSumK(new int[]{7, 3, 2, 5, 3, 8, 2, 0, 1, 10}, k);
          for (int[] arr : result) {
               for (int j : arr) {
                    System.out.print(j + ",");
               }
               System.out.println();
          }
          getMaxSum(arr1, k);
//          { {7,3}, {3,2,5}, {2,5,3}, {8,2}, {8,2,0} ,{10} }
     }

     private static List<int[]> getMaxSubArraysWithSumK(int[] arr, int k) {
          List<int[]> result = new ArrayList<>();
          int i = 0, j = 0;
          int sum = 0;
          while (j < arr.length) {
//               if (sum == k) {
//                    sum = sum - ints[i];
//                    result.add(Arrays.copyOfRange(ints, i, j));
//                    i++;
//               } else if (sum > k) {
//                    sum = sum - ints[i++];
//               } else {
//                    sum = sum + ints[j++];
//               }
               sum = sum + arr[j];
               while (sum > k && i <= j) {
                    sum = sum - arr[i];
                    i++;
               }
               if (sum == k) {
                    result.add(Arrays.copyOfRange(arr, i, j + 1));
               }
               j++;
          }
          return result;
     }

     private static void getMaxSum(int[] arr, int k) {
          int n = arr.length;
          int right = 0;
          int left = 0;
          int sum = 0;
          while (right < n) {
               sum = sum + arr[right];
               while (sum > k && left <= right) {
                    sum = sum - arr[left];
                    left++;
               }
               if (sum == k) {
                    System.out.print("[");
                    for (int i = left; i <= right; i++) {
                         if (i == right) {
                              System.out.print(arr[i]);
                         } else
                              System.out.print(arr[i] + " ");
                    }
                    System.out.print("]");
                    System.out.println();
               }
               right++;
          }
     }
}
