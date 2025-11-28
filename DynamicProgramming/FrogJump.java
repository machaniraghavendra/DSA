package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
     public static void main(String[] args) {
          int[] arr = {10, 20, 30, 10};
          minEnergySpentByFrog(arr);
     }

     private static void minEnergySpentByFrog(int[] arr) {
          int[] dpArr = new int[arr.length];
          Arrays.fill(dpArr, -1);
          System.out.println(memorizationBackTrack(arr, arr.length - 1, dpArr));
          System.out.println(tabulation(arr, arr.length - 1, dpArr));
          System.out.println(tabulationWithoutDp(arr, arr.length - 1));
     }

     // T = O(N) and S = O(N) stack + O(N) dp
     private static int memorizationBackTrack(int[] arr, int index, int[] dp) {
          if (index == 0) return 0;
          if (dp[index] != -1) return dp[index];
          int left = memorizationBackTrack(arr, index - 1, dp) + Math.abs(arr[index] - arr[index - 1]);
          int right = Integer.MAX_VALUE;
          if (index > 1) right = memorizationBackTrack(arr, index - 2, dp) + Math.abs(arr[index] - arr[index - 2]);
          dp[index] = Math.min(left, right);
          return dp[index];
     }

     // T = O(N) and S = O(N) #dp
     private static int tabulation(int[] arr, int index, int[] dp) {
          for (int i = 0; i < index; i++) {
               if (i == 0) {
                    dp[i] = 0;
                    continue;
               }
               int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
               int right = Integer.MAX_VALUE;
               if (i > 1) right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
               dp[i] = Math.min(left, right);
          }
          return dp[index - 1];
     }

     // T = O(N) and S = O(1)
     private static int tabulationWithoutDp(int[] arr, int index) {
          int curr = 0, prev1 = 0, prev2 = 0;
          for (int i = 1; i < index; i++) {
               int left = prev1 + Math.abs(arr[i] - arr[i - 1]);
               int right = Integer.MAX_VALUE;
               if (i > 1) right = prev2 + Math.abs(arr[i] - arr[i - 2]);
               curr = Math.min(left, right);
               prev1 = curr;
               prev2 = prev1;
          }
          return curr;
     }
}
