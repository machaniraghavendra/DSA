package DynamicProgramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacentElements {
    
     public static void main(String[] args) {
          MaxSumOfNonAdjacentElements maxSumOfNonAdjacentElements = new MaxSumOfNonAdjacentElements() ;
          int[] arr = {2, 3, 4, 9, 12};
//          maxSumOfNonAdjacentElements(arr);
     }

     private static void maxSumOfNonAdjacentElements(int[] arr) {
          int[] dp = new int[arr.length];
          Arrays.fill(dp, -1);
          System.out.println(maxSumOfNonAdjacentElementsBackTrack(arr, arr.length - 1));
          System.out.println(maxSumOfNonAdjacentElementsBackTrackMemorization(arr, arr.length - 1, dp));
          System.out.println(maxSumOfNonAdjacentElementsBackTrackTabulationMemorization(arr, arr.length, dp));
          System.out.println(maxSumOfNonAdjacentElementsBackTrackTabulation(arr, arr.length - 1));
     }

     // T = O(2^N) and S = O(N/2) * O(N/2) stack
     private static int maxSumOfNonAdjacentElementsBackTrack(int[] arr, int n) {
          if (n == 0) return arr[n];
          if (n < 0) return 0;
          int pick = arr[n] + maxSumOfNonAdjacentElementsBackTrack(arr, n - 2);
          int notPick = maxSumOfNonAdjacentElementsBackTrack(arr, n - 1);
          return Math.max(pick, notPick);
     }

     // T = O(N) and S = O(N) stack + O(N)
     private static int maxSumOfNonAdjacentElementsBackTrackMemorization(int[] arr, int n, int[] dp) {
          if (n == 0) return arr[n];
          if (n < 0) return 0;
          if (dp[n] != -1) return dp[n];
          int pick = arr[n] + maxSumOfNonAdjacentElementsBackTrackMemorization(arr, n - 2, dp);
          int notPick = maxSumOfNonAdjacentElementsBackTrackMemorization(arr, n - 1, dp);
          dp[n] = Math.max(pick, notPick);
          return dp[n];
     }

     // T = O(N) and S = O(N) #dp
     private static int maxSumOfNonAdjacentElementsBackTrackTabulationMemorization(int[] arr, int n, int[] dp) {
          dp[0] = arr[0];
          for (int i = 1; i < n; i++) {
               int pick = arr[i];
               if (i > 1)
                    pick = pick + dp[i - 2];
               int notPick = dp[i - 1];
               dp[i] = Math.max(pick, notPick);
          }
          return dp[n - 1];
     }

//     int[] arr = {2, 3, 4, 9, 12};
     // T = O(N) and S = O(1)
     private static int maxSumOfNonAdjacentElementsBackTrackTabulation(int[] arr, int n) {
          int curr = 0, prev = arr[0], prev1 = 0;
          for (int i = 1; i <= n; i++) {
               int pick = arr[i] + prev1;
               int notPick = prev;
               curr = Math.max(pick, notPick);
               prev1 = prev;
               prev = curr;
          }
          return curr;
     }

     static class Solution {
          public int removeDuplicates(int[] nums) {
               if(nums.length == 0) return 0;
               int left = 0, right = 1;
               while(right < nums.length){
                    if(nums[right] != nums[left]){
                         left ++;
                         nums[left] = nums[right];
                    }
                    right++;
               }
               return left+1;
          }

          public static void main(String[] args) {
               int[] nums = {0,0,1,1,1,2,2,3,3,4};
               Solution solution = new Solution();
               solution.removeDuplicates(nums);
          }
     }
}
