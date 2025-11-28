package arrays;

import java.util.Arrays;

public class MoveNegativesToOneSide {
     public static void main(String[] args) {
          int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
          System.out.println(Arrays.toString(moveNegativesToFirst(arr)));
          System.out.println(Arrays.toString(moveNegativesToLast(arr)));
     }

     private static int[] moveNegativesToLast(int[] arr) {
          int left = arr.length - 1;
          for (int right = arr.length - 1; right >= 0; right--) {
               if (arr[right] < 0) {
                    swap(arr, right, left--);
               }
          }
          return arr;
     }

     private static int[] moveNegativesToFirst(int[] arr) {
          int left = 0;
          for (int right = 0; right < arr.length; right++) {
               if (arr[right] < 0) {
                    swap(arr, right, left);
               }
          }
          return arr;
     }

     public static void swap(int[] arr, int right, int left) {
          int temp = arr[right];
          arr[right] = arr[left];
          arr[left] = temp;
     }
}
