package arrays;

import java.util.Arrays;

public class RotateArrayByParts {
     public static void main(String[] args) {
          int[] arr = {1, 2, 3, 4, 5, 6, 7};
          int k = 3;
//          System.out.println(Arrays.toString(getReversePartsOfArray(arr, k)));
          rotate(arr, k);
          System.out.println(Arrays.toString(arr));
     }

     private static int[] getReversePartsOfArray(int[] arr, int k) {
          if (arr.length < k || k == arr.length) return arr;
          int[] frontArray = Arrays.copyOfRange(arr, 0, arr.length - k);
          int[] lastArray = Arrays.copyOfRange(arr, arr.length - k, arr.length);
          int s = 0;
          for (int i = 0; i < arr.length; i++) {
               if (i < lastArray.length) arr[i] = lastArray[i];
               else arr[i] = frontArray[s++];
          }
          return arr;
     }

     private static void rotate(int[] arr, int k) {
          k %= arr.length;
          reverse(arr, 0, arr.length - 1);
          reverse(arr, 0, k - 1);
          reverse(arr, k, arr.length - 1);
//          return arr;
     }

     private static void reverse(int[] arr, int left, int right) {
          while (left < right) {
               int temp = arr[left];
               arr[left++] = arr[right];
               arr[right--] = temp;
          }
     }
}
