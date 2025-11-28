package arrays;

import java.util.Arrays;

public class RemoveDuplicates {

     public static void main(String[] args) {
          System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5})));
     }

     public static int[] removeDuplicates(int[] arr) {
          int n = arr.length;
          if (n == 0 || n == 1) {
               return arr;
          }

          // Sort the array
          for (int i = 0; i < n - 1; i++) {
               for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                         // Swap arr[j] and arr[j+1]
                         int temp = arr[j];
                         arr[j] = arr[j + 1];
                         arr[j + 1] = temp;
                    }
               }
          }

          // Remove duplicates
          int[] temp = new int[n];
          int j = 0;
          for (int i = 0; i < n - 1; i++) {
               if (arr[i] != arr[i + 1]) {
                    temp[j++] = arr[i];
               }
          }
          temp[j++] = arr[n - 1];

          // Create the result array with the correct size
          int[] result = new int[j];
          for (int i = 0; i < j; i++) {
               result[i] = temp[i];
          }

          return result;
     }
}
