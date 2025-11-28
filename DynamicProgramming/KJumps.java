package DynamicProgramming;

import java.util.Arrays;

public class KJumps {
     public static void main(String[] args) {
          int[] arr = {2, 3, 1, 1, 4};
          int k = 3;
          kJumps(arr, k);
     }

     private static void kJumps(int[] arr, int k) {
          int minJump = Integer.MAX_VALUE;
          for (int i = 1; i <= k; i++) {
               minJump = memorizationBackTrack(arr, arr.length - 1, i, minJump);
          }
          System.out.println(minJump);
     }

     private static int memorizationBackTrack(int[] arr, int index, int i, int minJump) {
          if (index <= 0) return 0;
          if (index - i >= 0) {
               int left = memorizationBackTrack(arr, index - i, i, minJump) + Math.abs(arr[index] - arr[index - i]);
               minJump = Math.min(left, minJump);
          }
          return minJump;
     }
}
