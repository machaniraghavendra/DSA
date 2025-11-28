package arrays;

import java.util.Arrays;

public class MoveZerosToLast {
     public static void main(String[] args) {
          int[] nums = {0, 2, 3, 0, 5, 0, 7, 9, 10, 5, 0};
//          int[] nums = {2, 3, 5, 7, 9, 10, 5};
          System.out.println(Arrays.toString(moveZerosToLastWithTwoPointer(nums)));
     }

     //TIme O(N), Space O(1)
     private static int[] moveZerosToLastWithTwoPointer(int[] nums) {
          int j = 0;
          int n = nums.length;
          for (int i = 0; i < n; i++) {
               if (nums[i] != 0) {
                    if (i != j) {
                         swapValuesInArray(nums, i, j);
                    }
                    j++;
               }
          }
          return nums;
     }

     private static void swapValuesInArray(int[] nums, int from, int to) {
          int temp = nums[from];
          nums[from] = nums[to];
          nums[to] = temp;
     }

     //TIme O(N), Space O(1)
     public static void moveZeroesOverwrite(int[] nums) {
          int pos = 0;
          for (int num : nums) {
               if (num != 0) {
                    nums[pos++] = num;
               }
          }
          while (pos < nums.length) {
               nums[pos++] = 0;
          }
     }
}
