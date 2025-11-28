package arrays;

import java.util.*;

public class Two_Sum {
     public static void main(String[] args) {
          System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 7)));
          System.out.println(Arrays.toString(twoSumUsingHashMap(new int[]{-2, 1, -3, 10, -1, 2, 1, -5, 3}, 7)));
          System.out.println(Arrays.toString(twoSumUsingTwoPointer(new int[]{-2, 1, -3, 10, -1, 2, 1, -5, 3}, 7)));
     }

     public static int[] twoSum(int[] nums, int target) {
          for (int i = 0; i < nums.length - 1; i++) {
               for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                         return new int[]{nums[i], nums[j]};
                    }
               }
          }
          return new int[]{};
     }

     public static int[] twoSumUsingTwoPointer(int[] nums, int target) {
          int left = 0;
          int right = nums.length - 1;
          while (right > left) {
               int sum = nums[left] + nums[right];
               if (sum == target) {
                    return new int[]{nums[left], nums[right]};
               } else if (sum < target) {
                    left++;
               } else {
                    right--;
               }
               left++;
          }
          return new int[]{};
     }

     public static int[] twoSumUsingHashMap(int[] nums, int target) {
          Map<Integer, Integer> map = new HashMap<>();
          for (int i = 0; i < nums.length; i++) {
               int complement = target - nums[i];
               if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
               }
               map.put(nums[i], i);
          }
          return new int[]{};
     }
}
